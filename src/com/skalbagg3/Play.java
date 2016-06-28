package com.skalbagg3;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Keyboard;

public class Play extends BasicGameState {
	
	public static float cameraX, cameraY;
	
	private World world;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{	
		world = new World();
		spawnChunks();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{		
		g.setBackground(Color.black);
			
		//Update camera & tiles
		g.translate(getCameraX(), getCameraY());
		//world.updateTiles();
		world.drawTiles(g);
		//world.drawTilesEast(g);
	
		drawInfoText(g);		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		checkKeyboardInput();
	}
	
	public void spawnChunks()
	{
		
		// Make the world create 4 chunks
		world.chunkList.add(new Chunk(0,0));
		world.chunkList.add(new Chunk(0,-1));
		world.chunkList.add(new Chunk(-1,0));
		world.chunkList.add(new Chunk(-1,-1));
	}
	
	public void checkKeyboardInput()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			//Generate new world
			world.chunkList.clear();
			spawnChunks();
		}
		
		//Move up
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		{	
				setCameraY(getCameraY()+Main.CAMERASPEED);
		}
		//Move down
		else if(Keyboard.isKeyDown(Keyboard.KEY_S))
		{
				setCameraY(getCameraY()-Main.CAMERASPEED);
		}
		//Move left
		else if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{	
				setCameraX(getCameraX()+Main.CAMERASPEED);
		}
		//Move right
		else if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{	
				setCameraX(getCameraX()-Main.CAMERASPEED);	
		}
	}
	
	public void drawInfoText(Graphics g)
	{
		g.setColor(Color.white);
	    
	    g.drawString("X: " +(int) Math.floor(-cameraX), -getCameraX() + 10,-getCameraY() + 30);
	    g.drawString("Y: " +(int) Math.floor(-cameraY), -getCameraX() + 10,-getCameraY() + 50);
	    
	    g.drawString("WASD: Move", -getCameraX() + 10,-getCameraY() + Main.screenHeight -30);
	    g.drawString("Spacebar: new world", -getCameraX() + 10,-getCameraY() + Main.screenHeight -50);
	}
	
	 public void setCameraX(float theX)
	 {
	    cameraX = theX;
	 }
	    
	 public void setCameraY(float theY)
	 {
	    cameraY = theY;
	 }
	    
	 public float getCameraX()
	 {
	    return cameraX;
	 }
	    
	 public float getCameraY()
	 {
	    return cameraY;
	 }

	public int getID() {
		return 0;
	}
}