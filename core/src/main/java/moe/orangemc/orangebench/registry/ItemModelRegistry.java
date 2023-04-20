package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.OrangeBenchPlugin;
import moe.orangemc.orangebench.api.block.BlockModel;
import moe.orangemc.orangebench.api.item.ItemModel;
import moe.orangemc.orangebench.api.registry.BuiltinRegistryKeySet;
import moe.orangemc.orangebench.storage.Storage;
import net.kyori.adventure.key.Key;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

public final class ItemModelRegistry extends RegistryBase<ItemModel> {
    @Override
    public @NotNull Key key() {
        return BuiltinRegistryKeySet.ITEM_MODEL.getKey();
    }

    @Override
    public <U extends ItemModel> void register(@NotNull U target) {
        Validate.isTrue(RootRegistry.getInstance().get(BuiltinRegistryKeySet.BLOCK_MODEL.getKey()).get(target.key()) == null, "Unable to share same key between block models and item models");

        super.register(target);
        this.updateModelId(target);
    }

    private <U extends ItemModel> void updateModelId(U target) {
        Storage storage = OrangeBenchPlugin.getInstance().getStorage();
        int id = storage.getModelId(target.key());
        if (id == 0) {
            id = OrangeBenchPlugin.getInstance().getIdGenerator().generateModelId(target.key());
            storage.putModelId(target.key(), id);
        }
        target.setModelId(id);
    }
}
