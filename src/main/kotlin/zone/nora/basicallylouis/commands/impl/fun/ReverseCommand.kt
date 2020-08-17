package zone.nora.basicallylouis.commands.impl.`fun`

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.SimpleCommand

class ReverseCommand : SimpleCommand("reverse") {
    override fun getCommandDescription(): String = "reverse a string"

    override fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String? {
        val message = args.joinToString(" ").toCharArray()
        message.reverse()
        return ":repeat: ${message.concatToString()}"
    }
}