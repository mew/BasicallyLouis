package zone.nora.basicallylouis.commands.impl.hypixel

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.HypixelCommand
import zone.nora.slothpixel.player.Player

class HypixelStatsCommand : HypixelCommand("hypixel") {
    override fun loadStats(player: Player, event: MessageReceivedEvent): EmbedBuilder =
        EmbedBuilder()
            .setAuthor(player.username, "https://crafatar.com/avatars/${player.uuid}")
            .setTitle("Hypixel Statistics")
            .setThumbnail("https://crafatar.com/renders/body/${player.uuid}")
            .addStatField("Rank", player.rank)
            .addStatField("Level", player.level)
            .addStatField("Achievement Points", player.achievementPoints)
            .addStatField("Karma", player.karma)
                // guild
            .addStatField("Last Played", player.lastGame)
            .addStatFields(
                "Rewards",
                "`Current Streak` -> `${player.rewards.streakCurrent}`",
                "`Highscore` -> `${player.rewards.streakBest}`",
                "`Total` -> `${player.rewards.claimed}`"
            )
            .addStatField("Minecraft Version", player.mcVersion)
            .addStatFields(
                "Logins",
                "`First Login` -> `${player.firstLogin.parse()}`",
                "`Last Login` -> `${player.lastLogin.parse()}`",
                "`Last Logout` -> `${player.lastLogout.parse()}`"
            )
}