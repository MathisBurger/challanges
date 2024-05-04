package de.mathisburger.challanges.randomizer

import de.mathisburger.ChallangeEnum
import de.mathisburger.Variables
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent

/**
 * Randomizer listener for crafting actions
 */
class RandomizerCraftingListener : Listener {

    companion object {
        var allocations: Map<Material, Material> = mapOf()
    }

    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        if (Variables.currentChallange === ChallangeEnum.RANDOMIZER) {
            val newMaterial = allocations[e.recipe.result.type]!!
            if (newMaterial.name.indexOf("BED") > -1) {
                RandomizerBlockListener.exclude = newMaterial.name;
            }
            e.recipe.result.type = newMaterial;
        }
    }
}