package app.rest

import app.Server
import app.extension.ServerExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import reactor.ipc.netty.http.client.HttpClient
import reactor.test.StepVerifier
import java.time.Duration

@ExtendWith(ServerExtension::class)
class InfoTest {

    @Test
    fun get() {
        StepVerifier.create(
            HttpClient
                .create(Server.host(), Server.port())
                .get("/info")
                .flatMap { r ->
                    assertEquals(200, r.status().code())
                    r.receive().aggregate().asString()
                }
                .timeout(Duration.ofMillis(1000)))
            .assertNext { data -> data.isNotBlank() }
            .verifyComplete()
    }
}
