package zone.nora.basicallylouis.commands.impl.`fun`

import de.mkammerer.argon2.Argon2Factory
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import java.util.*

class PasswordCommand : AbstractCommand("password") {
    override fun getCommandUsage(): String = "password"

    override fun getCommandCategory(): Category = Category.FUN

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        val uuid = UUID.randomUUID().toString()
        val argon2 = Argon2Factory.create().hash((2..10).random(), 512, 1, uuid.toCharArray(), Charsets.UTF_8)
            .split("p=")[1]
        event.message.channel.sendMessage("Sending you a password \\:)").queue()
        event.author.openPrivateChannel().flatMap { it.sendMessage("Here is your password:\n$argon2") }.queue()
    }
}