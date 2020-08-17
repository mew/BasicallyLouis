package zone.nora.basicallylouis.commands.impl.hypixel

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.slothpixel.slothpixel

class WatchdogCommand : AbstractCommand("watchdog") {
    override fun getCommandUsage(): String = "watchdog"

    override fun getCommandCategory(): Category = Category.HYPIXEL

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        val wd = slothpixel.getBans()
        val builder = EmbedBuilder()
            .setTitle("Watchdog Statistics")
            .setThumbnail("https://i.imgur.com/HqB4bPk.png")
            .addField("Watchdog", """`Last Minute` -> `${wd.watchdog.lastMinute}`
                `Today` -> `${wd.watchdog.daily}`
                `Total` -> `${wd.watchdog.total}`""".trimIndent(), false)
            .addField("Staff Team", """`Today` -> `${wd.staff.daily}`
                `Total` -> `${wd.staff.total}`""".trimIndent(), false)
            .setFooter(EMBED_FOOTER)
        event.channel.sendMessage(builder.build()).queue()
    }
}