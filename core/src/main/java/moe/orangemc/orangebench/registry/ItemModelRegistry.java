package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.api.item.ItemModel;
import moe.orangemc.orangebench.api.registry.BuiltinRegistryKeySet;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

public class ItemModelRegistry extends RegistryBase<ItemModel> {
    @Override
    public @NotNull Key key() {
        return BuiltinRegistryKeySet.ITEM_MODEL.getKey();
    }
}
