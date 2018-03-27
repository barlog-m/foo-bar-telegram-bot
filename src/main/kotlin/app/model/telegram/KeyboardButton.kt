package app.model.telegram

data class KeyboardButton(
    val text: String,
    val request_contact: Boolean?,
    val request_location: Boolean?
)
