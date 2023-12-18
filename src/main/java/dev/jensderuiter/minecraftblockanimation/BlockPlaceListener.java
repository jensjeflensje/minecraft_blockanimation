package dev.jensderuiter.minecraftblockanimation;

import dev.jensderuiter.minecraftblockanimation.animation.type.bricks.BricksAnimation;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType() != Material.BRICKS) return;

        event.setCancelled(true);
        new BricksAnimation(event.getBlock().getLocation()).start();
        event.getPlayer().sendMessage("Triggered");
    }

}
