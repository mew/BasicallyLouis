package zone.nora.basicallylouis.commands.impl.utility

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.SimpleCommand
import zone.nora.basicallylouis.commands.category.Category

class PingCommand : SimpleCommand("ping") {
    override fun getCommandDescription(): String = "pong!"

    override fun getCommandCategory(): Category = Category.UTILITY

    override fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String? = "pong! (lol)"
}