package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.api.block.BlockModel;
import moe.orangemc.orangebench.api.registry.BuiltinRegistryKeySet;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

public class BlockModelRegistry extends RegistryBase<BlockModel> {
    @Override
    public @NotNull Key key() {
        return BuiltinRegistryKeySet.BLOCK_MODEL.getKey();
    }
}
