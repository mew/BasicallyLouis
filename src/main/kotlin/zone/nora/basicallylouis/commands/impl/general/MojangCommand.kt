package zone.nora.basicallylouis.commands.impl.general

import com.google.gson.JsonParser
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.gson.getContent

class MojangCommand : AbstractCommand("mojang") {
    override fun getCommandUsage(): String = "mojang"

    override fun getCommandCategory(): Category = Category.GENERAL

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        val jsonArray = JsonParser().parse(getContent("https://status.mojang.com/check")).asJsonArray
        val builder = EmbedBuilder()
            .setTitle("Mojang Status")
            .setThumbnail("https://account.mojang.com/images/mojang_logo.png")
        jsonArray.forEach {
            val obj = it.asJsonObject
            obj.keySet().forEach { k ->
                builder.addField(k, obj.get(k).asString.toUpperCase(), false)
            }
        }

        event.channel.sendMessage(builder.build()).queue()
    }
}