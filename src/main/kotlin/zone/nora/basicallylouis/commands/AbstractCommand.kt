package zone.nora.basicallylouis.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.config.BOT_IMAGE
import zone.nora.basicallylouis.config.EMBED_FOOTER

abstract class AbstractCommand(
    val commandName: String,
    val botCommandsOnly: Boolean = true
) {
    open fun getCommandAliases(): List<String>? = null

    open fun getCommandDescription(): String? = null

    abstract fun commandUsage(): String

    abstract fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent)

    protected open fun sendHelpMessage(event: MessageReceivedEvent) {
        val builder = EmbedBuilder().setAuthor(commandName).setThumbnail(BOT_IMAGE)
        if (getCommandDescription() != null) builder.addField("Description", getCommandDescription(), false)
        builder.addField("Command", commandUsage(), false)
        if (getCommandAliases() != null) builder.addField("Aliases", "`${getCommandAliases()!!.joinToString("`, `")}`", false)
        builder.setFooter(EMBED_FOOTER)
        event.channel.sendMessage(builder.build()).queue()
    }
}