package zone.nora.basicallylouis.commands.impl

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.config.BOT_IMAGE
import zone.nora.basicallylouis.config.COMMAND_PREFIX
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.listeners.CommandListener

class HelpCommand : AbstractCommand("help", false) {
    override fun getCommandUsage(): String = "help"

    override fun getCommandCategory(): Category? = null

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        val builder = EmbedBuilder()
            .setTitle("Guardian but better lol")
            .setThumbnail(BOT_IMAGE)
            .setDescription("""These are the available commands for Guardian.
                Please use `$COMMAND_PREFIX` as the command prefix.
                
                Want more info about a command? Type `${COMMAND_PREFIX}chelp <command>`""".trimIndent()
            )
        val generalCommands = ArrayList<String>()
        val hypixelCommands = ArrayList<String>()
        val funCommands = ArrayList<String>()
        val utilityCommands = ArrayList<String>()
        CommandListener.registeredCommands.forEach {
            when (it.getCommandCategory()) {
                Category.GENERAL -> generalCommands.add(it.commandName)
                Category.HYPIXEL -> hypixelCommands.add(it.commandName)
                Category.FUN -> funCommands.add(it.commandName)
                Category.UTILITY -> utilityCommands.add(it.commandName)
            }
        }
        builder.addField(Category.GENERAL.name, "`${generalCommands.joinToString("`, `")}`", false)
        builder.addField(Category.HYPIXEL.name, "`${hypixelCommands.joinToString("`, `")}`", false)
        builder.addField(Category.FUN.name, "`${funCommands.joinToString("`, `")}`", false)
        builder.addField(Category.UTILITY.name, "`${utilityCommands.joinToString("`, `")}`", false)
        builder.setFooter(EMBED_FOOTER)

        event.channel.sendMessage(builder.build()).queue()
    }
}