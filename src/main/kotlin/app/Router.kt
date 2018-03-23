package app

import app.rest.infoGet
import app.rest.updatePost
import reactor.ipc.netty.http.server.HttpServerRoutes
import java.util.function.Consumer

fun router() = Consumer<HttpServerRoutes> { routes ->
    routes
        .get("/info", infoGet)
        .post("/${settings.token}", updatePost)
}
