# Minecraft Hats
A Minecraft Spigot plugin to add block placement animations to Minecraft.
An example of a block placement animation would be:
the bricks actually being laid when you build a brick block.

This project is a demo of the "framework" I built around these animations,
so this project shouldn't function as an actual plugin for now.

✏️ Feel free to use this project as inspiration for your own projects,
or maybe even use the code as a library.
Be sure to follow the license thought ;).

## Features
An animation (`Animation` interface)
is a process which has a start and a finish.
Construct any animation (only `BricksAnimation` for now)
and run its `start()` method to start the animation.
This method will return a `CompletableFuture<Void>`
which will resolve once the animation is finished.
An animation can also override the `completed()` method
to add a side effect to the end of the animation
(actually placing the block, in the ae of `BricksAnimation`).

Each `Animation` consists of multiple `AnimationStage`'s.
These animation stages are the actual actions
that are being called inside an animation (such as moving an entity).
Each animation stage has a start tick
(the tick from the start of the animation at which it'll trigger)
and a duration of ticks.
The `BaseAnimation` handles triggering the stages at the correct time.

### About the demo
The demo right now does a brick laying animation.
Just place a brick block, and the animation will play.


## Why?
I don't know, really.
It's just a hobby project of mine,
as I was inspired by movie magic ✨.
I think it's a nice project to work on my skills,
and have a little fun :).


## Demo video
![](media/demo.mp4)
