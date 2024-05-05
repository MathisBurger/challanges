package de.mathisburger.config

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Command that handles config interactions
 */
class ConfigCommand(public val inventory: ConfigInventory) : CommandExecutor {



    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            sender.openInventory(inventory.getInventory());
            return true;
        }
        sender.sendMessage(ChatColor.RED.toString() + "You are not a player.")
        return true;
    }


}