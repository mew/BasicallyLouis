package zone.nora.basicallylouis.commands.impl.`fun`

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category

class EightBallCommand : AbstractCommand("8ball") {
    private val responses = listOf("it is certain", "yea", "nope", "eat shit", "idk")

    override fun getCommandUsage(): String = "8ball <question>"

    override fun getCommandCategory(): Category = Category.FUN

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty() && args.last().endsWith('?'))
            event.channel.sendMessage(responses.random()).queue() else sendHelpMessage(event)
    }
}