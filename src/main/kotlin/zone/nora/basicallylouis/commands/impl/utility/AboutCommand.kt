package zone.nora.basicallylouis.commands.impl.utility

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.jda
import java.time.format.DateTimeFormatter

class AboutCommand : AbstractCommand("about") {
    override fun getCommandUsage(): String = "about"

    override fun getCommandDescription(): String = "Get fun info about the bot :^)"

    override fun getCommandCategory(): Category = Category.UTILITY

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        val builder = EmbedBuilder()
            .setTitle("Guardian 2")
            .setDescription("Guardian 2 is a clone of basically louis bot licensed under the BSD 3-Clause License.\nThis is a joke I put way too much time into.")
            .addField("Users", jda.users.size.toString(), true)
            .addField("Created", jda.selfUser.timeCreated.format(DateTimeFormatter.BASIC_ISO_DATE), true)
            .addField("ID", jda.selfUser.id, true)
            .addField("Author", "Nora#0001", true)
            .setFooter(EMBED_FOOTER)
        event.channel.sendMessage(builder.build()).queue()
    }
}