package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.OrangeBenchPlugin;
import moe.orangemc.orangebench.api.block.BlockModel;
import moe.orangemc.orangebench.api.registry.BuiltinRegistryKeySet;
import moe.orangemc.orangebench.storage.Storage;
import net.kyori.adventure.key.Key;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

public final class BlockModelRegistry extends RegistryBase<BlockModel> {
    @Override
    public @NotNull Key key() {
        return BuiltinRegistryKeySet.BLOCK_MODEL.getKey();
    }

    @Override
    public <U extends BlockModel> void register(@NotNull U target) {
        // Disallow sharing keys between item model and block model
        Validate.isTrue(RootRegistry.getInstance().get(BuiltinRegistryKeySet.ITEM_MODEL.getKey()).get(target.key()) == null, "Unable to share same key between block models and item models");

        super.register(target);
        this.updateModelId(target);
    }

    private <U extends BlockModel> void updateModelId(U target) {
        Storage storage = OrangeBenchPlugin.getInstance().getStorage();
        int id = storage.getModelId(target.key());
        if (id == 0) {
            id = OrangeBenchPlugin.getInstance().getIdGenerator().generateModelId(target.key());
            storage.putModelId(target.key(), id);
        }
        target.setModelId(id);
    }
}
