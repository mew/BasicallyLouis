package zone.nora.basicallylouis.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.config.ERROR_IMAGE
import zone.nora.basicallylouis.slothpixel.getPlayer
import zone.nora.slothpixel.player.Player
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

abstract class HypixelCommand(commandName: String) : AbstractCommand(commandName) {
    override fun getCommandCategory(): Category = Category.HYPIXEL

    override fun getCommandUsage(): String = "$commandName <player>"

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val player = getPlayer(args[0])
            val builder = if (player != null) loadStats(player, event) else {
                EmbedBuilder()
                    .setTitle("Invalid Request")
                    .setThumbnail(ERROR_IMAGE)
                    .addField("Error", "Could not find a player named `${args[0]}`", true)
                    .addField("Correct Usage", getCommandUsage(), true)
            }
            builder.setFooter(EMBED_FOOTER)
            event.channel.sendMessage(builder.build()).queue()
        } else {
            sendHelpMessage(event)
        }
    }

    abstract fun loadStats(player: Player, event: MessageReceivedEvent): EmbedBuilder

    fun Long.parse(): String = SimpleDateFormat("dd/MM/yyyy").format(Date(Timestamp(this).time))

    fun EmbedBuilder.addStatField(title: String, content: Any, shade: Boolean = true) =
        this.addField(title, if (shade) "`$content`" else content.toString(), true)

    fun EmbedBuilder.addStatFields(title: String, vararg contents: String, inline: Boolean = false) =
        this.addField(title, contents.joinToString("\n"), inline)
}