package app.model.telegram

data class CallbackQuery(
    val id: String,
    val from: User,
    val message: Message?,
    val inline_message_id: String?,
    val chat_instance: String,
    val data: String?,
    val game_short_name: String?
)
