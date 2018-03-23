package app.model.telegram

data class ChosenInlineResult(
    val result_id: String,
    val from: User,
    val location: Location?,
    val inline_message_id: String?,
    val query: String
)
