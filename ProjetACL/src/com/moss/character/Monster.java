package com.moss.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

public class Monster extends Character {
	GamePanel pan;
	Maze theMaze;

	public Monster(GamePanel pan,Maze theMaze) {
		this.pan = pan;
		this.theMaze = theMaze;

		solidArea = new Rectangle(8, 16, 32, 32);
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		
		impassable=true;
		
		getMonsterImage();
		int[] monsterPosition = setMonsterPosition();
		x = monsterPosition[0];
		y = monsterPosition[1];
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
		
		while ((theMaze.maze[randomR][randomC]==1)||(theMaze.maze[randomR][randomC]==2)||((randomR==1)&&(randomC==1))) {
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
	
	// the update method gets called 60 times per second
	public void update() {
		
		spriteCounter ++;
		
		if (pan.hero.monsterOn == true) {
			attack = true;
		} 
		
		if (spriteCounter > 20) {
			spriteNum++;
			attack = false;
			if (spriteNum == 6) {
				spriteNum = 1;
			}
			spriteCounter = 0;
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