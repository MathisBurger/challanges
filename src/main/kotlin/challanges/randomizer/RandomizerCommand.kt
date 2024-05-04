package de.mathisburger.challanges.randomizer

import de.mathisburger.ChallangeEnum
import de.mathisburger.Variables
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin
import java.util.*

/**
 * Command to enable randomizer challenge
 */
class RandomizerCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (Variables.currentChallange === ChallangeEnum.RANDOMIZER) {
            Variables.currentChallange = ChallangeEnum.NONE;
            sender.sendMessage("Randomizer challenge stopped")
            return true;
        }
        this.setRandomBlocks();
        this.setRandomDrops();
        this.setRandomCraftingRecipes();
        Variables.currentChallange = ChallangeEnum.RANDOMIZER;
        sender.sendMessage("Randomizer challenge started")
        return true;
    }

    /**
     * Sets all random blocks
     */
    private fun setRandomBlocks() {
        val options = Material.entries.toTypedArray();
        val blocks = options.filter { it.isBlock };
        val map: MutableMap<Material, Material> = mutableMapOf()
        val rng = Random()
        for (block in blocks) {
            map[block] = options[rng.nextInt(options.size)];
        }
        RandomizerBlockListener.allocations = map;
    }

    /**
     * Sets all random drops
     */
    private fun setRandomDrops() {
        val options = Material.entries.toTypedArray();
        val map: MutableMap<Material, Material> = mutableMapOf()
        val rng = Random()
        for (block in options) {
            map[block] = options[rng.nextInt(options.size)];
        }
        RandomizerEntityDropListener.allocations = map;
    }

    /**
     * Sets all random crafting recipes
     */
    private fun setRandomCraftingRecipes() {
        val options = Material.entries.toTypedArray();
        val map: MutableMap<Material, Material> = mutableMapOf()
        val rng = Random()
        for (block in options) {
            map[block] = options[rng.nextInt(options.size)];
        }
        RandomizerCraftingListener.allocations = map;
    }
}