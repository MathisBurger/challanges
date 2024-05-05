package de.mathisburger.challanges.randomizer

import de.mathisburger.ChallangeEnum
import de.mathisburger.Variables
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.inventory.PrepareItemCraftEvent

/**
 * Randomizer listener for crafting actions
 */
class RandomizerCraftingListener : Listener {

    companion object {
        var allocations: Map<Material, Material> = mapOf()
    }

    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        if (Variables.currentChallanges.indexOf(ChallangeEnum.RANDOMIZER_CRAFT) > -1) {
            val newMaterial = allocations[e.recipe.result.type]!!
            if (newMaterial.name.indexOf("BED") > -1) {
               RandomizerBlockListener.exclude = newMaterial.name;
            }
            e.inventory.result?.type = newMaterial;
        }
    }
}
