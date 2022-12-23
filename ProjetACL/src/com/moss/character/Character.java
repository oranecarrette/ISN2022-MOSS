package com.moss.character;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Character {
	public int x,y;
	public int speed;
	
	public BufferedImage up1,up2,up3,up4, down1,down2,down3,down4, right1,right2,right3,right4, left1,left2,left3,left4, monster_center,monster_left,monster_right1,monster_right2,attack_center,attack_left,attack_right1,attack_right2;
	public String direction;
	public int spriteCounter=0;
	public int spriteNum=1;
	public int directionCounter=0;
	public boolean attack = false;
	
	public Rectangle solidArea;
	public int solidAreaDefaultX,solidAreaDefaultY;
	public boolean collisionOn=false;
	public boolean holeOn=false;
	public boolean monsterOn=false;
	public boolean impassable=false;

	public int initialLives;
	public int currentLives;
}
