package app

fun config() {
    System.setProperty("reactor.ipc.netty.workerCount", "2")
}
