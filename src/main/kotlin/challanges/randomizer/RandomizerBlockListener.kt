package de.mathisburger.challanges.randomizer

import de.mathisburger.ChallangeEnum
import de.mathisburger.Variables
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import java.util.*
import kotlin.collections.HashMap


/**
 * Listens on block events
 */
class RandomizerBlockListener : Listener {

    companion object {
        var allocations: Map<Material, Material> = mapOf()
    }


    @EventHandler
    fun onBlockDestroy(e: BlockBreakEvent) {
        println("Defore")
        if (Variables.currentChallange === ChallangeEnum.RANDOMIZER) {
            println("Configured")
            if (e.block.drops.isNotEmpty()) {
                println("mnot e,pty")
                e.block.drops.clear();
                e.block.drops.add(ItemStack(allocations[e.block.type]!!))
            }
        }
    }
}