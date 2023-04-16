package moe.orangemc.orangebench;

import org.bukkit.plugin.java.JavaPlugin;

public final class OrangeBenchPlugin extends JavaPlugin {
    private static OrangeBenchPlugin instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static OrangeBenchPlugin getInstance() {
        return instance;
    }
}
