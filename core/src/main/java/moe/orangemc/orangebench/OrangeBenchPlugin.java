package moe.orangemc.orangebench;

import moe.orangemc.orangebench.config.PluginConfig;
import moe.orangemc.orangebench.storage.Storage;
import moe.orangemc.orangebench.storage.StorageFactory;
import moe.orangemc.orangebench.util.IdGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public final class OrangeBenchPlugin extends JavaPlugin {
    private static OrangeBenchPlugin instance;

    private Storage storage;
    private IdGenerator idGenerator;
    @Override
    public void onLoad() {
        instance = this;

        if (getDataFolder().exists() && !getDataFolder().isDirectory()) {
            getDataFolder().delete();
        }
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        saveDefaultConfig();

        PluginConfig config = new PluginConfig(getConfig());
        storage = StorageFactory.createStorage(config.getStorage());
    }

    @Override
    public void onEnable() {
        idGenerator = new IdGenerator();
        storage.getAllIds().forEach((key, id) -> idGenerator.addUsedId(id));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static OrangeBenchPlugin getInstance() {
        return instance;
    }

    public Storage getStorage() {
        return storage;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }
}
