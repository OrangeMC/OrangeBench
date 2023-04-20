package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.api.item.KeyedItem;
import moe.orangemc.orangebench.api.registry.BuiltinRegistryKeySet;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

public final class ItemRegistry extends RegistryBase<KeyedItem> {
    @Override
    public @NotNull Key key() {
        return BuiltinRegistryKeySet.ITEM.getKey();
    }
}
