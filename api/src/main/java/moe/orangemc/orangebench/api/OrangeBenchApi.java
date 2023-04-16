package moe.orangemc.orangebench.api;

import moe.orangemc.orangebench.api.registry.BenchRegistry;

public final class OrangeBenchApi {
    private static OrangeBenchProvider provider;

    public static OrangeBenchProvider getProvider() {
        return provider;
    }

    public static void setProvider(OrangeBenchProvider provider) {
        if (OrangeBenchApi.provider != null) {
            throw new IllegalStateException("There's already an API provider here.");
        }
        OrangeBenchApi.provider = provider;
    }

    public static BenchRegistry<BenchRegistry<?>> getRootRegistry() {
        return provider.getRootRegistry();
    }
}
