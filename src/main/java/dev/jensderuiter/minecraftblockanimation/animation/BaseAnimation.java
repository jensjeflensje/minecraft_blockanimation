package dev.jensderuiter.minecraftblockanimation.animation;

import dev.jensderuiter.minecraftblockanimation.BlockAnimationPlugin;
import dev.jensderuiter.minecraftblockanimation.animation.stage.AnimationStage;
import lombok.Getter;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class BaseAnimation implements Animation {

    @Getter
    private int tick;
    @Getter
    private boolean running;

    @Getter
    protected Location location;
    protected AnimationRunnable runnable;
    protected List<AnimationStage> stages;
    protected List<AnimationStage> activeStages;
    protected CompletableFuture<Void> future;

    public BaseAnimation(Location location) {
        this.location = location;
        this.runnable = this.initRunnable();
        this.stages = new ArrayList<>();
        this.activeStages = new ArrayList<>();

        this.tick = 0;
        this.running = false;

        this.future = new CompletableFuture<>();
    }

    @Override
    public CompletableFuture<Void> start() {
        this.runnable.runTaskTimer(BlockAnimationPlugin.getInstance(), 0L, 1L);
        this.running = true;
        return future;
    }

    @Override
    public void tick() {
        this.tick++;

        if (this.tick > this.getDuration()) {
            // animation is done
            this.destroy();
            this.future.complete(null);
            this.completed();
        }


        for (AnimationStage stage : this.stages) {
            // remove stages that are done
            if (this.activeStages.contains(stage) && this.tick > stage.getTriggerTick() + stage.getTotalTicks()) {
                this.activeStages.remove(stage);
            }

            // add new stages
            if (this.tick > stage.getTriggerTick()
                    && this.tick < stage.getTriggerTick() + stage.getTotalTicks()
                    && !this.activeStages.contains(stage)) {
                this.activeStages.add(stage);
                stage.start();
            }
        }

        this.activeStages.forEach((stage) -> stage.trigger(this.tick - stage.getTriggerTick()));
    }

    @Override
    public void destroy() {
        this.stages.forEach(AnimationStage::destroy);
        this.runnable.cancel();
        this.running = false;
    }

    @Override
    public int getDuration() {
        return this.stages
                .stream()
                .map((stage) -> stage.getTriggerTick() + stage.getTotalTicks())
                .max(Integer::compare)
                .orElse(0);
    }

    protected AnimationRunnable initRunnable() {
        return new AnimationRunnable(this);
    }

    protected void completed() {
        // ran whenever an animation has completed
        // can be overwritten by inheritance
    }

}
