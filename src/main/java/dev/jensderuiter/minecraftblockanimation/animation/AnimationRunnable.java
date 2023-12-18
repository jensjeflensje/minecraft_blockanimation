package dev.jensderuiter.minecraftblockanimation.animation;

import org.bukkit.scheduler.BukkitRunnable;

public class AnimationRunnable extends BukkitRunnable {

    private final Animation animation;

    public AnimationRunnable(Animation animation) {
        this.animation = animation;
    }

    @Override
    public void run() {
        animation.tick();
    }
}
