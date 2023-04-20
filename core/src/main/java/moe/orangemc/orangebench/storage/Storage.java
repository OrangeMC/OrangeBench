package moe.orangemc.orangebench.storage;

import net.kyori.adventure.key.Key;

import java.util.Map;

public interface Storage {

    void putModelId(Key target, int id);
    int getModelId(Key target);
    void saveAll();

    Map<Key, Integer> getAllIds();
}
