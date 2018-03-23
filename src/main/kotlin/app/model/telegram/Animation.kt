package app.model.telegram

data class Animation(
    val file_id: String,
    val thumb: PhotoSize?,
    val file_name: String?,
    val mime_type: String?,
    val file_size: Int?
)
