package moe.orangemc.orangebench.config.storage;

import moe.orangemc.orangebench.config.connection.AuthenticatedConnectionConfig;
import org.bukkit.configuration.ConfigurationSection;

public final class StorageConfig {
    private final AuthenticatedConnectionConfig connectionConfig;
    private final String databaseName;
    private final StorageType storageType;

    public StorageConfig(ConfigurationSection config) {
        this.connectionConfig = new AuthenticatedConnectionConfig(config);
        this.databaseName = config.getString("database");
        this.storageType = StorageType.fromString(config.getString("type"));
    }

    public AuthenticatedConnectionConfig getConnectionConfig() {
        return connectionConfig;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public String getDatabaseName() {
        return databaseName;
    }
}
