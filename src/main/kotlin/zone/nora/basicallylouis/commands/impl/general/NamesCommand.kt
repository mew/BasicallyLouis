package zone.nora.basicallylouis.commands.impl.general

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.commands.category.Category
import zone.nora.basicallylouis.config.COMMAND_PREFIX
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.config.ERROR_IMAGE
import zone.nora.basicallylouis.gson.getContent
import zone.nora.basicallylouis.gson.gson
import zone.nora.basicallylouis.gson.mojang.SerializedAshconUser
import zone.nora.basicallylouis.gson.parseAsObj
import zone.nora.basicallylouis.gson.typeToken

class NamesCommand : AbstractCommand("names") {
    override fun getCommandUsage(): String = "names <player>"

    override fun getCommandCategory(): Category = Category.GENERAL

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val content = getContent("https://api.ashcon.app/mojang/v2/user/${args[0]}")
            val obj = parseAsObj(content)

            val builder = EmbedBuilder().setFooter(EMBED_FOOTER)
            if (obj.has("error")) {
                builder.setThumbnail(ERROR_IMAGE)
                    .addField("Error", obj.get("error").asString, true)
                    .addField("Correct Usage", "${COMMAND_PREFIX}names <player>", true)
            } else {
                val user = gson.fromJson<SerializedAshconUser>(obj, typeToken<SerializedAshconUser>())
                var s = ""
                user.usernameHistory.forEach {
                    s += "- ${it.username}\n"
                }
                builder.addField("Name History", s, false)
                    .setThumbnail("https://crafatar.com/renders/body/${user.uuid}")
            }
            event.channel.sendMessage(builder.build()).queue()
        } else {
            sendHelpMessage(event)
        }
    }
}