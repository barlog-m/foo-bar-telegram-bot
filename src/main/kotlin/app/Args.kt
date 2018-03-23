package app

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun parse(args: List<String>): Map<String, String> =
    args
        .filter {
            it.isNotBlank() && it[0] == "-".single() && it[1] == "-".single()
        }
        .map {
            val v = it.substring(2).split("=")
            if (v.size > 1) {
                Pair(v[0], v[1])
            } else {
                Pair(v[0], "")
            }
        }
        .toMap()

fun port(args: Map<String, String>): Int {
    val port = try {
        args
            .filter { (k, _) -> k == "port" }
            .map { (_, v) ->
                try {
                    v.toInt()
                } catch (e: NumberFormatException) {
                    -1
                }
            }
            .first()
    } catch (e: NoSuchElementException) {
        -1
    }

    return if (port != -1 && port >= 0 && port < 65535) {
        port
    } else {
        8080
    }
}

fun webHookToken(args: Map<String, String>): String {
    val token = try {
        args
            .filter { (k, _) -> k == "wh_token" }
            .map { (_, v) -> v }
            .first()
    } catch (e: NoSuchElementException) {
        ""
    }

    return if (token.isNotBlank()) {
        token
    } else {
        logger.warn { "web hook token does not set" }
        "none"
    }
}

fun authToken(args: Map<String, String>): String {
    val token = try {
        args
            .filter { (k, _) -> k == "auth_token" }
            .map { (_, v) -> v }
            .first()
    } catch (e: NoSuchElementException) {
        ""
    }

    return if (token.isNotBlank()) {
        token
    } else {
        logger.warn { "auth token does not set" }
        "none"
    }
}
