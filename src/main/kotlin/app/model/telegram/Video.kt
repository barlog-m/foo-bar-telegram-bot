package app.model.telegram

data class Video(
    val file_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumb: PhotoSize?,
    val mime_type: String?,
    val file_size: Int?
)
