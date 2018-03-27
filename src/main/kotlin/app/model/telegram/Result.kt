package app.model.telegram

data class Result<out T> (
    val ok: Boolean,
    val result: T
)
