package com.moss.main;

public class Tile {
	private int type;
	//0 => sol
	//1 => mur
	
	public Tile() {
		this.type=0;
	}
	public Tile(int type) {
		this.type=type;
	}
	public int getType() {
		return type;
	}
	
}
