package com.moss.maze;

public class Tile {
	public int x,y;
	private static int type;
	//0 : ground
	//1 : wall
	//2 : treasure chest	

	public Tile() {
		Tile.type = 1;
	}
	
	public Tile(int type) { //constructor with type
		Tile.type = type;
	}
	public Tile(int x, int y, int type) { //constructor with positions and type 
		this.x = x;
		this.y = y;
		Tile.type = type;
	}
	
	public static int getType() {
		return Tile.type;
	}
	
	public static Tile setType(int type) {
		Tile.type = type;
		return null;
	}
	
	public static int getTypeWithPositions(int x, int y) {
		return Tile.type;
	}
	
}
