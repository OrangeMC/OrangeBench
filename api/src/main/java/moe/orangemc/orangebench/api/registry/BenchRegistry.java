package moe.orangemc.orangebench.api.registry;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface BenchRegistry<T extends Keyed> extends Keyed {
    @Nullable <U extends T> U get(@NotNull Key key);
    <U extends T> void register(@NotNull U target);
    @NotNull Map<Key, T> getRegisteredItems();
}
