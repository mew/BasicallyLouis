package zone.nora.basicallylouis.commands.impl.`fun`

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.SimpleCommand

class RateCommand : SimpleCommand("rate") {
    override fun getCommandUsage(): String = "rate <thing>"

    override fun getCommandDescription(): String = "rate something."

    override fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String? {
        if (args.isNotEmpty()) {
            val thingToRate = args.joinToString(" ")
            var i = if (thingToRate.toLowerCase() != "anna") thingToRate.hashCode() else 100
            if (i > 0) {
                while (i > 100) {
                    i -= 100
                }
            } else {
                while (i < 0) {
                    i += 100
                }
            }
            return "I'd rate `$thingToRate` a **$i/100**!"
        } else {
            sendHelpMessage(event)
        }
        return null
    }
}