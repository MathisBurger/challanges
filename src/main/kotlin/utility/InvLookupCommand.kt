package de.mathisburger.utility

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin


/**
 * Command to look up a players inventory
 */
class InvLookupCommand(private val plugin: Plugin) : CommandExecutor {


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage(ChatColor.RED.toString() + "Not enough arguments.")
            return true;
        }
        val player = this.plugin.server.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage(ChatColor.RED.toString() + "Not found.")
            return true;
        }
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "Not a player.")
            return true;
        }
        sender.openInventory(player.inventory);
        return true;
    }
}