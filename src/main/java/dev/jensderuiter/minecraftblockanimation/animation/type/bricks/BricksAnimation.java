package dev.jensderuiter.minecraftblockanimation.animation.type;

import dev.jensderuiter.minecraftblockanimation.animation.BaseAnimation;
import org.bukkit.Location;
import org.bukkit.Material;

public class BricksAnimation extends BaseAnimation {
    public BricksAnimation(Location location) {
        super(location);
    }

    @Override
    protected void completed() {
        this.location.getBlock().setType(Material.BRICKS);
    }
}
