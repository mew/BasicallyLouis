package zone.nora.basicallylouis.commands.impl.general

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.gson.getContent
import zone.nora.basicallylouis.gson.gson
import zone.nora.basicallylouis.gson.parseAsObj
import zone.nora.basicallylouis.gson.server.SerializedMinecraftServer
import zone.nora.basicallylouis.gson.typeToken

class ServerCommand : AbstractCommand("server") {
    override fun commandUsage(): String = "server <server>"

    override fun getCommandDescription(): String = "Retrieve a Minecraft Server's status."

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val content = getContent("https://eu.mc-api.net/v3/server/ping/${args[0]}")
            val obj = parseAsObj(content)
            val minecraftServer = gson.fromJson<SerializedMinecraftServer>(obj, typeToken<SerializedMinecraftServer>())

            val builder = EmbedBuilder()
                .setTitle(args[0])
                //.setImage(minecraftServer.favicon)
                .setThumbnail(minecraftServer.favicon)
                .addField("Status", minecraftServer.getStatus(), true)
            if (minecraftServer.online) builder.addField("Players", "${minecraftServer.players.online}/${minecraftServer.players.max}", true)
            builder.setFooter(EMBED_FOOTER)

            event.channel.sendMessage(builder.build()).queue()
        } else {
            sendHelpMessage(event)
        }
    }
}