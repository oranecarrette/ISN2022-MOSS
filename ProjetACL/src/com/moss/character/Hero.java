package com.moss.character;

// USEFUL IMPORTS 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// OTHER CLASSES IMPORTS
import com.moss.main.GamePanel;
import com.moss.main.Keyboard;
import com.moss.main.Main;
import com.moss.object.TreasureOpen;

// the class Hero is a subclass of the Character class and contains everything related to the player

public class Hero extends Character {
	
	// MEMBER VARIABLES
	GamePanel pan;
	Keyboard keyboard;
	
	// INTERACTIONS WITH THE TREASURE KEY
	public int hasKey=0;
	
	// DEFAULT CONSTRUCTOR
	public Hero(GamePanel pan, Keyboard keyboard) {
		this.pan = pan;
		this.keyboard = keyboard;

		// DEFAULT VALUES
		// Motion 
		x = 48; // abscissa | column
		y = 40; // ordinate | row
		speed = 2; // one leap equals a 2-pixel-movement
		direction = "down";
		// Collision with the environment and other characters
		solidArea = new Rectangle(8, 16, 32, 32);
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		// Lives
		initialLives = 3;
		currentLives = initialLives;
		// Display
		getHeroImage();
	}

	// METHODS
	/* Method loading the different images of the hero */
	public void getHeroImage() {
		
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
	
	/* Method that:
	 * NB: each object in the map is contained on a buffer 
	 * - increment hasKey and delete Key object from obj buffer if the object is a key*
	 * - decrement hasKey and replace an Opened treasure with a closed treasure if the object is a close treasure
	 * - stop the game if the object is an opened treasure
	 * - increment lives and delete the life object from the buffer if the object is a potion
	 * - increase speed by increasing speed variable if the object is a speedUp potion 
	 * - play sound with each object  
	 *  */
	public void pickUpObject(int i) {
		
		if(i!=-1) {
			
			String objectName=pan.obj[i].name;
			
			switch(objectName) {
			
			case "Key":
				pan.playSE(4);
				hasKey++;
				pan.obj[i]=null;
				System.out.println("key: "+hasKey);
				break;
				
			case "Treasure close":
				if(hasKey>0) {
					TreasureOpen treasureO = new TreasureOpen(pan);
					treasureO.setOpenTreasurePosition();
					hasKey--;
				}
				System.out.println("key: "+hasKey);
				break;
				
			case "Treasure open":
				pan.stopMusic();
				pan.playMusic(2);
				pan.GI.gameWon=true;
				break;
				
			case "Potion":
				pan.playSE(1);
				pan.obj[i]=null;
				currentLives++;
				break;
				
			case "SpeedUp":
				pan.playSE(3);;
				pan.obj[i]=null;
				speed+=1;
				break;
			}
			
		}
	}
	
	/* Method called 60 times per second in the GamePanel class, allowing the update of :
	 * - The hero's positions according to the environment and the actions of the player on the keyboard
	 * - The hero's lives depending on the interactions with the environment and the other characters
	 * - The hero's display depending on the direction of his movement 
	 * */
	public void update() {
		
		// UPDATE OF THE HERO'S POSITIONS
		// Keyboard entry
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
			
			// Consideration of the environment (characters, tiles, objects)
			collisionOn = false;
			holeOn = false;
			monsterOn = false;
			pan.collision.checkTile(this); // method changing the values of the booleans collisionOn & holeOn
			pan.collision.checkMonster(this); // method changing the values of the booleans collisionOn & monsterOn
			int objectIndex = pan.collision.checkObject(this, true);
			pickUpObject(objectIndex);
			
			// If the next tile can be passed through...  
			if (collisionOn == false) {
				
				switch (direction) {
				// ...the hero can move
				
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
			
			// UPDATE OF THE HERO'S LIVES
			// If the next tile is a hole... 
			if (pan.hero.holeOn == true) {
				// ...the hero loses all of his lives
				currentLives = 0;
			}
			
			// If the hero encounters the monster...
			if (pan.hero.monsterOn == true) {
				
				// ...the hero loses 1 life
				pan.hero.currentLives -= 1;
				// ...the monster steps back in the direction he was coming from,
				// with a leap of half a tile size
				
				switch (pan.hero.direction) {
				
				case "up":
					y += 0.5*pan.tileSize;
					break;
					
				case "down":
					y -= 0.5*pan.tileSize;
					break;
					
				case "left":
					x += 0.5*pan.tileSize;
					break;
					
				case "right":
					x -= 0.5*pan.tileSize;
					break;
				}
			}

			// UPDATE OF THE HERO'S DISPLAY
			/* The hero can be displayed in 12 ways considering his movement direction (up, down, left, right).
			 * There are 4 images for each direction, to give the illusion that the hero is walking with his arms balancing. 
			 *  */
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
	
	/* Method displaying the hero by taking into account the direction of this movement */
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