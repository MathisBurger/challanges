package de.mathisburger.challanges.randomizer

import de.mathisburger.ChallangeEnum
import de.mathisburger.Variables
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
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
    fun onDrop(e: EntityDeathEvent) {
        if (Variables.currentChallange === ChallangeEnum.RANDOMIZER) {
            if (e.drops.isNotEmpty()) {
                val first = e.drops[0];
                e.drops.clear();
                val newMaterial = allocations[first.type]!!
                if (newMaterial.name.indexOf("BED") > -1) {
                    RandomizerBlockListener.exclude = newMaterial.name;
                }
                e.drops.add(ItemStack(newMaterial));
            }
        }
    }
}