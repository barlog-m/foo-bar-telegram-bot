package app.model.telegram

data class VideoNote(
    val file_id: String,
    val length: Int,
    val duration: Int,
    val thumb: PhotoSize?,
    val file_size: Int?
)
