package com.moss.character;

// USEFUL IMPORTS 
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// the class Character is the parent class of the Hero and Monster classes, who share similar characteristics

public class Character {
	
	// MOTION 
	public int x,y; // positions
	public int speed; // distance covered in one leap
	public String direction; // motion direction
	public int directionCounter = 0;
	
	// COLLISION WITH THE ENVIRONNEMENT AND OTHER CHARACTERS
	public Rectangle solidArea;
	public int solidAreaDefaultX,solidAreaDefaultY;
	public boolean collisionOn = false; // boolean turning true when a character goes towards a tile that cannot be passed through
	public boolean holeOn = false; // boolean turning true when the hero is on a hole
	public boolean monsterOn = false; // boolean turning true when the hero runs into the monster, or when the monster runs into the hero
	public boolean impassable = false; // boolean turning true when a character cannot be passed through

	// LIVES
	public int initialLives; // number of lives at the beginning of the game
	public int currentLives; // number of lives during the game
	
	// DISPLAY 
	public BufferedImage up1,up2,up3,up4, 
	 					 down1,down2,down3,down4, 
	 					 right1,right2,right3,right4, 
	 					 left1,left2,left3,left4,
	 					 
	 					 monster_center,monster_left,monster_right1,monster_right2,
						 attack_center,attack_left,attack_right1,attack_right2;
	public int spriteCounter = 0; 
	public int spriteNum = 1; 
	public boolean attack = false; // boolean turning true when the hero runs into a monster
}
