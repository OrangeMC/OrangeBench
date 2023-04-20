package moe.orangemc.orangebench.storage.file;

import moe.orangemc.orangebench.OrangeBenchPlugin;
import moe.orangemc.orangebench.storage.Storage;
import moe.orangemc.orangebench.storage.file.io.FileDataStreams;
import moe.orangemc.orangebench.storage.file.io.SilentFileDataInputStream;
import moe.orangemc.orangebench.storage.file.io.SilentFileDataOutputStream;
import net.kyori.adventure.key.Key;
import org.bukkit.NamespacedKey;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileStorage implements Storage {
    private final Map<Key, Integer> modelIds = new ConcurrentHashMap<>();

    public FileStorage() {
        SilentFileDataInputStream dis = FileDataStreams.createInputStream(new File(OrangeBenchPlugin.getInstance().getDataFolder(), "models.dat"));
        int amount = dis.readInt();
        for (int i = 0; i < amount; i ++) {
            String namespace = dis.readString();
            String key = dis.readString();
            int id = dis.readInt();

            modelIds.put(new NamespacedKey(namespace, key), id);
        }
    }

    @Override
    public void putModelId(Key target, int id) {
        this.modelIds.put(target, id);
    }

    @Override
    public int getModelId(Key target) {
        return this.modelIds.getOrDefault(target, 0);
    }

    @Override
    public void saveAll() {
        SilentFileDataOutputStream dos = FileDataStreams.createOutputStream(new File(OrangeBenchPlugin.getInstance().getDataFolder(), "models.dat"));
        dos.writeInt(modelIds.size());
        modelIds.forEach((key, id) -> {
            dos.writeString(key.namespace());
            dos.writeString(key.value());
            dos.writeInt(id);
        });
    }

    @Override
    public Map<Key, Integer> getAllIds() {
        return Collections.unmodifiableMap(this.modelIds);
    }
}
