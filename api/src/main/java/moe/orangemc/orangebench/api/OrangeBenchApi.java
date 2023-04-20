package moe.orangemc.orangebench.api;

import moe.orangemc.orangebench.api.item.KeyedItem;
import moe.orangemc.orangebench.api.registry.BenchRegistry;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.bukkit.inventory.ItemStack;
import net.kyori.adventure.key.Key;

public final class OrangeBenchApi {
    private static OrangeBenchProvider provider = null;

    public static @NotNull OrangeBenchProvider getProvider() {
        return provider;
    }

    public static void setProvider(@NotNull OrangeBenchProvider provider) {
        Validate.notNull(provider, "Cannot set a null provider");
        if (OrangeBenchApi.provider != null) {
            throw new IllegalStateException("There's already an API provider here. Pass \"I know what I'm doing. Just shut up and I promise it is absolutely safe\" to override currently existing provider");
        }
        OrangeBenchApi.provider = provider;
    }

    public static void setProvider(@NotNull OrangeBenchProvider provider, @Nullable String promise) {
        if ("I know what I'm doing. Just shut up and I promise it is absolutely safe".equals(promise)) {
            OrangeBenchApi.provider = provider;
        } else {
            setProvider(provider);
        }
    }

    public static @NotNull BenchRegistry<BenchRegistry<?>> getRootRegistry() {
        return provider.getRootRegistry();
    }

    public static @Nullable ItemStack makeItemStack(@NotNull Key itemKey) {
        return provider.makeItemStack(itemKey);
    }
    public static @NotNull ItemStack makeItemStack(@NotNull KeyedItem item) {
        return provider.makeItemStack(item);
    }
}
