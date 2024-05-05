package de.mathisburger.challanges.randomizer

import org.bukkit.Material
import java.util.*


/**
 * Command to enable randomizer challenge
 */
class RandomizerConfigurator {

    companion object {
        /**
         * Sets all random blocks
         */
        fun setRandomBlocks() {
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
        fun setRandomDrops() {
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
        fun setRandomCraftingRecipes() {
            val options = Material.entries.toTypedArray();
            val map: MutableMap<Material, Material> = mutableMapOf()
            val rng = Random()
            for (block in options) {
                map[block] = options[rng.nextInt(options.size)];
            }
            RandomizerCraftingListener.allocations = map;
        }
    }
}