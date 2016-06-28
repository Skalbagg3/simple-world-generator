package com.skalbagg3;

import java.util.ArrayList;

import org.newdawn.slick.*;

public class World {
	
	private SpriteSheet tileSheet;
	
	private Image grass, sand, water, rock;
	
	public ArrayList<Chunk> chunkList;
	
	public World() {
		
		//Load spritesheet
		try {
			tileSheet = new SpriteSheet("res/spritesheet.png", Main.BLOCKSIZE,Main.BLOCKSIZE);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		water = tileSheet.getSprite(0, 0);
		grass = tileSheet.getSprite(1, 0);
		sand  = tileSheet.getSprite(2, 0);
		rock  = tileSheet.getSprite(3, 0);
		
		chunkList = new ArrayList<Chunk>();
	}
	
	public void drawTiles(Graphics g){
		
		
		/*Loop through the tiles contained in each chunk and check their position.
		  if they're within the same area as the camera; draw them onto the screen. */
		
		for(int k = 0; k <chunkList.size(); k++){
			
			int chunkXPos = chunkList.get(k).xPos;
			int chunkYPos = chunkList.get(k).yPos;
				
			for(int i=0;i<Main.CHUNKSIZE;i++){
		        for(int j=0;j<Main.CHUNKSIZE;j++){
		        	if(chunkXPos + (i*Main.BLOCKSIZE) > -100 - Play.cameraX && chunkXPos + (i*Main.BLOCKSIZE) < Main.screenWidth + 50 - Play.cameraX &&
		        	   chunkYPos + (j*Main.BLOCKSIZE) > -100 - Play.cameraY && chunkYPos+ (j*Main.BLOCKSIZE) < Main.screenHeight - Play.cameraY)
		        	{  
			        	switch(chunkList.get(k).tiles[i][j]){
				        	case 1:
				        		g.drawImage(grass, chunkXPos + i*Main.BLOCKSIZE, chunkYPos + j*Main.BLOCKSIZE);
				        	break;
				        	case 2:
				        		g.drawImage(water, chunkXPos + i*Main.BLOCKSIZE, chunkYPos + j*Main.BLOCKSIZE);
				        	break;
				        	case 3:
				        		g.drawImage(sand, chunkXPos + i*Main.BLOCKSIZE, chunkYPos + j*Main.BLOCKSIZE);
				        	break;
				        	case 4:
				        		g.drawImage(rock, chunkXPos + i*Main.BLOCKSIZE, chunkYPos + j*Main.BLOCKSIZE);
				        	break;
				        	default:
				        		g.drawImage(grass, chunkXPos + i*Main.BLOCKSIZE, chunkYPos + j*Main.BLOCKSIZE);
				        	break;
			        	}
		        	}
		        } 
		    }
		}
	}
}
