package com.moss.character;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Keyboard;
import com.moss.maze.Maze; 

public class Hero extends Character{
	GamePanel pan;
	Keyboard keyboard;
	
	public Hero(GamePanel pan, Keyboard keyboard) {
		this.pan=pan;
		this.keyboard=keyboard; 
		
		//default values
		x = 48; //x position
		y = 48; //y position
		speed = 2; //move with a step of 2
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
	
	public void update() { //positions update
		//x and y are the positions of the top left corner of the hero
		int column = (x/pan.tileSize);
		int proutCol = (x%pan.tileSize);
		int row = (y/pan.tileSize);
		int proutRow = (y%pan.tileSize);
		speed = 2;
		
		if(keyboard.upPressed) { //press on the Z key
			direction = "up";
			if ((Maze.isWall(column,row,"up") == true) && (proutRow == 0)) {
				speed = 0; //...the hero goes up
			} else if (((Maze.isWall(column,row,"up") == true) || (Maze.isWall(column+1,row,"up") == true)) && (proutRow==0)) { //if the next tile isn't a wall...
				speed = 0; //...the hero goes up
			} else { y -= speed;
			}
		}
		if(keyboard.downPressed) { //press on the S key
			direction = "down";
			if ((proutCol == 0) && (Maze.isWall(column,row,"down") == false)){ 
				y += speed; //the hero goes down
		    } else if ((Maze.isWall(column,row,"down") == false) && (Maze.isWall(column+1,row,"down") == false)) {
				y += speed; //the hero goes down
			} else { 
				speed = 0;
			}
		}
		if(keyboard.leftPressed) { //press on the Q key
			direction = "left";
			if ((Maze.isWall(column,row,"left") == false) || (proutCol != 0)) {
				x -= speed; //the hero goes left
			} else if ((Maze.isWall(column,row,"left") == false) && (Maze.isWall(column,row+1,"left") == false)) {
				x -= speed; //the hero goes left
			} else { 
				speed = 0;
			}
		}
		if(keyboard.rightPressed) { //press on the D key
			direction = "right";
			if ((proutRow == 0) && (Maze.isWall(column,row,"right") == false)) {
				x += speed; //the hero goes right
			} else if ((Maze.isWall(column,row,"right") == false) && (Maze.isWall(column,row+1,"right") == false)) {
				x += speed; //the hero goes right
			} else { 
				speed = 0;
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
