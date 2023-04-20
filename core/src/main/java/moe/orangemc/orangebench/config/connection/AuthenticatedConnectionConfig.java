package moe.orangemc.orangebench.config.connection;

import org.bukkit.configuration.ConfigurationSection;

public class AuthenticatedConnectionConfig extends ConnectionConfig {
    private final String user;
    private final String pass;

    public AuthenticatedConnectionConfig(ConfigurationSection config) {
        super(config);

        this.user = config.getString("user");
        this.pass = config.getString("pass");
    }

    public final String getUser() {
        return user;
    }

    public final String getPass() {
        return pass;
    }
}
