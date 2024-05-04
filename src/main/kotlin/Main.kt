package de.mathisburger

import de.mathisburger.challanges.randomizer.*
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

/**
 * Main entrypoint of minecraft plugin
 */
final class Main : JavaPlugin() {

    override fun onEnable() {

        // Register listeners and commands for randomizer
        getCommand("randomizer")?.setExecutor(RandomizerCommand(this))
        getCommand("randomizerDebug")?.setExecutor(RandomizerDebugCommand())

        server.pluginManager.registerEvents(RandomizerCraftingListener(), this)
        server.pluginManager.registerEvents(RandomizerBlockListener(), this)
        server.pluginManager.registerEvents(RandomizerEntityDropListener(), this)
    }
}