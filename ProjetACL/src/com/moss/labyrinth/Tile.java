package com.moss.labyrinth;

public abstract class Tile {

	public int type;
	//0 => Ground
	//1 => Wall
	//2 => Treasure Chest
	
	public abstract void getTileImage (Tile tile);
	//defined in each inherited class 
	
	//method used by Labyrinth/GamePanel to build the labyrinth tile by tile
	public int getType() {
		return type;
	}
	
}
