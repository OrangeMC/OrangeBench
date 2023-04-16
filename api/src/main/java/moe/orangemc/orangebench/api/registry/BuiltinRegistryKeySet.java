package moe.orangemc.orangebench.api.registry;

import moe.orangemc.orangebench.api.OrangeBenchApi;
import org.bukkit.NamespacedKey;

public enum BuiltinRegistryKeySet {
    ROOT(new NamespacedKey(OrangeBenchApi.getProvider().getProviderPlugin(), "root_registry")),
    ITEM(new NamespacedKey(OrangeBenchApi.getProvider().getProviderPlugin(), "item_registry")),
    BLOCK(new NamespacedKey(OrangeBenchApi.getProvider().getProviderPlugin(), "block_registry")),
    ITEM_MODEL(new NamespacedKey(OrangeBenchApi.getProvider().getProviderPlugin(), "item_model_registry")),
    BLOCK_MODEL(new NamespacedKey(OrangeBenchApi.getProvider().getProviderPlugin(), "block_model_registry"));

    private final NamespacedKey key;

    BuiltinRegistryKeySet(NamespacedKey key) {
        this.key = key;
    }

    public NamespacedKey getKey() {
        return key;
    }
}
