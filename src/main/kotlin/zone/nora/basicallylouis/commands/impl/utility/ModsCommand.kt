package zone.nora.basicallylouis.commands.impl.utility

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import zone.nora.basicallylouis.commands.SimpleCommand
import zone.nora.basicallylouis.commands.category.Category
import java.util.*
import kotlin.collections.ArrayList

class ModsCommand : SimpleCommand("mods") {
    override fun getCommandDescription(): String = "gets the server moderators."

    override fun getCommandAliases(): List<String> = Collections.singletonList("moderators")

    override fun getCommandCategory(): Category = Category.UTILITY

    override fun getResponse(args: ArrayList<String>, event: MessageReceivedEvent): String {
        val mods = ArrayList<String>()
        event.guild.members.forEach {
            if (it.hasPermission(Permission.KICK_MEMBERS)) mods.add(it.effectiveName)
        }
        return "Server Moderators: \n - ${mods.joinToString("\n - ")}"
    }
}