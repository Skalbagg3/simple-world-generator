package com.skalbagg3;

/* Generates a collection of tiles */

public class Chunk {
	
	public int xPos, yPos;
	public int[][] tiles;
	
	private SimplexNoise simplexNoise=new SimplexNoise(100,1.0,6000);
	
	private double xStart = 0,
		   XEnd =1000,
    	   yStart = 0,
    	   yEnd = 1000;

    private int xResolution = Main.CHUNKSIZE,
    	yResolution = Main.CHUNKSIZE;
    
    private double[][] result;
   
	
	public Chunk(int x, int y) 
	{
		this.xPos = x*(Main.BLOCKSIZE*Main.CHUNKSIZE);
		this.yPos = y*(Main.BLOCKSIZE*Main.CHUNKSIZE);

		generate();
	}
	
	public void generate()
	{
		
		//Generate noise
		simplexNoise=new SimplexNoise(100,0.1, (int) (Math.random()*5000));

		tiles = new int[xResolution][yResolution];
		result=new double[xResolution][yResolution];
		
		//Fill array with noise
	    for(int i=0;i<xResolution;i++){
	        for(int j=0;j<yResolution;j++){
	            int x=(int)(xStart+i*((XEnd-xStart)/xResolution));
	            int y=(int)(yStart+j*((yEnd-yStart)/yResolution));
	            result[i][j]=0.5*(1+simplexNoise.getNoise(x,y));
	        }
	    }
		
	    
	    //Check the value of each index in the noise array
		for(int i=0;i<xResolution;i++){
	        for(int j=0;j<yResolution;j++){
	        	
	        	//Generate grass
	        	if(result[i][j] > 0.495 && result[i][j] < 0.52)
	        	{ 
	        		tiles[i][j] = 1;
	        	} 
	        	
	        	//Generate water
	        	else if(result[i][j] < 0.49)
	        	{ 
	        		tiles[i][j] = 2;
	        	} 
	        	
	        	//Generate beaches right next to the water
	        	else if(result[i][j] > 0.49 && result[i][j] < 0.495)
	        	{
	        		tiles[i][j] = 3;
	        	}
	        	
	        	//Generate mountains
	        	else if(result[i][j] > 0.52)
	        	{
	        		tiles[i][j] = 4;
	        	}
	    
	        	else
	        	{ 
	        		tiles[i][j] = 1;
	        	}
	        }
		}
	}
	
	public int getTile(int x,int y){
    	return tiles[x][y];
    }
}
