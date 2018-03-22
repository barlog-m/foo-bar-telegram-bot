package app.rest

import app.service.info
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON
import io.netty.handler.codec.http.HttpResponseStatus
import mu.KotlinLogging

private val logger = KotlinLogging.logger("InfoEndpoint")

val infoGet = Handler { req, resp ->
    logger.debug { "http version: ${req.version()}" }
    resp
        .addHeader(CONTENT_TYPE, APPLICATION_JSON)
        .status(HttpResponseStatus.OK)
        .sendString(info())
}
