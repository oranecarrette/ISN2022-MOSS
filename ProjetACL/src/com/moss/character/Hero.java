package com.moss.character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Keyboard;

public class Hero extends Character{
	GamePanel pan;
	Keyboard keyboard;
	
	public Hero(GamePanel pan, Keyboard keyboard) {
		this.pan=pan;
		this.keyboard=keyboard; 
		setDefaultValue();
		getPlayerImage();
	}
	
	public void setDefaultValue() { //default values
		x = 100; //x position
		y = 100; //y position
		speed = 4; //move with a step of 4
		direction = "down"; //picture's direction
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
		if(keyboard.upPressed) { //press on the Z key
			direction = "up";
			y -= speed; //the hero goes up
		}
		if(keyboard.downPressed) { //press on the S key
			direction = "down";
			y += speed; //the hero goes down
		}
		if(keyboard.leftPressed) { //press on the Q key
			direction = "left";
			x -= speed; //the hero goes left
		}
		if(keyboard.rightPressed) { //press on the D key
			direction = "right";
			x += speed; //the hero goes right
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
