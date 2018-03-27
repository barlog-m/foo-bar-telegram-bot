package app.service

import app.model.telegram.WebHook
import app.model.telegram.WebhookInfo
import app.objectMapper
import app.settings
import reactor.ipc.netty.http.client.HttpClient
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderNames.ACCEPT
import io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON
import reactor.core.publisher.Mono

fun getWebhookInfo(): Mono<WebhookInfo> =
    HttpClient
        .create(settings.url)
        .get("/getWebhookInfo", {
            it.addHeader(ACCEPT, APPLICATION_JSON)
        })
        .log()
        .flatMap {
            it.receive()
                .aggregate()
                .asByteArray()
                .map {
                    objectMapper.readValue(it, WebhookInfo::class.java)
                }
        }

fun registerWebHook(): Mono<Void> =
    getWebhookInfo()
        .thenEmpty {
            HttpClient
                .create(settings.url)
                .post("/setWebhook", {
                    it.addHeader(CONTENT_TYPE, APPLICATION_JSON)
                        .sendString(Mono.fromCallable({
                            objectMapper.writeValueAsString(
                                WebHook(url = settings.webHookUrl)
                            )
                        }))
                })
                .log()
        }
