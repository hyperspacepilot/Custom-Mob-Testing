package de.hyper.mobs.domain;

import de.hyper.mobs.domain.commands.TestCommand;
import de.hyper.mobs.domain.events.CustomMobEvents;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class CustomMobs extends JavaPlugin {

    @Getter
    @Setter
    private static CustomMobs instance;

    private PluginManager pluginManager;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.pluginManager = Bukkit.getPluginManager();
        getCommand("testmob").setExecutor(new TestCommand());
        this.pluginManager.registerEvents(new CustomMobEvents(), instance);
    }

    @Override
    public void onDisable() {

    }

    public static CustomMobs get() {
        return instance;
    }
}
