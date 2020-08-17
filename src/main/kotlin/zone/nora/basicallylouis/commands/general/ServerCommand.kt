package zone.nora.basicallylouis.commands.general

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.AbstractCommand
import zone.nora.basicallylouis.config.EMBED_FOOTER
import zone.nora.basicallylouis.gson.getContent
import zone.nora.basicallylouis.gson.gson
import zone.nora.basicallylouis.gson.parse
import zone.nora.basicallylouis.gson.server.SerializedMinecraftServer
import zone.nora.basicallylouis.gson.typeToken

class ServerCommand : AbstractCommand("server") {
    override fun commandUsage(): String = "server <server>"

    override fun getCommandDescription(): String = "Retrieve a Minecraft Server's status."

    override fun processCommand(args: Array<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val minecraftServer = gson.fromJson<SerializedMinecraftServer>(
                parse(getContent("https://eu.mc-api.net/v3/server/ping/${args[0]}")).asJsonObject,
                typeToken<SerializedMinecraftServer>()
            )

            val builder = EmbedBuilder()
                .setTitle(args[0])
                .setImage(minecraftServer.favicon)
                .addField("Status", minecraftServer.getStatus(), true)
            if (minecraftServer.online) builder.addField("Players", "${minecraftServer.players.online}/${minecraftServer.players.max}", true)
            builder.setFooter(EMBED_FOOTER)

            event.channel.sendMessage(builder.build())
        } else {
            sendHelpMessage(event)
        }
    }
}