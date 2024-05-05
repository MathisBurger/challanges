package de.mathisburger.config

import de.mathisburger.config.ConfigInventory.Companion.createItem
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ConfigStatics {

    companion object {
        val generalItems = listOf(
            ConfigInventory.createItem(
                Material.BOOK,
                "Block randomizer",
                ChatColor.RED.toString() + "Disabled"
            ),
            ConfigInventory.createItem(
                Material.BOOK,
                "Drop randomizer",
                ChatColor.RED.toString() + "Disabled"
            ),
            ConfigInventory.createItem(
                Material.BOOK,
                "Craft randomizer",
                ChatColor.RED.toString() + "Disabled"
            )
        );

        val statusItems: Map<String, ItemStack> = mapOf(
            "blockRandomizer" to createItem(
                Material.ENCHANTED_BOOK,
                "Block randomizer",
                ChatColor.GREEN.toString() + "Enabled"
            ),
            "dropRandomizer" to createItem(
                Material.ENCHANTED_BOOK,
                "Drop randomizer",
                ChatColor.GREEN.toString() + "Enabled"
            ),
            "craftRandomizer" to createItem(
                Material.ENCHANTED_BOOK,
                "Craft randomizer",
                ChatColor.GREEN.toString() + "Enabled"
            )
        )
    }
}