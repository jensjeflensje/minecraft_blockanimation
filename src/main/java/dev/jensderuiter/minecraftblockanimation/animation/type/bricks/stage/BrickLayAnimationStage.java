package dev.jensderuiter.minecraftblockanimation.animation.type.bricks.stage;

import dev.jensderuiter.minecraftblockanimation.animation.stage.BaseVariableTriggerTickAnimationStage;
import dev.jensderuiter.minecraftblockanimation.animation.type.bricks.BricksAnimation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

public class BrickLayAnimationStage extends BaseVariableTriggerTickAnimationStage {

    private final double Y_OFFSET = 0.4; // this is the amount the brick will move to get into its final position

    private BricksAnimation animation;
    private Vector offset;
    private Location offsetLocation; // final location
    private ItemDisplay brickDisplay;

    public BrickLayAnimationStage(BricksAnimation animation, int triggerTick, Vector offset) {
        super(triggerTick);
        this.animation = animation;
        this.offset = offset;
        this.offsetLocation = animation.getLocation().clone().add(this.offset);
    }

    @Override
    public void start() {
        this.brickDisplay = (ItemDisplay) this.animation.getLocation().getWorld().spawnEntity(
                this.offsetLocation.clone().add(0, Y_OFFSET, 0),
                EntityType.ITEM_DISPLAY
        );
        this.brickDisplay.setItemStack(new ItemStack(Material.BRICK));
        Transformation transform = this.brickDisplay.getTransformation();
        transform.getRightRotation().setAngleAxis(Math.toRadians(90), 1, 0, 0);
        transform.getScale().set(0.6f, 3.2f, 0.6f);
        this.brickDisplay.setTransformation(transform);

        this.entities.add(this.brickDisplay);
    }

    @Override
    public void trigger(int tick) {
        this.brickDisplay.teleport(
                this.offsetLocation.clone().add(0, Y_OFFSET - (Y_OFFSET / this.getTotalTicks() * tick), 0));
    }

    @Override
    public int getTotalTicks() {
        return 5;
    }
}
