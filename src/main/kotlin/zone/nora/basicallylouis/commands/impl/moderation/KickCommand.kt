package zone.nora.basicallylouis.commands.impl.moderation

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.ModerationCommand

class KickCommand : ModerationCommand("kick", Permission.BAN_MEMBERS) {
    override fun getCommandDescription(): String = "kick a user"

    override fun moderationAction(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (event.message.mentionedUsers.isNotEmpty()) {
            val user = event.message.mentionedUsers[0]
            event.guild.getMember(user)?.let { event.guild.kick(it).queue() }
            event.message.channel.sendMessage("${user.name} was kicked.")
        } else {
            sendHelpMessage(event)
        }
    }
}