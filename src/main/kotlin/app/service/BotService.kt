package app.service

import app.model.telegram.Update
import app.settings
import mu.KotlinLogging
import reactor.ipc.netty.http.client.HttpClient

private val logger = KotlinLogging.logger {}

fun message() {
    HttpClient
        .create("${settings.url}/")
}

fun onUpdate(update: Update) {
    logger.debug { "update: $update" }
}
