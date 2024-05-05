package de.mathisburger

import de.mathisburger.challanges.randomizer.*
import de.mathisburger.config.ConfigCommand
import de.mathisburger.config.ConfigInventory
import de.mathisburger.utility.BackbackCommand
import de.mathisburger.utility.InvLookupCommand
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

/**
 * Main entrypoint of minecraft plugin
 */
final class Main : JavaPlugin() {

    override fun onEnable() {

        // config command
        val configInv = ConfigInventory()
        getCommand("config")?.setExecutor(ConfigCommand(configInv))
        server.pluginManager.registerEvents(configInv, this)

        // Register utility commands
        getCommand("backpack")?.setExecutor(BackbackCommand());
        getCommand("invLookup")?.setExecutor(InvLookupCommand(this))

        // Register listeners and commands for randomizer
        getCommand("randomizerDebug")?.setExecutor(RandomizerDebugCommand())
        server.pluginManager.registerEvents(RandomizerCraftingListener(), this)
        server.pluginManager.registerEvents(RandomizerBlockListener(), this)
        server.pluginManager.registerEvents(RandomizerEntityDropListener(), this)
        println("initialized")
    }

    override fun onDisable() {

    }
}