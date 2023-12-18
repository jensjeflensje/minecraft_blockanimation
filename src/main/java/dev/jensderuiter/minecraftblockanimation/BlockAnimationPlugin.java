package dev.jensderuiter.minecraftblockanimation;

import dev.jensderuiter.minecraftblockanimation.animation.BaseAnimation;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockAnimationPlugin extends JavaPlugin {

    @Getter
    private static BlockAnimationPlugin instance;

    @Override
    public void onEnable() {
        this.instance = this;

        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
