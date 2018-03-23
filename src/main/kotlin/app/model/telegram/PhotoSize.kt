package app.model.telegram

data class PhotoSize(
    val file_id: String,
    val width: Integer,
    val height: Integer,
    val file_size: Integer?
)
