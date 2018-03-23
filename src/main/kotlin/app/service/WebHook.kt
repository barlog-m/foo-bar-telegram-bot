package app.service

import app.model.telegram.WebHook
import app.objectMapper
import app.settings
import reactor.ipc.netty.http.client.HttpClient
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON
import reactor.core.publisher.Mono

fun registerWebHook() {
    HttpClient
        .create(settings.url)
        .post("/setWebhook", { req ->
            req.addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .sendString(Mono.fromCallable({
                    objectMapper.writeValueAsString(
                        WebHook(url = settings.webHookUrl)
                    )
                }))
        })
}
