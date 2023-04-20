package moe.orangemc.orangebench.storage;

import moe.orangemc.orangebench.config.storage.StorageConfig;
import moe.orangemc.orangebench.storage.file.FileStorage;
import moe.orangemc.orangebench.storage.sql.MySQLStorage;
import moe.orangemc.orangebench.storage.sql.PostgresqlStorage;

public final class StorageFactory {
    private StorageFactory() {
        throw new UnsupportedOperationException();
    }
    public static Storage createStorage(StorageConfig config) {
        return switch (config.getStorageType()) {
            case FILE -> new FileStorage();
            case MYSQL -> new MySQLStorage(config.getConnectionConfig(), config.getDatabaseName());
            case POSTGRESQL -> new PostgresqlStorage(config.getConnectionConfig(), config.getDatabaseName());
        };
    }
}
