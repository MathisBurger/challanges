package de.mathisburger.utility

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

/**
 * General command for opening backpack
 */
class BackbackCommand : CommandExecutor {

    private val backback: Inventory;

    constructor() {
        this.backback = Bukkit.createInventory(null, 27*2, "Backback");
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            sender.openInventory(this.backback);
            return true;
        }
        sender.sendMessage(ChatColor.RED.toString() + "You are not a player");
        return true;
    }
}