package app.model.telegram

data class Voice(
    val file_id: String,
    val duration: Int,
    val mime_type: String?,
    val file_size: Int?
)
