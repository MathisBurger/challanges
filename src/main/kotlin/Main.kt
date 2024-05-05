package de.mathisburger

import de.mathisburger.challanges.randomizer.*
import de.mathisburger.utility.BackbackCommand
import de.mathisburger.utility.InvLookupCommand
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

/**
 * Main entrypoint of minecraft plugin
 */
final class Main : JavaPlugin() {

    override fun onEnable() {

        // Register utility commands
        getCommand("backpack")?.setExecutor(BackbackCommand());
        getCommand("invLookup")?.setExecutor(InvLookupCommand(this))

        // Register listeners and commands for randomizer
        getCommand("randomizer")?.setExecutor(RandomizerCommand())
        getCommand("randomizerDebug")?.setExecutor(RandomizerDebugCommand())

        server.pluginManager.registerEvents(RandomizerCraftingListener(), this)
        server.pluginManager.registerEvents(RandomizerBlockListener(), this)
        server.pluginManager.registerEvents(RandomizerEntityDropListener(), this)
        println("initialized")
    }

    override fun onDisable() {

    }
}