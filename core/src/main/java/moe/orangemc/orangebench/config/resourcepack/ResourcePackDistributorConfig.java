package moe.orangemc.orangebench.config.resourcepack;

import org.bukkit.configuration.ConfigurationSection;

public final class ResourcePackDistributorConfig extends ResourcePackInfoConfig {
    private final boolean enabled;

    public ResourcePackDistributorConfig(ConfigurationSection config) {
        super(config);
        this.enabled = config.getBoolean("enabled");
    }

    public boolean isEnabled() {
        return enabled;
    }
}
