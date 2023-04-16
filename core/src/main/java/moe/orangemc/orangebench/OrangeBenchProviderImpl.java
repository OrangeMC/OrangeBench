package moe.orangemc.orangebench;

import moe.orangemc.orangebench.api.OrangeBenchProvider;
import moe.orangemc.orangebench.api.registry.BenchRegistry;
import moe.orangemc.orangebench.registry.RootRegistry;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class OrangeBenchProviderImpl implements OrangeBenchProvider {
    @Override
    public @NotNull Plugin getProviderPlugin() {
        return OrangeBenchPlugin.getInstance();
    }

    @Override
    public @NotNull BenchRegistry<BenchRegistry<?>> getRootRegistry() {
        return RootRegistry.getInstance();
    }
}
