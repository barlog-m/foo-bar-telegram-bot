package app.rest

import app.Server
import app.extension.ServerExtension
import app.objectMapper
import app.randomUpdate
import io.netty.handler.codec.http.HttpResponseStatus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import reactor.core.publisher.Mono
import reactor.ipc.netty.http.client.HttpClient
import reactor.test.StepVerifier
import java.time.Duration

@ExtendWith(ServerExtension::class)
class UpdateTest {

    @Test
    fun post() {
        StepVerifier.create(
            HttpClient
                .create(Server.host(), Server.port())
                .post("/none", { r ->
                    r.sendString(
                        Mono.fromCallable {
                            objectMapper.writeValueAsString(randomUpdate())
                        })
                })
                .map { it.status().code() }
                .timeout(Duration.ofMillis(1000)))
            .assertNext { it == HttpResponseStatus.OK.code() }
            .verifyComplete()
    }

    @Test
    fun postBadRequest() {
        StepVerifier.create(
            HttpClient
                .create(Server.host(), Server.port())
                .post("/none", { r ->
                    r.sendString(Mono.just("{a: b}"))
                })
                .timeout(Duration.ofMillis(1000)))
            .expectError()
            .verify()
    }
}
