package zone.nora.basicallylouis

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import zone.nora.basicallylouis.commands.impl.CHelpCommand
import zone.nora.basicallylouis.commands.impl.HelpCommand
import zone.nora.basicallylouis.commands.impl.`fun`.*
import zone.nora.basicallylouis.commands.impl.general.*
import zone.nora.basicallylouis.commands.impl.hypixel.HypixelStatsCommand
import zone.nora.basicallylouis.commands.impl.hypixel.SeenCommand
import zone.nora.basicallylouis.commands.impl.hypixel.WatchdogCommand
import zone.nora.basicallylouis.commands.impl.utility.DiscordCommand
import zone.nora.basicallylouis.commands.impl.utility.ModsCommand
import zone.nora.basicallylouis.commands.impl.utility.PingCommand
import zone.nora.basicallylouis.config.BOT_TOKEN
import zone.nora.basicallylouis.listeners.CommandListener

lateinit var jda: JDA

fun main() {
    try {
        jda = JDABuilder.createDefault(BOT_TOKEN).addEventListeners(
            CommandListener()
        ).build()

        jda.awaitReady()

        println("Logged in to Discord!")
        println("Invite link: ${jda.getInviteUrl()}")

        CommandListener.registerCommand(ServerCommand())
        CommandListener.registerCommand(SkinCommand())
        CommandListener.registerCommand(HypixelStatsCommand())
        CommandListener.registerCommand(EightBallCommand())
        CommandListener.registerCommand(SeenCommand())
        CommandListener.registerCommand(HelpCommand())
        CommandListener.registerCommand(CHelpCommand())
        CommandListener.registerCommand(VerifyCommand())
        CommandListener.registerCommand(MojangCommand())
        CommandListener.registerCommand(WatchdogCommand())
        CommandListener.registerCommand(NamesCommand())
        CommandListener.registerCommand(RpsCommand())
        CommandListener.registerCommand(HotCommand())
        CommandListener.registerCommand(PasswordCommand())
        CommandListener.registerCommand(RateCommand())
        CommandListener.registerCommand(BoopCommand())
        CommandListener.registerCommand(CoinFlipCommand())
        CommandListener.registerCommand(ReverseCommand())
        CommandListener.registerCommand(ModsCommand())
        CommandListener.registerCommand(DiscordCommand())
        CommandListener.registerCommand(PingCommand())
        CommandListener.registerCommand(SlotsCommand())

    } catch (e: Exception) {
        println("Failed to load bot with exception ${e::class.java}:")
        e.printStackTrace()
    }
}