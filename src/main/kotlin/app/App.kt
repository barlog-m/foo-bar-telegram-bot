package app

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(vararg args: String) {
    val mainThread = Thread.currentThread()

    config()

    Runtime.getRuntime().addShutdownHook(Thread({
        Server.stop()
    }, "shutdown-hook"))

    try {
        Server.start(port(*args))
    } catch (ex: RuntimeException) {
        logger.error("server start error", ex)
        System.exit(-1)
    }

    while(!mainThread.isInterrupted) {Thread.sleep(100)}
}
