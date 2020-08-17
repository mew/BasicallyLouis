package zone.nora.basicallylouis.commands.impl.moderation

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.ModerationCommand

class BanCommand : ModerationCommand("ban", Permission.BAN_MEMBERS) {
    override fun getCommandDescription(): String = "ban a user"

    override fun moderationAction(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (event.message.mentionedUsers.isNotEmpty()) {
            val user = event.message.mentionedUsers[0]
            event.guild.ban(user, 0).queue()
            event.message.channel.sendMessage("${user.name} was banned.")
        } else {
            sendHelpMessage(event)
        }
    }
}