package de.mathisburger.challanges.randomizer

import org.bukkit.Material

/**
 * Handles randomizer items that are allowed
 */
class RandomizerItems {

    companion object {

        private val unallowedItems: List<Material> = listOf(
            Material.COMMAND_BLOCK,
            Material.COMMAND_BLOCK_MINECART,
            Material.CHAIN_COMMAND_BLOCK,
            Material.REPEATING_COMMAND_BLOCK,
            Material.AIR,
            Material.BEDROCK,
            Material.BARRIER,
            Material.LIGHT,
            Material.LILAC,
            Material.PEONY,
            Material.STRUCTURE_VOID,
            Material.STRUCTURE_BLOCK,
            Material.JIGSAW,
            Material.KNOWLEDGE_BOOK,
            Material.DEBUG_STICK,
            Material.END_PORTAL,
            Material.VOID_AIR,
            Material.STRUCTURE_VOID,
            Material.CAVE_AIR,
            Material.BUBBLE_COLUMN,

        )

        private val minecraftExperimental: List<Material> = listOf(
            Material.COPPER_DOOR,
            Material.TUFF_SLAB,
            Material.TUFF_STAIRS,
            Material.TUFF_WALL,
            Material.CHISELED_TUFF,
            Material.POLISHED_TUFF,
            Material.POLISHED_TUFF_SLAB,
            Material.POLISHED_TUFF_STAIRS,
            Material.POLISHED_TUFF_WALL,
            Material.TUFF_BRICKS,
            Material.TUFF_BRICK_SLAB,
            Material.TUFF_BRICK_STAIRS,
            Material.TUFF_BRICK_WALL,
            Material.CHISELED_TUFF_BRICKS,
            Material.CHISELED_COPPER,
            Material.EXPOSED_CHISELED_COPPER,
            Material.WEATHERED_CHISELED_COPPER,
            Material.OXIDIZED_CHISELED_COPPER,
            Material.WAXED_CHISELED_COPPER,
            Material.WAXED_EXPOSED_CHISELED_COPPER,
            Material.WAXED_WEATHERED_CHISELED_COPPER,
            Material.WAXED_OXIDIZED_CHISELED_COPPER,
            Material.COPPER_DOOR,
            Material.EXPOSED_COPPER_DOOR,
            Material.WEATHERED_COPPER_DOOR,
            Material.OXIDIZED_COPPER_DOOR,
            Material.WAXED_COPPER_DOOR,
            Material.WAXED_EXPOSED_COPPER_DOOR,
            Material.WAXED_WEATHERED_COPPER_DOOR,
            Material.WAXED_OXIDIZED_COPPER_DOOR,
            Material.COPPER_TRAPDOOR,
            Material.EXPOSED_COPPER_TRAPDOOR,
            Material.WEATHERED_COPPER_TRAPDOOR,
            Material.OXIDIZED_COPPER_TRAPDOOR,
            Material.WAXED_COPPER_TRAPDOOR,
            Material.WAXED_EXPOSED_COPPER_TRAPDOOR,
            Material.WAXED_WEATHERED_COPPER_TRAPDOOR,
            Material.WAXED_OXIDIZED_COPPER_TRAPDOOR,
            Material.CRAFTER,
            Material.BREEZE_SPAWN_EGG,
            Material.COPPER_GRATE,
            Material.EXPOSED_COPPER_GRATE,
            Material.WEATHERED_COPPER_GRATE,
            Material.OXIDIZED_COPPER_GRATE,
            Material.WAXED_COPPER_GRATE,
            Material.WAXED_EXPOSED_COPPER_GRATE,
            Material.WAXED_WEATHERED_COPPER_GRATE,
            Material.WAXED_OXIDIZED_COPPER_GRATE,
            Material.COPPER_BULB,
            Material.EXPOSED_COPPER_BULB,
            Material.WEATHERED_COPPER_BULB,
            Material.OXIDIZED_COPPER_BULB,
            Material.WAXED_COPPER_BULB,
            Material.WAXED_EXPOSED_COPPER_BULB,
            Material.WAXED_WEATHERED_COPPER_BULB,
            Material.WAXED_OXIDIZED_COPPER_BULB,
            Material.TRIAL_SPAWNER,
            Material.TRIAL_KEY
        )

        /**
         * Gets all allowed randomizer items
         */
        fun getValidOptions(): Array<Material> {
            val options = Material.entries.toTypedArray();
            return options.filter {
                !it.isLegacy
                        && (it !in unallowedItems)
                        && !it.name.contains("CANDLE_CAKE")
                        && !it.name.contains("POTTED")
                        && !it.name.contains("WALL_HEAD")
                        && !it.name.contains("WALL_SKULL")
                        && !it.name.contains("WALL_BANNER")
                        && !it.name.contains("WALL_HANGING_SIGN")
                        && !it.name.contains("COPPER_DOOR")
                        && (it !in minecraftExperimental)
                        && (it.isBlock || it.isItem)

            }.toTypedArray()
        }

        /**
         * Gets all valid materials
         */
        fun getValidMaterials(): List<Material> {
            return Material.entries.toTypedArray().filter { it !in minecraftExperimental };
        }

        /**
         * Gets all valid blocks
         */
        fun getValidBlocks(): List<Material> {
            return getValidMaterials().filter { it.isBlock };
        }
    }
}