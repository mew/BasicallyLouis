package zone.nora.basicallylouis.commands

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.category.Category

abstract class SimpleCommand(commandName: String) : AbstractCommand(commandName) {
    override fun getCommandUsage(): String = commandName

    override fun getCommandCategory(): Category = Category.FUN

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        val response = getResponse(args, event)
        if (response != null) {
            event.message.channel.sendMessage(response).queue()
        }
    }

    abstract fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String?
}