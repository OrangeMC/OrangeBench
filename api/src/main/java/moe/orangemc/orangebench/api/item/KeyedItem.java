package moe.orangemc.orangebench.api.item;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class KeyedItem implements Keyed {
    public abstract @NotNull Key getItemModelKey();
    public abstract @NotNull Material getInternalType();

    public boolean onUse(@NotNull Player who, @NotNull ItemStack what, @NotNull Block where) {
        return true;
    }
    public boolean onUse(@NotNull Player who, @NotNull ItemStack what, @NotNull Entity which) {
        return true;
    }
    public boolean onUse(@NotNull Player who, @NotNull ItemStack what) {
        return true;
    }
    public double hitEntity(@NotNull Player who, @NotNull ItemStack what, @NotNull Entity which) {
        return 1;
    }
    public boolean onBreak(@NotNull Player who, @NotNull ItemStack what) {
        return true;
    }

    public float getBreakSpeed(@NotNull Player who, @NotNull ItemStack what, @NotNull Block target) {
        return 1;
    }

    public boolean canRepairInAnvil(@NotNull ItemStack repair, @NotNull ItemStack material) {
        return false;
    }

    public boolean resistsFire(@NotNull ItemStack which) {
        return false;
    }
}
