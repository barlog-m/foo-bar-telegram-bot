package app

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(vararg args: String) {
    appArgs = args.toList()

    val mainThread = Thread.currentThread()

    config()

    Runtime.getRuntime().addShutdownHook(Thread({
        Server.stop()
    }, "shutdown-hook"))

    try {
        Server.start(settings.port)
    } catch (ex: RuntimeException) {
        logger.error("server start error", ex)
        System.exit(-1)
    }

    mainThread.join()
}
