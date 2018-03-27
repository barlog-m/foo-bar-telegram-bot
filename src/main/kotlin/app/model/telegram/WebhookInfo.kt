package app.model.telegram

data class WebhookInfo(
    val url: String,
    val has_custom_certificate: Boolean,
    val pending_update_count: Int,
    val last_error_date: Int?,
    val last_error_message: String?,
    val max_connections: Int?,
    val allowed_updates: List<String>?
)
