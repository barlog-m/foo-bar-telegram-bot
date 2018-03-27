package app.model.telegram

data class InlineKeyboardButton(
    val text: String,
    val url: String?,
    val callback_data: String?,
    val switch_inline_query: String?,
    val switch_inline_query_current_chat: String?,
    val callback_game: CallbackGame?,
    val pay: Boolean?
)
