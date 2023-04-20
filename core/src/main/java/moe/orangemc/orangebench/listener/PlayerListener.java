package moe.orangemc.orangebench.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;

public class PlayerListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {

    }
}
