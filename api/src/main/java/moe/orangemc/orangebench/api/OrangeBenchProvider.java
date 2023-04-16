package moe.orangemc.orangebench.api;

import moe.orangemc.orangebench.api.registry.BenchRegistry;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.NonExtendable
public interface OrangeBenchProvider {
    @NotNull
    Plugin getProviderPlugin();
    @NotNull
    BenchRegistry<BenchRegistry<?>> getRootRegistry();
}
