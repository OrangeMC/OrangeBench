package moe.orangemc.orangebench;

import moe.orangemc.orangebench.api.OrangeBenchProvider;
import moe.orangemc.orangebench.api.item.KeyedItem;
import moe.orangemc.orangebench.api.registry.BenchRegistry;
import moe.orangemc.orangebench.registry.RootRegistry;
import net.kyori.adventure.key.Key;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OrangeBenchProviderImpl implements OrangeBenchProvider {
    @Override
    public @NotNull Plugin getProviderPlugin() {
        return OrangeBenchPlugin.getInstance();
    }

    @Override
    public @NotNull BenchRegistry<BenchRegistry<?>> getRootRegistry() {
        Validate.isTrue(isAvailable(), "API is not available yet");

        return RootRegistry.getInstance();
    }

    @Override
    public @Nullable ItemStack makeItemStack(Key itemKey) {
        Validate.notNull(itemKey, "Key cannot be null");
        Validate.isTrue(isAvailable(), "API is not available yet");

        return null;
    }

    @Override
    public @NotNull ItemStack makeItemStack(KeyedItem item) {
        Validate.notNull(item, "Item instance cannot be null");
        Validate.isTrue(isAvailable(), "API is not available yet");

        return null;
    }

    @Override
    public boolean isAvailable() {
        return getProviderPlugin().isEnabled();
    }
}
