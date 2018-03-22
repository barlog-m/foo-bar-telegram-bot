package app

fun port(vararg args: String): Int {
	if (args.isNotEmpty()) {
		val port: Int = args
			.filter { it[0] == "-".single() && it[1] == "-".single() }
			.filter { it.contains("--port=") }
			.map {
				val v = it.substring(2).split("=")
				if (v.size > 1) {
					try {
						v[1].toInt()
					} catch (e: NumberFormatException) {
						-1
					}
				} else {
					-1
				}
			}
			.last()

		if (port != -1 && port >= 0 && port < 65535) {
			return port
		}
	}

	return 8080
}
