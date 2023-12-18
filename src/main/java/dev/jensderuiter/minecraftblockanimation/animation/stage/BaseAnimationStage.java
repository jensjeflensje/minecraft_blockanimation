package dev.jensderuiter.minecraftblockanimation.animation.stage;

import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAnimationStage implements AnimationStage {

    protected List<Entity> entities;

    public BaseAnimationStage() {
        this.entities = new ArrayList<>();
    }

    @Override
    public void start() {
        // doesn't do anything by default
        // can be overwritten
    }

    @Override
    public void destroy() {
        this.entities.forEach(Entity::remove);
    }
}
