package app.model.telegram

data class SendMessage(
    val chat_id: String,
    val text: String,
    val parse_mode: ParseMode? = null,
    val disable_web_page_preview: Boolean? = null,
    val disable_notification: Boolean? = null,
    val reply_to_message_id: Int? = null,
    val reply_markup: ReplyMarkup? = null
)
