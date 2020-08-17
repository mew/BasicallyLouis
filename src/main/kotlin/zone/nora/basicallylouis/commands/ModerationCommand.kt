package zone.nora.basicallylouis.commands

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.category.Category

abstract class ModerationCommand(commandName: String, vararg val permissions: Permission) : AbstractCommand(commandName) {
    override fun getCommandUsage(): String = "$commandName <user>"

    override fun getCommandCategory(): Category = Category.MODERATION

    override fun processCommand(args: ArrayList<String>, event: MessageReceivedEvent) {
        if (args.isNotEmpty()) {
            val author = event.message.guild.getMember(event.author)!!
            var flag = true
            for (permission in permissions) {
                if (!author.hasPermission(permission)) {
                    flag = false
                    break
                }
            }
            if (flag) {
                moderationAction(args, event)
            } else {
                event.message.channel.sendMessage("You don't have permission for that command.").queue()
            }
        } else {
            sendHelpMessage(event)
        }
    }

    abstract fun moderationAction(args: ArrayList<String>, event: MessageReceivedEvent)
}