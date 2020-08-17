package zone.nora.basicallylouis

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import zone.nora.basicallylouis.config.TOKEN
import zone.nora.basicallylouis.listeners.CommandListener
import java.lang.Exception

lateinit var jda: JDA

fun main() {
    try {
        jda = JDABuilder.createDefault(TOKEN).addEventListeners(
            CommandListener()
        ).build()

        jda.awaitReady()

        println("Logged in to Discord!")
        println("Invite link: ${jda.getInviteUrl()}")
    } catch (e: Exception) {
        println("Failed to load bot with exception ${e::class.java}:")
        e.printStackTrace()
    }
}