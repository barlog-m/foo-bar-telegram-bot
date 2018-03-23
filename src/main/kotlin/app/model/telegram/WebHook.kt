package app.model.telegram

data class WebHook(
    val url: String,
    val max_connections: Int = 100
)
