package ru.iamdvz.magik;

import org.bukkit.plugin.java.JavaPlugin;
import ru.iamdvz.magik.listeners.MagicSpellsListener;

public final class Magik extends JavaPlugin {
    private static Magik instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new MagicSpellsListener(), this);

    }
    public static Magik getInstance() {
        return instance;
    }

    //@Override
    //public void onDisable() {
        // Plugin shutdown logic
    //}
}
