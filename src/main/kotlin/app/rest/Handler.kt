package app.rest

import org.reactivestreams.Publisher
import reactor.ipc.netty.http.server.HttpServerRequest
import reactor.ipc.netty.http.server.HttpServerResponse
import java.util.function.BiFunction

typealias Handler = BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>>
