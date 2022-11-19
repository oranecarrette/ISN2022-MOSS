package com.moss.character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Keyboard;
import com.moss.maze.Tile;

public class Hero extends Character{
	GamePanel pan;
	Keyboard keyboard;
	
	public Hero(GamePanel pan, Keyboard keyboard) {
		this.pan=pan;
		this.keyboard=keyboard; 
		
		//default values
		x = 100; //x position
		y = 100; //y position
		speed = 4; //move with a step of 4
		direction = "down"; //picture's direction		
		
		getPlayerImage();
	}
	
	public void getPlayerImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_0.png")); //picture of the hero when it goes up
			down = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_0.png")); //picture of the hero when it goes down
			right = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_1.png")); //picture of the hero when it goes right
			left = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_0.png")); //picture of the hero when it goes left

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//the origin of the game panel's baseframe is at the top left corner
	public boolean isWall(String direction) {
		boolean wall = true;
		
		switch (direction) {
		case "up": 
			if (Tile.getTypeWithPositions(x-1,y) != 1) { 
				wall = false ;
			}
			break;
		case "down":
			if (Tile.getTypeWithPositions(x+1,y) != 1) {
				wall = false ;
			}			
			break;
		case "left":
			if (Tile.getTypeWithPositions(x,y-1) != 1) {
				wall = false ;
			}			
			break;
		case "right":
			if (Tile.getTypeWithPositions(x,y+1) != 1) {
				wall = false ;
			}				
			break;
		}
		
		return wall;
	}
	
	
	public void update() { //positions update
		if(keyboard.upPressed) { //press on the Z key
			if (isWall("up") == false) { //if the next tile isn't a wall...
				direction = "up";
				y -= speed; //...the hero goes up
			}
		}
		if(keyboard.downPressed) { //press on the S key
			if (isWall("down") == false) {
				direction = "down";
				y += speed; //the hero goes down
			}
		}
		if(keyboard.leftPressed) { //press on the Q key
			if (isWall("left") == false) {
				direction = "left";
				x -= speed; //the hero goes left
			}
		}
		if(keyboard.rightPressed) { //press on the D key
			if (isWall("right") == false) {
				direction = "right";
				x += speed; //the hero goes right
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "up": //when the hero goes up...
			image = up; //...it displays a particular picture, and so on
			break;
		case "down":
			image = down;
			break;
		case "left":
			image = left;
			break;
		case "right":
			image = right;
			break;
		}
		
		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null); 
	}

} 
