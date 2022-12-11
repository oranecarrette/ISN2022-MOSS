package com.moss.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Keyboard;
import com.moss.main.Main;

public class Hero extends Character {
	GamePanel pan;
	Keyboard keyboard;

	public Hero(GamePanel pan, Keyboard keyboard) {
		this.pan = pan;
		this.keyboard = keyboard;

		// default values
		x = 48; // x position
		y = 40; // y position
		speed = 2; // move with a step of 2
		direction = "down"; // picture's direction
		solidArea = new Rectangle(8, 16, 32, 32);
		
		getPlayerImage();
	}

	public void getPlayerImage() {
		String path = new String();
		File file;
		try {
			path = Main.currentDir + "/images/Hero/up/up_0.png";
			file = new File(path);
			up1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/down/down_0.png";
			file = new File(path);
			down1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/right/right_0.png";
			file = new File(path);
			right1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/left/left_0.png";
			file = new File(path);
			left1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/up/up_1.png";
			file = new File(path);
			up2 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/down/down_1.png";
			file = new File(path);
			down2 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/right/right_1.png";
			file = new File(path);
			right2 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/left/left_1.png";
			file = new File(path);
			left2 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/up/up_2.png";
			file = new File(path);
			up3 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/down/down_2.png";
			file = new File(path);
			down3 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/right/right_2.png";
			file = new File(path);
			right3 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/left/left_2.png";
			file = new File(path);
			left3 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/up/up_3.png";
			file = new File(path);
			up4 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/down/down_3.png";
			file = new File(path);
			down4 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/right/right_3.png";
			file = new File(path);
			right4 = ImageIO.read(file);
			path = Main.currentDir + "/images/Hero/left/left_3.png";
			file = new File(path);
			left4 = ImageIO.read(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (keyboard.upPressed || keyboard.downPressed || keyboard.leftPressed || keyboard.rightPressed) {
			if (keyboard.upPressed) {
				direction = "up";
			}
			if (keyboard.downPressed) {
				direction = "down";
			}
			if (keyboard.leftPressed) {
				direction = "left";
			}
			if (keyboard.rightPressed) {
				direction = "right";
			}
			collisionOn = false;
			pan.collision.checkTile(this);
			if (collisionOn == false) {
				switch (direction) {
				case "up":
					y -= speed;
					break;
				case "down":
					y += speed;
					break;
				case "left":
					x -= speed;
					break;
				case "right":
					x += speed;
					break;
				}
			}

			spriteCounter++;
			if (spriteCounter > 12) {
				spriteNum++;
				if (spriteNum == 5) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}

	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			if (spriteNum == 3) {
				image = up3;
			}
			if (spriteNum == 4) {
				image = up4;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			if (spriteNum == 3) {
				image = down3;
			}
			if (spriteNum == 4) {
				image = down4;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			if (spriteNum == 3) {
				image = left3;
			}
			if (spriteNum == 4) {
				image = left4;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			if (spriteNum == 3) {
				image = right3;
			}
			if (spriteNum == 4) {
				image = right4;
			}
			break;
		}

		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null);
		
	}

}
