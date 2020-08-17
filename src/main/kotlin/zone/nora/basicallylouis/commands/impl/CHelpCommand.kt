package zone.nora.basicallylouis.commands.impl

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.listeners.CommandListener

class CHelpCommand : AbstractCommand("chelp", false) {
    override fun getCommandUsage(): String = "chelp <command>"

    override fun getCommandCategory(): Category? = null

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val cmd = args[0]
            var flag = false
            CommandListener.registeredCommands.forEach {
                var flag2 = it.commandName == cmd
                if (!flag2 && it.getCommandAliases() != null) {
                    for (alias in it.getCommandAliases()!!) {
                        if (alias == cmd) {
                            flag2 = true
                            break
                        }
                    }
                }
                if (flag2) {
                    flag = true
                    it.sendHelpMessage(event)
                }
            }
            if (!flag) sendHelpMessage(event)
        } else {
            sendHelpMessage(event)
        }
    }
}