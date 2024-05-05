package de.mathisburger.config

import de.mathisburger.ChallangeEnum
import de.mathisburger.Variables
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

/**
 * Config inventory mapped class
 */
class ConfigInventory : Listener {

    private var inventory: Inventory;
    private var actions: List<ConfigAction> = emptyList()

    constructor() {
        this.inventory = Bukkit.createInventory(null, 27*2, "Challenge configuration");
        this.setItems();
        this.setItemsActions();
    }

    /**
     * Gets the inventory
     */
    fun getInventory(): Inventory {
        return this.inventory;
    }

    /**
     * Sets default items
     */
    private fun setItems() {
        // Randomizer challenge settings
        this.inventory.setItem(0, ConfigStatics.generalItems[0]);
        this.inventory.setItem(1, ConfigStatics.generalItems[1]);
        this.inventory.setItem(2, ConfigStatics.generalItems[2]);
    }

    /**
     * Sets the item actions
     */
    private fun setItemsActions() {
        this.actions = listOf(
            object :ConfigAction {
                override fun onClick() {
                    val currentItem = inventory.getItem(0);
                    if (currentItem?.type === Material.BOOK) {
                        Variables.currentChallanges.add(ChallangeEnum.RANDOMIZER_BLOCK);
                        inventory.setItem(0, ConfigStatics.statusItems.get("blockRandomizer"));
                    } else {
                        Variables.currentChallanges.remove(ChallangeEnum.RANDOMIZER_BLOCK);
                        inventory.setItem(0, ConfigStatics.generalItems[0]);
                    }
                }
            },
            object :ConfigAction {
                override fun onClick() {
                    val currentItem = inventory.getItem(1);
                    if (currentItem?.type === Material.BOOK) {
                        Variables.currentChallanges.add(ChallangeEnum.RANDOMIZER_DROP);
                        inventory.setItem(1, ConfigStatics.statusItems.get("dropRandomizer"));
                    } else {
                        Variables.currentChallanges.remove(ChallangeEnum.RANDOMIZER_DROP);
                        inventory.setItem(1, ConfigStatics.generalItems[1]);
                    }
                }
            },
            object :ConfigAction {
                override fun onClick() {
                    val currentItem = inventory.getItem(2);
                    if (currentItem?.type === Material.BOOK) {
                        Variables.currentChallanges.add(ChallangeEnum.RANDOMIZER_CRAFT);
                        inventory.setItem(2, ConfigStatics.statusItems.get("craftRandomizer"));
                    } else {
                        Variables.currentChallanges.remove(ChallangeEnum.RANDOMIZER_CRAFT);
                        inventory.setItem(2, ConfigStatics.generalItems[2]);
                    }
                }
            }
        )
    }

    /**
     * Handles inventory click event
     */
    @EventHandler
    fun onClick(e: InventoryClickEvent) {
        if (ConfigInventory.checkInventoriesForEquality(e.inventory, this.inventory)) {
            e.isCancelled = true;
            val index = this.inventory.indexOf(e.currentItem);
            this.actions[index].onClick();
        }
    }

    companion object {
        /**
         * Creates a new item
         */
        fun createItem(material: Material, title: String, description: String): ItemStack {
            val item = ItemStack(material, 1);
            val meta = item.itemMeta;
            meta?.setDisplayName(title);
            meta?.lore = listOf(description);
            item.itemMeta = meta;
            return ItemStack(item);
        }

        /**
         * Checks inventories for equality
         */
        fun checkInventoriesForEquality(inv1: Inventory, inv2: Inventory): Boolean {
            if (inv1.size !== inv2.size)  {
                return false;
            }
            for (i in 0..(inv1.size-1)) {
                if (inv1.getItem(i)?.type !== inv2.getItem(i)?.type) {
                    return false;
                }
            }
            return true;
        }
    }
}