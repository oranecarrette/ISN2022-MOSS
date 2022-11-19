package com.moss.main;

public class Tile {
	public int x,y;
	private static int type;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		Tile.type = 0;
	}
	public Tile(int x, int y, int type) {
		this.x = x;
		this.y = y;
		Tile.type = type;
	}
	public static int getType(int x, int y) {
		return Tile.type;
	}
	
}
