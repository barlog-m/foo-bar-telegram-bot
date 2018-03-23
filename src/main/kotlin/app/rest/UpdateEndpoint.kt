package app.rest

import app.model.telegram.Update
import app.objectMapper
import app.service.onUpdate
import io.netty.handler.codec.http.HttpResponseStatus

val updatePost = Handler { req, resp ->
    req.receiveContent()
        .map { data ->
            objectMapper.readValue(data.content().array(), Update::class.java)
        }
        .subscribe { update -> onUpdate(update)  }

    resp.status(HttpResponseStatus.OK).send()
}
