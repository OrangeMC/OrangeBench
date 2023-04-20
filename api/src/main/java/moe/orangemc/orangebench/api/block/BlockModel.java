package moe.orangemc.orangebench.api.block;

import moe.orangemc.orangebench.api.item.ItemModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.kyori.adventure.key.Keyed;

public abstract class BlockModel implements Keyed {
    private boolean registered;
    private int modelId;

    public abstract @NotNull String getModelResourcePath();
    public abstract @Nullable ItemModel getParentModel();

    public final void setModelId(int id) {
        if (this.registered) {
            throw new IllegalStateException("This model is already registered. Pass \"I know what i'm doing. Just shut up and I promise it is absolutely safe\" as the second argument to overwrite model id forcefully.");
        }
        this.registered = true;
        this.modelId = id;
    }
    public final void setModelId(int id, @Nullable String promise) {
        if (this.registered && "I know what I'm doing. Just shut up and I promise it is absolutely safe".equals(promise)) {
            this.modelId = id;
        } else {
            setModelId(id);
        }
    }
    public final int getModelId() {
        if (!registered) {
            throw new IllegalStateException("This model is not registered.");
        }
        return this.modelId;
    }
}
