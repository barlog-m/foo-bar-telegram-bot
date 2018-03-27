package app.service

import app.commands
import app.model.telegram.Message
import app.model.telegram.ParseMode
import app.model.telegram.SendMessage
import app.model.telegram.Update
import app.model.telegram.User
import app.objectMapper
import app.settings
import reactor.core.publisher.Mono
import reactor.ipc.netty.http.client.HttpClient
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON
import mu.KotlinLogging

private val logger = KotlinLogging.logger("BotService")

fun startCommand(user: User) =
    sendMessage(
        SendMessage(
            chat_id = user.id.toString(),
            text = "Welcome!"
        )
    )

fun helpCommand(user: User) =
    sendMessage(
        SendMessage(
            chat_id = user.id.toString(),
            text = """
                /help
                /hi
            """.trimMargin(),
            parse_mode = ParseMode.Markdown
        )
    )

fun hiCommand(user: User) =
    sendMessage(
        SendMessage(
            chat_id = user.id.toString(),
            text = "Hi, **${user.first_name}**",
            parse_mode = ParseMode.Markdown
        )
    )

fun sendMessage(sendMessage: SendMessage): Mono<Void> =
    HttpClient
        .create()
        .post("${settings.url}/sendMessage", {
            it.addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .sendString(Mono.fromCallable({
                    objectMapper.writeValueAsString(sendMessage)
                }))
        })
        .log()
        .then()

fun onUpdate(update: Update): Mono<Void> {
    if (update.message != null) {
        val message: Message = update.message
        if (message.from != null) {
            val user: User = message.from
            if (!user.is_bot && message.text != null && message.text.isNotBlank()) {
                val text: String = message.text
                val data = text.split(" ")
                if (data.isNotEmpty()) {
                    if (data.first().first() == '/') {
                        val command = data.first().trim().substring(1)
                        logger.info { "got command: $command" }
                        if (commands.containsKey(command)) {
                            return commands[command]!!(user)
                        }
                    }
                }
            }
        }
    }

    return Mono.empty()
}
