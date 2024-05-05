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
            val options = RandomizerItems.getValidBlocks();
            val rngOptions = RandomizerItems.getValidOptions();
            val blocks = options.filter { it.isBlock };
            val map: MutableMap<Material, Material> = mutableMapOf()
            val rng = Random()
            for (block in blocks) {
                map[block] = rngOptions[rng.nextInt(rngOptions.size)];
            }
            RandomizerBlockListener.allocations = map;
        }

        /**
         * Sets all random drops
         */
        fun setRandomDrops() {
            val options = RandomizerItems.getValidMaterials();
            val rngOptions = RandomizerItems.getValidOptions();
            val map: MutableMap<Material, Material> = mutableMapOf()
            val rng = Random()
            for (block in options) {
                map[block] = rngOptions[rng.nextInt(rngOptions.size)];
            }
            RandomizerEntityDropListener.allocations = map;
        }

        /**
         * Sets all random crafting recipes
         */
        fun setRandomCraftingRecipes() {
            val options = RandomizerItems.getValidMaterials();
            val rngOptions = RandomizerItems.getValidOptions();
            val map: MutableMap<Material, Material> = mutableMapOf()
            val rng = Random()
            for (block in options) {
                map[block] = rngOptions[rng.nextInt(rngOptions.size)];
            }
            RandomizerCraftingListener.allocations = map;
        }
    }
}