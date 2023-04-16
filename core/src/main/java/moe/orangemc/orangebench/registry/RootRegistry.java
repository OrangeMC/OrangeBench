package moe.orangemc.orangebench.registry;

import moe.orangemc.orangebench.api.registry.BenchRegistry;
import moe.orangemc.orangebench.api.registry.BuiltinRegistryKeySet;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

public final class RootRegistry extends RegistryBase<BenchRegistry<?>> {
    private static RootRegistry instance = null;

    private RootRegistry() {
        this.register(this);
    }

    @Override
    public @NotNull Key key() {
        return BuiltinRegistryKeySet.ROOT.getKey();
    }

    public static RootRegistry getInstance() {
        if (instance == null) {
            instance = new RootRegistry();

            instance.register(new BlockModelRegistry());
            instance.register(new BlockRegistry());
            instance.register(new ItemModelRegistry());
            instance.register(new ItemRegistry());
        }
        return instance;
    }
}
