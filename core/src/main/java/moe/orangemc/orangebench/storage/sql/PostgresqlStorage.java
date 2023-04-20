package moe.orangemc.orangebench.storage.sql;

import com.zaxxer.hikari.HikariConfig;
import moe.orangemc.orangebench.config.connection.AuthenticatedConnectionConfig;

public class PostgresqlStorage extends GeneralSQLStorage {
    public PostgresqlStorage(AuthenticatedConnectionConfig connectionConfig, String dbName) {
        super(connectionConfig, dbName);
    }

    @Override
    protected HikariConfig generateConfig(AuthenticatedConnectionConfig connectionConfig, String dbName) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://" + connectionConfig.getHost() + ":" + connectionConfig.getPort() + "/" + dbName);
        hikariConfig.setUsername(connectionConfig.getUser());
        hikariConfig.setPassword(connectionConfig.getPass());
        return hikariConfig;
    }
}
