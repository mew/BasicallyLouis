package zone.nora.basicallylouis.commands.impl.general

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.config.ERROR_IMAGE
import zone.nora.basicallylouis.gson.getContent
import zone.nora.basicallylouis.gson.gson
import zone.nora.basicallylouis.gson.mojang.SerializedAshconUser
import zone.nora.basicallylouis.gson.parseAsObj
import zone.nora.basicallylouis.gson.typeToken

class SkinCommand : AbstractCommand("skin") {
    override fun commandUsage(): String = "skin <player>"

    override fun getCommandAliases(): List<String> = listOf("avatar")

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val content = getContent("https://api.ashcon.app/mojang/v2/user/${args[0]}")
            val obj = parseAsObj(content)

            val builder = EmbedBuilder().setFooter(EMBED_FOOTER)
            if (obj.has("error")) {
                builder.setThumbnail(ERROR_IMAGE)
                    .addField("Error", obj.get("error").asString, true)
                    .addField("Correct Usage", "-skin <player>", true)
            } else {
                val user = gson.fromJson<SerializedAshconUser>(obj, typeToken<SerializedAshconUser>())
                builder.addField("Username", user.username, true)
                    .addField("UUID", "${user.uuid.replace("-", "")}\nhttps://mine.ly/${user.username}", true)
                    .setImage(user.textures.skin.url)
                    .setThumbnail("https://crafatar.com/renders/body/${user.uuid}")
            }
            event.channel.sendMessage(builder.build()).queue()
        } else {
            sendHelpMessage(event)
        }
    }
}