package app.model

data class Info(
    val javaVersion: String,
    val availableProcessors: Int,
    val forkJoinPoolParallelism: Int,
    private val _totalMemory: Long,
    private val _maxMemory: Long,
    val jvmArgs: String
) {
    val totalMemory
        get() = "${b2mb(_totalMemory)} Mb"

    val maxMemory
        get() = "${b2mb(_maxMemory)} Mb"

    private fun b2mb(a: Long) = a / (1024 * 1024)
}
