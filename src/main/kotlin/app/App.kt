package app

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(vararg args: String) {
    appArgs = args.toList()

    config()

    logger.info { "$settings" }

    Runtime.getRuntime().addShutdownHook(Thread({
        Server.stop()
    }, "shutdown-hook"))

    try {
        Server.start(settings.port, postStartInitializeHook())
    } catch (ex: RuntimeException) {
        logger.error("server start error", ex)
        System.exit(-1)
    }

    Thread.currentThread().join()
}
