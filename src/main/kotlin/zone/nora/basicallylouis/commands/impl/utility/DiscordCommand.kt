package zone.nora.basicallylouis.commands.impl.utility

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.config.BOT_IMAGE
import zone.nora.basicallylouis.config.EMBED_FOOTER

class DiscordCommand : AbstractCommand("disc") {
    override fun getCommandUsage(): String = "disc"

    override fun getCommandDescription(): String = "Discord information."

    override fun getCommandCategory(): Category = Category.UTILITY

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        val guild = event.guild
        val bots = guild.members.filter { it.user.isBot }
        val builder = EmbedBuilder()
            .setThumbnail(BOT_IMAGE)
            .setImage(guild.iconUrl)
            .addField("Server Name", guild.name, true)
            .addField("Server ID", guild.id, true)
            .addField("Members", guild.memberCount.toString(), true)
            .addField("Bots", bots.size.toString(), true)
            .addField("Owner", guild.owner!!.effectiveName, true)
            .addField("Region", "${guild.region.emoji} ${guild.region.getName()}", true)
            .setFooter(EMBED_FOOTER)
        event.message.channel.sendMessage(builder.build()).queue()
    }
}