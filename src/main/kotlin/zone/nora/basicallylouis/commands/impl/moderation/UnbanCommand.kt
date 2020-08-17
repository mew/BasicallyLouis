package zone.nora.basicallylouis.commands.impl.moderation

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.ModerationCommand

class UnbanCommand : ModerationCommand("unban", Permission.BAN_MEMBERS) {
    override fun getCommandUsage(): String = "unban <user id>"

    override fun getCommandDescription(): String = "unban a person lol"

    override fun moderationAction(args: ArrayList<String>, event: MessageReceivedEvent) {
        try {
            val user = User.fromId(args[0])
            event.guild.unban(user).queue()
            event.message.channel.sendMessage("${user.name} was unbanned.").queue()
        } catch (_: Exception) {
            sendHelpMessage(event)
        }
    }
}