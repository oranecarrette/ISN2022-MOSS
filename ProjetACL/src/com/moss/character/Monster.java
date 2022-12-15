package com.moss.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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
			path = Main.currentDir + "/images/Monster/monster.png";
			file = new File(path);
			monster = ImageIO.read(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] setMonsterPosition() {
		int randomR = 0;
		int randomC = 0;
		
		while ((theMaze.maze[randomR][randomC]==1)||(theMaze.maze[randomR][randomC]==2)||((randomR==0)&&(randomC==0))) {
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
	
	public void update() {
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = monster;
		
		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null);
	}
}