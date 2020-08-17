package zone.nora.basicallylouis.listeners

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.config.COMMAND_PREFIX

class CommandListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (!event.author.isBot) {
            val cr = event.message.contentRaw
            registeredCommands.forEach {
                var flag = cr.startsWith("$COMMAND_PREFIX${it.commandName}")
                val aliases = it.getCommandAliases()
                if (!flag && aliases != null) {
                    for (alias in aliases) {
                        if (cr.startsWith("$COMMAND_PREFIX$alias")) {
                            flag = true
                            break
                        }
                    }
                }
                val args = ArrayList<String>()
                try {
                    val words = cr.split(" ")
                    for (i in cr.split(" ").indices) {
                        if (i != 0) args.add(words[i])
                    }
                } catch (_: Exception) { }
                if (flag) it.processCommand(args.toTypedArray(), event)
            }
        }
    }

    companion object {
        val registeredCommands = ArrayList<AbstractCommand>()

        fun registerCommand(command: AbstractCommand) = registeredCommands.add(command)
    }
}