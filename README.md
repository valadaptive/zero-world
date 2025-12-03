# Zero World

This is a mod that replicates the RNG-less world seen in [Escaping Minecraft's Zero World](https://www.youtube.com/watch?v=5XEMCM8n1XQ).

It's for Minecraft 1.12.1, the version used in the video.

A stable experience is not guaranteed; it turns out a lot of stuff breaks when you change every RNG implementation to
`return 0`. I've patched everything I found that makes the game freeze (usually loops that assume the RNG will
*eventually* return a non-zero value), but I've probably missed some. I'm not an experienced Minecraft modder.

This includes two non-RNG modifications seen in the video: mineshaft carts do not generate (they would cause extreme lag
otherwise), and the "mineshaft crossing" structure is made of diamond ore.
