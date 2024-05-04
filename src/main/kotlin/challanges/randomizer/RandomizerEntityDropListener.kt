package de.mathisburger.challanges.randomizer

import de.mathisburger.ChallangeEnum
import de.mathisburger.Variables
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDropItemEvent
import org.bukkit.inventory.ItemStack


/**
 * Listens to randomizer entity drop events
 */
class RandomizerEntityDropListener : Listener {

    companion object {
        var allocations: Map<Material, Material> = mapOf()
    }

    @EventHandler
    fun onDrop(e: EntityDropItemEvent) {
        if (Variables.currentChallange === ChallangeEnum.RANDOMIZER) {
            e.itemDrop.itemStack = ItemStack(allocations[e.itemDrop.itemStack.type]!!)
        }
    }
}