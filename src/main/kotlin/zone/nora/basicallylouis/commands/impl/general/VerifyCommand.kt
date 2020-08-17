package zone.nora.basicallylouis.commands.impl.general

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.HypixelCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.slothpixel.player.Player

class VerifyCommand : HypixelCommand("verify") {
    override fun getCommandDescription(): String = "Verifies you."

    override fun getCommandCategory(): Category = Category.GENERAL

    override fun loadStats(player: Player, event: MessageReceivedEvent): EmbedBuilder {
        val builder = EmbedBuilder()
        if (player.links.discord == "${event.author.name}${event.author.discriminator}") {
            builder.setAuthor("Verified you!! :)")
            event.member?.modifyNickname(player.username)?.queue()
        } else {
            builder.setAuthor("This isnt you, idiot.")
        }
        return builder
    }
}