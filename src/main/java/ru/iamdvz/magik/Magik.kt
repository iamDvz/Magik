package ru.iamdvz.magik;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import org.bukkit.plugin.java.JavaPlugin;
import ru.iamdvz.magik.listeners.MagicSpellsListener;

public final class Magik extends JavaPlugin {
    private static Magik instance;
    static ProtocolManager protocolManager;


    @Override
    public void onEnable() {
        instance = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        getServer().getPluginManager().registerEvents(new MagicSpellsListener(), this);


    }
    public static Magik getInstance() {
        return instance;
    }
    public static ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    //@Override
    //public void onDisable() {
        // Plugin shutdown logic
    //}
}
