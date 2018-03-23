package app

fun config() {
    System.setProperty("reactor.ipc.netty.workerCount", "2")
    System.setProperty("io.netty.noUnsafe", true.toString())
}
