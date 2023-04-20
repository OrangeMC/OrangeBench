package moe.orangemc.orangebench.config.resourcepack;

import moe.orangemc.orangebench.config.connection.ConnectionConfig;
import org.bukkit.configuration.ConfigurationSection;

public class ResourcePackInfoConfig extends ConnectionConfig {
    private final String path;

    public ResourcePackInfoConfig(ConfigurationSection config) {
        super(config);
        this.path = config.getString("path");
    }

    public String getPath() {
        return path;
    }
}
