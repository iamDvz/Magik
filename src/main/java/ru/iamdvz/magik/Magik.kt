package ru.iamdvz.magik

import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.ProtocolManager
import org.bukkit.plugin.java.JavaPlugin
import ru.iamdvz.magik.listeners.MagicSpellsListener

class Magik : JavaPlugin() {
    override fun onEnable() {
        instance = this;
        protocolManager = ProtocolLibrary.getProtocolManager()
        server.pluginManager.registerEvents(MagicSpellsListener(), this)
    }

    override fun onDisable() {
    }

    fun getInstance(): Magik = this

    companion object {
        var instance: Magik? = null
        var protocolManager: ProtocolManager? = null
    }
}
