package com.moss.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;

public class Monster extends Character {
	GamePanel pan;
	
	public Monster(GamePanel pan) {
		this.pan = pan;

		// default values
		x = 528; // x position
		y = 96; // y position
		speed = 2; // move with a step of 2
		direction = "left"; // picture's direction
		solidArea = new Rectangle(8, 16, 32, 32);

		getMonsterImage();
	}
	
	public void getMonsterImage() {
		String path = new String();
		File file;
		try {
			path = Main.currentDir + "/images/Monster/up.png";
			file = new File(path);
			up1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/down.png";
			file = new File(path);
			down1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/right.png";
			file = new File(path);
			right1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/left.png";
			file = new File(path);
			left1 = ImageIO.read(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "up":
			image = up1;
			break;
			
		case "down":
			image = down1;
			break;

		case "left":
			image = left1;
			break;

		case "right":
			image = right1;
			break;
		}

		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null);
	}
}
