package com.moss.object;

// USEFUL IMPORTS
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// OTHER CLASSES IMPORTS
import com.moss.main.GamePanel;
import com.moss.main.Main;

//the class Life is a subclass of the Objects class and represents the character's lives

public class Life extends Objects {
	
	// MEMBER VARIABLES
	GamePanel pan;
	public BufferedImage heartfull,heartblank;
	
	// DEFAULT CONSTRUCTOR
	public Life(GamePanel pan) {
		this.pan = pan;		
		
		// DEFAULT VALUES
		// Display
		getLifeImage();
	}
	
	/* Method loading the life images */
	public void getLifeImage() {
		
		String path = new String();
		File file;
		
		try {
			path = Main.currentDir + "/images/Objects/heart_full.png";
			file = new File(path);
			heartfull = ImageIO.read(file);

			path = Main.currentDir + "/images/Objects/heart_blank.png";
			file = new File(path);
			heartblank = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Method called 60 times per second in the GamePanel class, allowing the update of :
	 * - The state of the game, lost when the hero no longer has any of his lives */
	public void update() {
		
		// If the hero no longer has lives...
		if (pan.hero.currentLives == 0) {
			// ...the game is over !
			pan.GI.gameOver = true;
		}
	}
	
	/* Method displaying the character's lives by taking into account 
	 * how many of them are left */
	public void draw(Graphics2D g2) {
		
		for (int blankhearts = pan.hero.initialLives; blankhearts > pan.hero.currentLives ; blankhearts--) {
			g2.drawImage(heartblank, (blankhearts-1)*48, 0, pan.tileSize, pan.tileSize, null);
		}
		
		for (int fullhearts = 0; fullhearts < pan.hero.currentLives ; fullhearts++) {
			g2.drawImage(heartfull, fullhearts*48, 0, pan.tileSize, pan.tileSize, null);
		}
	}

}