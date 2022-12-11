package com.moss.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.character.Hero;
import com.moss.character.Monster;

public class Life {
	GamePanel pan;
	
	public int life;
	public BufferedImage heart;
	
	public Life(GamePanel pan) {
		
		this.pan = pan;
		
		life = 3;
		
		getLifeImage();
	}
	
	public void getLifeImage() {
		
		String path = new String();
		File file;
		
		try {
			path = Main.currentDir + "/images/Hero/life/heart.png";
			file = new File(path);
			heart = ImageIO.read(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		for (int hearts = 0; hearts < life ; hearts++) {
			g2.drawImage(heart, hearts*48, 0, pan.tileSize, pan.tileSize, null);
		}
	}
	
	public void update () {
		
		
	}

}
