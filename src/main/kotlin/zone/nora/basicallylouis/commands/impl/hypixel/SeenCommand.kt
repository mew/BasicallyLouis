package zone.nora.basicallylouis.commands.impl.hypixel

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.HypixelCommand
import zone.nora.slothpixel.player.Player

class SeenCommand : HypixelCommand("seen") {
    override fun loadStats(player: Player, event: MessageReceivedEvent): EmbedBuilder =
        EmbedBuilder()
            .setAuthor(player.username, "https://crafatar.com/avatars/${player.uuid}")
            .setTitle("Login Information")
            .addStatField("Last Login", player.lastLogin.parse())
            .addStatField("Last Logout", player.lastLogout.parse())
            .addStatField("Recent Game", player.lastGame)
            .addStatField("Version", player.mcVersion)
}