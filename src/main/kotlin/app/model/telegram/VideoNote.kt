package app.model.telegram

data class VideoNote(
    val file_id: String,
    val length: Integer,
    val duration: Integer,
    val thumb: PhotoSize?,
    val file_size: Integer?
)
