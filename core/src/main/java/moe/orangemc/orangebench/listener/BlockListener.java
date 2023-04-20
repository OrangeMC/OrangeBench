package moe.orangemc.orangebench.listener;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onBlockBreakBlock(BlockBreakBlockEvent event) {
    }
}
