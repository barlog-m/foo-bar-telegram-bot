package app.model.telegram

data class MessageEntity(
    val type: String,
    val offset: Integer,
    val length: Integer,
    val url: String?,
    val user: User?
)
