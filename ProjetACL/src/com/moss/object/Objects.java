package com.moss.object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import com.moss.main.GamePanel;

public class Objects {
	
	public BufferedImage image;
	public String name;
	public boolean collision=false;
	public ArrayList<Integer> ListofPosX = new ArrayList<Integer>();
	public ArrayList<Integer> ListofPosY = new ArrayList<Integer>();
	public int x,y;
	public Rectangle solidArea=new Rectangle(0,0,48,48);
	public int solidAreaDefaultX=0;
	public int solidAreaDefaultY=0;
	
	public void draw(Graphics2D g2, GamePanel pan) {
		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize,null);
	}

}
