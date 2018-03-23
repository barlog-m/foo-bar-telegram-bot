package app

lateinit var appArgs: List<String>

val settings by lazy {
    val args = parse(appArgs)
    Settings(
        port = port(args),
        authToken = authToken(args),
        webHookToken = webHookToken(args)
    )
}

data class Settings(
    val port: Int,
    val authToken: String,
    val webHookToken: String
)
