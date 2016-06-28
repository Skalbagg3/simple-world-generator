package com.skalbagg3;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/*
 * A simple world generator that combines a Simplex Noise Algorithm (made by Stefan Gustavsson)
 * and the Slick2D & LWJGL library to draw a 2D tile map.
 * 
 * 
 * Made by: skalbagg3
 * 
 * 
 * Version 0.1
 * 
 * 
 * TODO: Make the chunks appear more seamless. 
 * TODO: Add chunks dynamically.
 * TODO: Unload chunks when they're not on the screen.
 * 
 */

public class Main extends StateBasedGame{
   
   public static final String gamename = "Simple World Generator";
   public static final int play = 0;
   
   public static final int screenWidth = 1200;
   public static final int screenHeight = 600;
   
   public static final int BLOCKSIZE = 32;
   public static final int CHUNKSIZE = 500;
   public static float CAMERASPEED = 20.0f;
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(play).init(gc, this);
      this.enterState(play);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Main(gamename));
         appgc.setDisplayMode(screenWidth, screenHeight, false);
         appgc.setTargetFrameRate(60);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
   
   public Main(String gamename) throws SlickException{
	      super(gamename);
	      this.addState(new Play());
	   }
}