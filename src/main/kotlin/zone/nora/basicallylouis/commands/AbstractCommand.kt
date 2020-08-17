package zone.nora.basicallylouis.commands

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

abstract class AbstractCommand(val commandName: String, val botCommandsOnly: Boolean = true) {
    open fun getCommandAliases(): List<String>? = null

    abstract fun processCommand(args: Array<String>, event: MessageReceivedEvent)
}