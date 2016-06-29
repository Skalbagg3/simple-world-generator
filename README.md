# Simple-world-generator

A simple world generator that combines a Simplex Noise Algorithm (made by Stefan Gustavsson)
and the Slick2D & LWJGL library to draw a 2D tile map. The 32x32 tiles are grouped into 500x500 chunks
and are only rendered while within the screen to save memory.


# Necessary libraries:
1. Slick2D: http://slick.ninjacave.com/
2. LWJGL: https://www.lwjgl.org/

# Setting up build path in eclipse:
1. Add jinput.jar, lwjgl_util.jar, lwjgl.jar and slick.jar
2. Edit lwjgl.jar and set its native library location to: /src/lib/lwjgl/native/[The OS that you're using]
