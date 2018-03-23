package app.rest

import app.service.info
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON
import io.netty.handler.codec.http.HttpResponseStatus

val infoGet = Handler { _, resp ->
    resp
        .addHeader(CONTENT_TYPE, APPLICATION_JSON)
        .status(HttpResponseStatus.OK)
        .sendString(info())
}
