package zone.nora.basicallylouis.commands.impl.`fun`

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.SimpleCommand

class BoopCommand : SimpleCommand("boop") {
    override fun getCommandDescription(): String = "boop!"

    override fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String = "boop!"
}