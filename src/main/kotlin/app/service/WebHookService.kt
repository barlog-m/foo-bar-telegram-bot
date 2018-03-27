package app.service

import app.model.telegram.Result
import app.model.telegram.WebHook
import app.model.telegram.WebhookInfo
import app.objectMapper
import app.settings
import com.fasterxml.jackson.core.type.TypeReference
import reactor.ipc.netty.http.client.HttpClient
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderNames.ACCEPT
import io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON
import mu.KotlinLogging
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger("WebHookService")

fun getWebhookInfo(): Mono<Result<WebhookInfo>> =
    HttpClient
        .create()
        .get("${settings.url}/getWebhookInfo", {
            it.addHeader(ACCEPT, APPLICATION_JSON)
        })
        .log()
        .flatMap {
            it.receive()
                .aggregate()
                .asByteArray()
                .map {
                    objectMapper.readValue<Result<WebhookInfo>>(it,
                        object: TypeReference<Result<WebhookInfo>>() {} )
                }
                .doOnNext {
                    logger.info { "getWebhookInfo: $it" }
                }
        }

fun registerWebHook(): Mono<WebhookInfo> =
    getWebhookInfo()
        .filter { it.ok }
        .map { it.result }
        .filter { it.url.isNotEmpty() }
        .doOnSuccess {
            HttpClient
                .create()
                .post("${settings.url}/setWebhook", {
                    it.addHeader(CONTENT_TYPE, APPLICATION_JSON)
                        .sendString(Mono.fromCallable({
                            objectMapper.writeValueAsString(
                                WebHook(url = settings.webHookUrl)
                            )
                        }))
                })
                .log()
                .doOnNext {
                    logger.info { "setWebhook" }
                }.subscribe()
        }
