package app

lateinit var appArgs: List<String>

val settings by lazy {
    val args = parse(appArgs)
    Settings(
        port = port(args),
        url = "https://api.telegram.org/bot${authToken(args)}/",
        webHookUrl = "https://foo-bar-bot.herokuapp.com/${webHookToken(args)}",
        fileUrl = "https://api.telegram.org/file/bot${webHookToken(args)}/"
    )
}

data class Settings(
    val port: Int,
    val url: String,
    val webHookUrl: String,
    val fileUrl: String
)
