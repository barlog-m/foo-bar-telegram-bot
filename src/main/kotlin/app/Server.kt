package app

import app.service.registerWebHook
import mu.KLogging
import reactor.ipc.netty.http.server.HttpServer
import reactor.ipc.netty.tcp.BlockingNettyContext

object Server : KLogging() {
    private lateinit var context: BlockingNettyContext
    private var started = false

    fun start() = start("0.0.0.0", 8080)

    fun start(port: Int) = start("0.0.0.0", port)

    fun start(bindAddress: String) = start(bindAddress, 0)

    fun start(bindAddress: String, port: Int) {
        val server = HttpServer.builder()
            .bindAddress(bindAddress)
            .port(port)
            .build()

        context = server.startRouter(router())
        started = true
        logger.info { "server started $bindAddress:$port" }
        registerWebHook()
    }

    fun stop() {
        if (started) {
            logger.info { "server shutdown" }
            started = false
            context.shutdown()
        }
    }

    fun isStarted() = started

    fun port() = context.port

    fun host(): String = context.host
}
