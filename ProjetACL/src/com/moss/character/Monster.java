package com.moss.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;

public class Monster extends Character {
	GamePanel pan;

	public Monster(GamePanel pan) {
		this.pan = pan;

		solidArea = new Rectangle(8, 16, 32, 32);
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		speed = 1;
		direction = "down";
		impassable=true;
				
		getMonsterImage();
		int[] monsterPosition = setMonsterPosition();
		x = monsterPosition[0]; //column
		y = monsterPosition[1]; //row
	}
	
	public void getMonsterImage() {
		String path = new String();
		File file;
		try {
			path = Main.currentDir + "/images/Monster/monster_center.png";
			file = new File(path);
			monster_center = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/monster_left.png";
			file = new File(path);
			monster_left = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/monster_right1.png";
			file = new File(path);
			monster_right1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/monster_right2.png";
			file = new File(path);
			monster_right2 = ImageIO.read(file);
			
			path = Main.currentDir + "/images/Monster/attack_center.png";
			file = new File(path);
			attack_center = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/attack_left.png";
			file = new File(path);
			attack_left = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/attack_right1.png";
			file = new File(path);
			attack_right1 = ImageIO.read(file);
			path = Main.currentDir + "/images/Monster/attack_right2.png";
			file = new File(path);
			attack_right2 = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] setMonsterPosition() {
		int randomR = 0;
		int randomC = 0;
		
		while ((pan.maze.maze[randomR][randomC]==1)||(pan.maze.maze[randomR][randomC]==2)||((randomR==1)&&(randomC==1))) {
			Random rR = new Random();
			Random rC = new Random();
			randomR = rR.nextInt(pan.maxScreenRow);
			randomC = rC.nextInt(pan.maxScreenCol);
		}
		
		int x = randomC*pan.tileSize;
		int y = randomR*pan.tileSize;
	    int[] position = {x, y};
	    
	    return position;
	}

	public int[] getMonsterPosition() {
	    int[] position = {x, y};
		return position;
	}

	public void getMonsterDirection() {
		
		directionCounter++;
		System.out.println(directionCounter);
		
		if (directionCounter == 120) {
		
			Random rD = new Random();
			int randomD = rD.nextInt(120)+1;
			
			if (randomD <=30) {
				direction = "up";
			}
			else if (randomD > 30 && randomD <= 60) {
				direction = "down";
			}
			else if (randomD > 60 && randomD <= 90) {
				direction = "left";
			}
			else if (randomD > 90 && randomD <= 120) {
				direction = "right";
			}
			
			directionCounter = 0;
			
		}
	}
	
	// the update method gets called 60 times per second
	public void update() { 
		
		spriteCounter ++;
		if (spriteCounter > 20) {
			spriteNum++;
			attack = false;
			if (spriteNum == 6) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		getMonsterDirection(); 
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
		
		if (pan.hero.monsterOn == true) {
			attack = true;
		} 
	
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch (spriteNum) {
		case 1:
			if (attack == true) {
				image = attack_center;
			} else { 
				image = monster_center;
			}
			break;
		case 2:
			if (attack == true) {
				image = attack_right1;
			} else {  
				image = monster_right1;
			}
			break;
		case 3:
			if (attack == true) {
				image = attack_right2;
			} else { 
				image = monster_right2;
			}
			break;
		case 4:
			if (attack == true) {
				image = attack_center;
			} else { 
				image = monster_center;
			}
			break;
		case 5:
			if (attack == true) {
				image = attack_left;
			} else { 
				image = monster_left;
			}
			break;
		}
		
		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null);
	}
}