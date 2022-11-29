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
			up1 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_0.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_0.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_0.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_0.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_1.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_2.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() { //positions update
		if(keyboard.upPressed || keyboard.downPressed ||
				keyboard.leftPressed||keyboard.rightPressed) {
			if (keyboard.upPressed) {//press on the Z key
				direction = "up";
				y -= speed;//the hero goes up
			}
			if (keyboard.downPressed) { //press on the S key
				direction = "down";
				y += speed;//the hero goes down
			}
			if (keyboard.leftPressed) {//press on the Q key
				direction = "left";
				x -= speed;//the hero goes left
			}
			if (keyboard.rightPressed) {//press on the D key
				direction = "right";
				x += speed;//the hero goes right
			}
			spriteCounter++;
			if(spriteCounter>12) {
				spriteNum++;
				if(spriteNum==5) {
					spriteNum=1;
				}
				spriteCounter=0;
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "up":
			if(spriteNum==1) {
				image = up1;
			}
			if(spriteNum==2) {
				image = up2;
			}
			if(spriteNum==3) {
				image = up3;
			}
			if(spriteNum==4) {
				image = up4;
			}
			break;
		case "down":
			if(spriteNum==1) {
				image = down1;
			}
			if(spriteNum==2) {
				image = down2;
			}
			if(spriteNum==3) {
				image = down3;
			}
			if(spriteNum==4) {
				image = down4;
			}
			break;
		case "left":
			if(spriteNum==1) {
				image = left1;
			}
			if(spriteNum==2) {
				image = left2;
			}
			if(spriteNum==3) {
				image = left3;
			}
			if(spriteNum==4) {
				image = left4;
			}
			break;
		case "right":
			if(spriteNum==1) {
				image = right1;
			}
			if(spriteNum==2) {
				image = right2;
			}
			if(spriteNum==3) {
				image = right3;
			}
			if(spriteNum==4) {
				image = right4;
			}
			break;
		}
		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null); 
	}

} 
