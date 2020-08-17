package zone.nora.basicallylouis.commands.impl.`fun`

import de.mkammerer.argon2.Argon2Factory
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.SimpleCommand

class CoinFlipCommand : SimpleCommand("coinflip") {
    override fun getCommandDescription(): String = "flip a coin lol"

    override fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String? {
        val r = Argon2Factory.create().hash(
            (1..4).random(),
            512,
            1,
            (System.currentTimeMillis() + (0..100).random()).toString().toByteArray()
        ).hashCode() % 2 == 0
        return "${event.author.name} flipped a coin and got **${if (r) "tails" else "heads"}**!"
    }
}