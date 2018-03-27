package app.rest

import app.model.telegram.Update
import app.objectMapper
import app.service.onUpdate
import io.netty.handler.codec.http.HttpResponseStatus
import mu.KotlinLogging
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger("UpdateEndpoint")

val updatePost = Handler { req, resp ->
    req
        .receive()
        .aggregate()
        .asByteArray()
        .flatMap {
            Mono.fromCallable { objectMapper.readValue(it, Update::class.java) }
        }
        .flatMap {
            logger.info { "update $it" }
            onUpdate(it)
        }
        .onErrorResume {
            resp.status(HttpResponseStatus.BAD_REQUEST).send()
        }
}
