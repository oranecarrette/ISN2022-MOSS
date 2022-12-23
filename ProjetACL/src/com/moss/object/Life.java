package com.moss.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.character.Hero;
import com.moss.main.GamePanel;
import com.moss.main.Main;

public class Life extends Objects {
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
		for (int blankhearts = pan.hero.initialLives; blankhearts > pan.hero.currentLives ; blankhearts--) {
			g2.drawImage(heartblank, (blankhearts-1)*48, 0, pan.tileSize, pan.tileSize, null);
		}
		for (int fullhearts = 0; fullhearts < pan.hero.currentLives ; fullhearts++) {
			g2.drawImage(heartfull, fullhearts*48, 0, pan.tileSize, pan.tileSize, null);
		}
	}
	
	public void update() {
		
		
	}

}