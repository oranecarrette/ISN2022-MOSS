package com.moss.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.character.Hero;
import com.moss.main.GamePanel;
import com.moss.main.Main;

public class Life extends AllObject {
	GamePanel pan;
	
	public BufferedImage heartfull,heartblank;
	
	public Life(GamePanel pan) {
		
		this.pan = pan;		
		getLifeImage();
	}
	
	public void getLifeImage() {
		
		String path = new String();
		File file;
		
		try {
			path = Main.currentDir + "/images/Hero/life/heart_full.png";
			file = new File(path);
			heartfull = ImageIO.read(file);

			path = Main.currentDir + "/images/Hero/life/heart_blank.png";
			file = new File(path);
			heartblank = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		for (int hearts = 0; hearts < pan.hero.currentLives ; hearts++) {
			g2.drawImage(heartfull, hearts*48, 0, pan.tileSize, pan.tileSize, null);
		}
	}
	
	public void update() {
		
		
	}

}