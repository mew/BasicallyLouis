package zone.nora.basicallylouis.commands.impl.`fun`

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.SimpleCommand
import java.util.*

class SlotsCommand : SimpleCommand("slots") {
    override fun getCommandAliases(): List<String> = Collections.singletonList("slot")

    override fun getCommandDescription(): String = "Fuel your gambling addiction."

    override fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String? {
        val range = 1..10
        val first = range.random()
        val second = range.random()
        val third = range.random()
        val s = when {
            first == second && second == third -> "Jackpot!"
            first == second || second == third || third == first -> "Nice!"
            else -> "You lose.. fucking loser lol."
        }
        return "**[ $first $second $third ]**: $s"
    }
}