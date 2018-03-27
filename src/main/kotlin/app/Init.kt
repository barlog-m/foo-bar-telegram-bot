package app

import app.service.registerWebHook
import reactor.core.publisher.Mono

fun postStartInitializeHook(): Mono<Unit> = Mono.fromRunnable<Unit> {
    registerWebHook()
}
