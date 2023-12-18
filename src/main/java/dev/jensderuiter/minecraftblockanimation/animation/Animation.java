package dev.jensderuiter.minecraftblockanimation.animation;

import java.util.concurrent.CompletableFuture;

public interface Animation {
    CompletableFuture<Void> start();
    boolean isRunning();
    void tick();
    void destroy();

    int getDuration();
}
