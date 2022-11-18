package com.moss.labyrinth;

import java.awt.image.BufferedImage;

public class Tile {
	
	private int type;
	//0 => Ground
	//1 => Wall
	//2 => Treasure Chest
	
	public Tile() {
		this.type = 0;
	}
	
	public Tile(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public void getTileImage () {
		
		BufferedImage image = null;
		
		switch (type) {
		
		case 0:
			//image = 
			break;
		
		case 1:
			//image = 
			break;
		
		case 2:
			//image = 
			break;
		}
		
	}
	
}
