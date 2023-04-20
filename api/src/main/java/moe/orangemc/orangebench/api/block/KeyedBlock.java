package moe.orangemc.orangebench.api.block;

import moe.orangemc.orangebench.api.OrangeBenchApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;

import java.util.Collections;
import java.util.Set;

public abstract class KeyedBlock implements Keyed {
    public abstract @NotNull Key getModelKey();
    public abstract @NotNull Material getInternalType();

    public boolean destroy(@NotNull Block which) {
        return true;
    }
    public boolean destroy(@NotNull Block which, @NotNull Entity who) {
        return true;
    }
    public boolean place(@NotNull Player who, @NotNull ItemStack what, @NotNull Location where) {
        return true;
    }
    public void update(@NotNull Block which) {

    }
    public boolean isFlammable() {
        return getInternalType().isFlammable();
    }
    public boolean fallOn(@NotNull Entity who) {
        return true;
    }

    public @NotNull Set<ItemStack> getDroppings(@Nullable Player who, @NotNull Block which, @Nullable ItemStack how) {
        ItemStack itemStack = OrangeBenchApi.makeItemStack(this.key());
        if (itemStack == null) {
            return Collections.emptySet();
        }
        return Collections.singleton(itemStack);
    }
}
