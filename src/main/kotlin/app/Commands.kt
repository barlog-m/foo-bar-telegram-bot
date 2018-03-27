package app

import app.service.helpCommand
import app.service.hiCommand
import app.service.startCommand

val commands = mapOf(
    "start" to ::startCommand,
    "help" to ::helpCommand,
    "hi" to ::hiCommand
)
