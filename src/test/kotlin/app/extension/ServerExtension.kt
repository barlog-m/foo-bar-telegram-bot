package app.extension

import app.Server
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class ServerExtension : BeforeAllCallback, AfterAllCallback {
    override fun beforeAll(context: ExtensionContext) {
        Server.start("localhost", 8889)
    }

    override fun afterAll(context: ExtensionContext) {
        Server.stop()
    }
}
