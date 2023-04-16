package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.api.registry.BenchRegistry;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class RegistryBase<T extends Keyed> implements BenchRegistry<T> {
    private final Map<Key, T> registeredMap = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <U extends T> U get(@NotNull Key key) {
        Validate.notNull(key, "Cannot have a null key");

        T result = registeredMap.get(key);
        try {
            return (U) result;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public <U extends T> void register(@NotNull U target) {
        Validate.notNull(target, "Cannot register a null thing");

        registeredMap.put(target.key(), target);
    }

    @Override
    public @NotNull Map<Key, T> getRegisteredItems() {
        return Collections.unmodifiableMap(registeredMap);
    }
}
