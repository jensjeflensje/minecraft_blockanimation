package dev.jensderuiter.minecraftblockanimation.animation.stage;

import lombok.Getter;

@Getter
public abstract class BaseVariableTriggerTickAnimationStage extends BaseAnimationStage {

    private final int triggerTick;

    public BaseVariableTriggerTickAnimationStage(int triggerTick) {
        this.triggerTick = triggerTick;
    }

}
