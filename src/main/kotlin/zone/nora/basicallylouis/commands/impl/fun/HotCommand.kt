package zone.nora.basicallylouis.commands.impl.`fun`

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category

class HotCommand : AbstractCommand("hot") {
    override fun getCommandUsage(): String = "hot"

    override fun getCommandCategory(): Category = Category.FUN

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        var i = when (event.author.idLong) {
            385621738773413898L -> 99
            130224515669164032L -> 100
            else -> event.author.asTag.hashCode()
        }
        if (i > 0) {
            while (i > 100) {
                i -= 100
            }
        } else {
            while (i < 0) {
                i += 100
            }
        }
        event.message.channel.sendMessage("${event.author.name} is $i% hot.").queue()
    }
}