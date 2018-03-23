package app.model.telegram

data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    val text: String?,
    val text_entities: List<MessageEntity>?,
    val animation: Animation?
)
