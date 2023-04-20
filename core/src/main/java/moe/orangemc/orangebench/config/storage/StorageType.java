package moe.orangemc.orangebench.config.storage;

public enum StorageType {
    FILE,
    MYSQL,
    POSTGRESQL;

    public static StorageType fromString(String type) {
        return switch (type) {
            case "mysql" -> MYSQL;
            case "postgresql" -> POSTGRESQL;
            default -> FILE;
        };
    }
}
