package app

import app.service.registerWebHook
import reactor.core.publisher.Mono

fun postStartInitializeHook(): Mono<Void> {
    return registerWebHook().then()
}
