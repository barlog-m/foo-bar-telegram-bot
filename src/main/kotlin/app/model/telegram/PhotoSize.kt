package app.model.telegram

data class PhotoSize(
    val file_id: String,
    val width: Int,
    val height: Int,
    val file_size: Int?
)
