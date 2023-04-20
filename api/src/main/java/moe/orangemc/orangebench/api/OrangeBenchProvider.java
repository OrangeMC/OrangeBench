package moe.orangemc.orangebench.api;

import moe.orangemc.orangebench.api.item.KeyedItem;
import moe.orangemc.orangebench.api.registry.BenchRegistry;
import net.kyori.adventure.key.Key;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ApiStatus.NonExtendable
public interface OrangeBenchProvider {
    @NotNull Plugin getProviderPlugin();
    @NotNull BenchRegistry<BenchRegistry<?>> getRootRegistry();

    @Nullable ItemStack makeItemStack(Key itemKey);
    @NotNull ItemStack makeItemStack(KeyedItem item);

    boolean isAvailable();
}
