package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.api.block.KeyedBlock;
import moe.orangemc.orangebench.api.registry.BuiltinRegistryKeySet;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

public final class BlockRegistry extends RegistryBase<KeyedBlock> {
    @Override
    public @NotNull Key key() {
        return BuiltinRegistryKeySet.BLOCK.getKey();
    }
}
