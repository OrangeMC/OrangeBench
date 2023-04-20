package moe.orangemc.orangebench.config.resourcepack;

import org.bukkit.configuration.ConfigurationSection;

public final class ResourcePackConfig {
    private final ResourcePackInfoConfig clientConfig;
    private final ResourcePackDistributorConfig distributorConfig;

    public ResourcePackConfig(ConfigurationSection config) {
        this.clientConfig = new ResourcePackInfoConfig(config.getConfigurationSection("client-addr"));
        this.distributorConfig = new ResourcePackDistributorConfig(config.getConfigurationSection("builtin-distributor"));
    }

    public ResourcePackInfoConfig getClientConfig() {
        return clientConfig;
    }

    public ResourcePackDistributorConfig getDistributorConfig() {
        return distributorConfig;
    }
}
