package zone.nora.basicallylouis.commands.impl.`fun`

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category

class RpsCommand : AbstractCommand("rps") {
    override fun getCommandUsage(): String = "rps <rock/paper/scissors>"

    override fun getCommandCategory(): Category = Category.FUN

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val choice = fromString(args[0].toLowerCase())
            if (choice == null) {
                sendHelpMessage(event)
            } else {
                val botsChoice = listOf(Choice.ROCK, Choice.PAPER, Choice.SCISSORS).random()
                val response = when (botsChoice.id) {
                    choice.beats -> "You win."
                    choice.losesTo -> "You lose."
                    else -> "It's a tie."
                }
                event.channel.sendMessage(response).queue()
            }
        } else {
            sendHelpMessage(event)
        }
    }

    private fun fromString(str: String): Choice? = when (str) {
        "rock", "r" -> Choice.ROCK
        "paper", "p" -> Choice.PAPER
        "scissors", "s" -> Choice.SCISSORS
        else -> null
    }

    private enum class Choice(val id: Int, val beats: Int, val losesTo: Int) {
        ROCK(0, 2, 1),
        PAPER(1, 0, 2),
        SCISSORS(2, 1, 0)
    }
}