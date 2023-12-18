package dev.jensderuiter.minecraftblockanimation.animation.type.bricks;

import dev.jensderuiter.minecraftblockanimation.animation.BaseAnimation;
import dev.jensderuiter.minecraftblockanimation.animation.type.bricks.stage.BrickLayAnimationStage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public class BricksAnimation extends BaseAnimation {

    public BricksAnimation(Location location) {
        super(location);

        for (int i = 0; i < 5; i++) {
            this.stages.add(new BrickLayAnimationStage(this, i*16, new Vector(0.25, i/5f, 0.2)));
            this.stages.add(new BrickLayAnimationStage(this, i*16+2, new Vector(0.25, i/5f, 0.4)));
            this.stages.add(new BrickLayAnimationStage(this, i*16+4, new Vector(0.25, i/5f, 0.6)));
            this.stages.add(new BrickLayAnimationStage(this, i*16+6, new Vector(0.25, i/5f, 0.8)));

            this.stages.add(new BrickLayAnimationStage(this, i*16+8, new Vector(0.75, i/5f, 0.2)));
            this.stages.add(new BrickLayAnimationStage(this, i*16+10, new Vector(0.75, i/5f, 0.4)));
            this.stages.add(new BrickLayAnimationStage(this, i*16+12, new Vector(0.75, i/5f, 0.6)));
            this.stages.add(new BrickLayAnimationStage(this, i*16+14, new Vector(0.75, i/5f, 0.8)));
        }
    }

    @Override
    protected void completed() {
        this.location.getBlock().setType(Material.BRICKS);
    }
}
