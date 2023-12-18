package dev.jensderuiter.minecraftblockanimation.animation.stage;

public interface AnimationStage {
    void start();
    void trigger(int tick);
    void destroy();
    int getTotalTicks();
    int getTriggerTick();
}
