package moe.orangemc.orangebench.config;

import moe.orangemc.orangebench.config.resourcepack.ResourcePackConfig;
import moe.orangemc.orangebench.config.storage.StorageConfig;
import org.bukkit.configuration.ConfigurationSection;

public final class PluginConfig {
    private final StorageConfig storage;
    private final ResourcePackConfig resourcePack;

    public PluginConfig(ConfigurationSection config) {
        this.storage = new StorageConfig(config.getConfigurationSection("storage"));
        this.resourcePack = new ResourcePackConfig(config.getConfigurationSection("resource-pack"));
    }

    public StorageConfig getStorage() {
        return storage;
    }

    public ResourcePackConfig getResourcePack() {
        return resourcePack;
    }
}
