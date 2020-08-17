package zone.nora.basicallylouis

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import zone.nora.basicallylouis.commands.impl.CHelpCommand
import zone.nora.basicallylouis.commands.impl.HelpCommand
import zone.nora.basicallylouis.commands.impl.`fun`.EightBallCommand
import zone.nora.basicallylouis.commands.impl.general.MojangCommand
import zone.nora.basicallylouis.commands.impl.general.ServerCommand
import zone.nora.basicallylouis.commands.impl.general.SkinCommand
import zone.nora.basicallylouis.commands.impl.general.VerifyCommand
import zone.nora.basicallylouis.commands.impl.hypixel.HypixelStatsCommand
import zone.nora.basicallylouis.commands.impl.hypixel.SeenCommand
import zone.nora.basicallylouis.config.BOT_TOKEN
import zone.nora.basicallylouis.listeners.CommandListener
import java.lang.Exception

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

    } catch (e: Exception) {
        println("Failed to load bot with exception ${e::class.java}:")
        e.printStackTrace()
    }
}