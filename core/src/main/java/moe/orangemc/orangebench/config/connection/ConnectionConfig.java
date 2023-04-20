package moe.orangemc.orangebench.config.connection;

import org.bukkit.configuration.ConfigurationSection;

public class ConnectionConfig {
    private final String host;
    private final int port;

    public ConnectionConfig(ConfigurationSection config) {
        this.host = config.getString("host");
        this.port = config.getInt("port");
    }

    public final String getHost() {
        return host;
    }

    public final int getPort() {
        return port;
    }
}
