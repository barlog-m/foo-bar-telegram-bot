package app.model.telegram

data class Audio(
    val file_id: String,
    val duration: Int,
    val performer: String?,
    val title: String?,
    val mime_type: String?,
    val file_size: Integer?
)
