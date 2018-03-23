package app.model.telegram

data class Video(
    val file_id: String,
    val width: Integer,
    val height: Integer,
    val duration: Integer,
    val thumb: PhotoSize?,
    val mime_type: String?,
    val file_size: Integer?
)
