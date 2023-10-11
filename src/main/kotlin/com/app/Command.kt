package com.app

enum class Command(val value:String) {
    ADD("add"),
    SHOW("show"),
    MARKDONE("mark-done");


    companion object {
        fun isPresent(command: Command): Boolean {
            val commands = enumValues<Command>()
            return commands.any { it.name == command.name }
        }
    }
}
