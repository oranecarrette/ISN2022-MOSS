package com.moss.character;

// USEFUL IMPORTS
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

// OTHER CLASSES IMPORTS
import com.moss.main.GamePanel;
import com.moss.main.Main;

// the class Monster is a subclass of the Character class and contains everything related to the monster (obviously)

public class Monster extends Character {
	
	// MEMBER VARIABLES
	GamePanel pan;

	// DEFAULT CONSTRUCTOR
	public Monster(GamePanel pan) {
		this.pan = pan;

		// DEFAULT VALUES
		// Motion 
		int[] monsterPosition = setMonsterPosition(); // random initial position generated at each game
		x = monsterPosition[0]; // abscissa | column
		y = monsterPosition[1]; // ordinate | row
		speed = 1; // one leap equals a 1-pixel-movement
		direction = "down";
		// Collision with the environment and other characters
		solidArea = new Rectangle(8, 16, 32, 32);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		impassable = true;
		// Display		
		getMonsterImage();
	}
	
	// METHODS
	/* Method loading the different images of the monster */
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
	
	/* Method setting randomly the initial position of the monster 
	 * - The monster can only appear on grass
	 * - The monster cannot appear on the initial positions of the hero, the key and the treasure */
	public int[] setMonsterPosition() {
		
		// Initialization of the random position
		int randomR = 0;
		int randomC = 0;
		// Get of the treasure and key positions
		int[] treasurePosition = pan.treasureC.getCloseTreasurePosition();
		int treasureCol = treasurePosition[0];
		int treasureRow = treasurePosition[1];
		int[] keyPosition = pan.key.getKeyPosition();
		int keyCol = keyPosition[0];
		int keyRow = keyPosition[1];
		
		// While the random position matches the positions of impassable tiles, key or treasure,
		// it keeps generating random position
		while ((pan.maze.maze[randomR][randomC] == 1)
				||(pan.maze.maze[randomR][randomC] == 2)
				||((randomR == 1)&&(randomC == 1))
				||((randomR == treasureRow)&&(randomC == treasureCol))
				||((randomR == keyRow)&&(randomC == keyCol))){
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

	/* Method returning the position of the monster */
	public int[] getMonsterPosition() {
	    int[] position = {x, y};
		return position;
	}

	/* Method setting randomly the direction of the monster's movement */
	public void setMonsterDirection() {
		
		directionCounter++;
		
		// Every 2 seconds... 
		if (directionCounter == 120) {
			
			// ...a new random direction is picked up
			Random rD = new Random();
			int randomD = rD.nextInt(40)+1;
			
			if (randomD <= 10) {
				direction = "up";
			}
			else if (randomD > 10 && randomD <= 20) {
				direction = "down";
			}
			else if (randomD > 20 && randomD <= 30) {
				direction = "left";
			}
			else if (randomD > 30 && randomD <= 40) {
				direction = "right";
			}
			
			directionCounter = 0;	
		}
	}
	
	/* Method called 60 times per second in the GamePanel class, allowing the update of :
	 * - The monster's positions according to the environment and the actions of the player on the keyboard
	 * - The hero's lives depending on the interactions with the monster
	 * - The monster's display depending on the time / if he's attacking or not
	 * */
	public void update() { 
				
		// UPDATE OF THE MONSTER'S POSITIONS
		// Setting a random possible direction 
		setMonsterDirection(); 
		collisionOn = false;
		monsterOn = false;
		pan.collision.checkTile(this); // method changing the value of the boolean collisionOn
		pan.collision.checkHero(pan.hero); // method changing the value of the boolean collisionOn
		
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
		// If the monster encounters the hero...
		if (pan.monster.monsterOn == true) {
			
			// ...the hero loses 1 life
			pan.hero.currentLives -= 1;
			// ...the monster steps back in the direction he was coming from,
			// with a leap of half a tile size
			
			switch (pan.monster.direction) {
			
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
		
		// UPDATE OF THE MONSTER'S DISPLAY
		/* The monster can be displayed in 4 ways considering that he is a flame moving.
		 * There are 4 images for each profile, that can be also declined in red, showing that the monster is attacking. 
		 *  */
		spriteCounter ++;
		if (spriteCounter > 20) {
			spriteNum++;
			attack = false;
			if (spriteNum == 6) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		// If the monster encounters the hero..
		if ((pan.hero.monsterOn == true)||(pan.monster.monsterOn == true)) {
			// ... the monster attacks, so it turns red!
			attack = true;
		} 
	}
	
	/* Method displaying the monster by taking into account 
	 * his state (attacking or not) and the passing time */
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