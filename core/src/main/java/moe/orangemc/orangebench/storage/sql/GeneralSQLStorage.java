package moe.orangemc.orangebench.storage.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import moe.orangemc.orangebench.config.connection.AuthenticatedConnectionConfig;
import moe.orangemc.orangebench.storage.Storage;
import moe.orangemc.orangebench.util.SneakyExceptionThrower;
import net.kyori.adventure.key.Key;
import org.bukkit.NamespacedKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class GeneralSQLStorage implements Storage {
    private final HikariDataSource hds;

    public GeneralSQLStorage(AuthenticatedConnectionConfig connectionConfig, String dbName) {
        hds = new HikariDataSource(generateConfig(connectionConfig, dbName));
        initTables();
    }

    protected abstract HikariConfig generateConfig(AuthenticatedConnectionConfig connectionConfig, String dbName);

    private void initTables() {
        try (Connection connection = hds.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `models` (" +
                    "`id` INT NOT NULL auto_increment," +
                    "`namespace` VARCHAR(16) NOT NULL," +
                    "`key` VARCHAR(256) NOT NULL," +
                    "`model_id` INT NOT NULL," +
                    ");")) {
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void putModelId(Key target, int id) {
        boolean exists = getModelId(target) != 0;
        try (Connection connection = hds.getConnection()) {
            if (exists) {
                try (PreparedStatement ps = connection.prepareStatement("UPDATE models SET model_id=? WHERE namespace=? AND key=?")) {
                    ps.setInt(1, id);
                    ps.setString(2, target.namespace());
                    ps.setString(3, target.value());
                    ps.executeUpdate();
                }
            } else {
                try (PreparedStatement ps = connection.prepareStatement("INSERT INTO models (namespace,key,model_id) VALUES (?,?,?)")) {
                    ps.setString(1, target.namespace());
                    ps.setString(2, target.value());
                    ps.setInt(3, id);
                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public int getModelId(Key target) {
        try (Connection connection = hds.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT model_id FROM `models` WHERE namespace=? AND key=?")) {
                ps.setString(1, target.namespace());
                ps.setString(2, target.value());
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.first()) {
                        return 0;
                    }
                    return rs.getInt("model_id");
                }
            }
        } catch (SQLException e) {
            SneakyExceptionThrower.throwException(e);
        }
        return 0;
    }

    @Override
    public void saveAll() {
        // Nothing to do
    }

    @Override
    public Map<Key, Integer> getAllIds() {
        Map<Key, Integer> modelIds = new HashMap<>();
        try (Connection connection = hds.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM `models`")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String namespace = rs.getString("namespace");
                        String key = rs.getString("key");
                        int id = rs.getInt("model_id");

                        modelIds.put(new NamespacedKey(namespace, key), id);
                    }
                }
            }
        } catch (SQLException e) {
            SneakyExceptionThrower.throwException(e);
        }
        return Collections.unmodifiableMap(modelIds);
    }
}
