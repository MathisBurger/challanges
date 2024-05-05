package de.mathisburger.challanges.randomizer

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Command that can be used to debug randomizer
 * The items refering to the items can be sent to the user
 */
class RandomizerDebugCommand : CommandExecutor {


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage(ChatColor.RED.toString() + "Please provide a material ID.")
            return true
        }
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "Something went wrong!")
            return true
        }
        if (args.size == 2) {
            val material = Material.getMaterial(args[1])
            if (material == null) {
                sender.sendMessage(ChatColor.RED.toString() + "Please provide a valid material ID.")
                return true
            }
            for (mat in RandomizerBlockListener.allocations.entries) {
                val compare = if(args[0] === "from") mat.key else mat.value;
                if (compare.name === material.name) {
                    sender.sendMessage(ChatColor.GREEN.toString() + "Block: " + mat.key.name)
                }
            }
            for (mat in RandomizerCraftingListener.allocations.entries) {
                val compare = if(args[0] === "from") mat.key else mat.value;
                if (compare.name === material.name) {
                    sender.sendMessage(ChatColor.GREEN.toString() + "Crafting: " + mat.key.name)
                }
            }
            for (mat in RandomizerEntityDropListener.allocations.entries) {
                val compare = if(args[0] === "from") mat.key else mat.value;
                if (compare.name === material.name) {
                    sender.sendMessage(ChatColor.GREEN.toString() + "Drop: " + mat.key.name)
                }
            }
            return true;
        }
        sender.sendMessage(ChatColor.RED.toString() + "Invalid command pattern")
        return true
    }
}