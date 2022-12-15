package com.moss.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import com.moss.object.Key;

public class GameInterface {
	
	GamePanel pan;
	Font arial_20,arial_40, arial_80;
	BufferedImage keyImage;
	public boolean gameWon=false;
	public boolean gameOver=false;
	double Time=0;
	DecimalFormat dFormat=new DecimalFormat("#0.00");
	
	public GameInterface(GamePanel pan) {
		this.pan=pan;
		arial_20=new Font("Arial",Font.PLAIN,20);
		arial_40=new Font("Arial",Font.PLAIN,40);
		arial_80=new Font("Arial",Font.BOLD,80);
		Key key=new Key();
		keyImage=key.image;
	}
	
	public void draw(Graphics2D g2) {
		if (gameWon==true) {
			String text;
			int textLength;
			int x;
			int y;
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			text="You opened the treasure!";
			textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=pan.screenWidth/2-textLength/2;
			y=pan.screenHeight/2;
			g2.drawString(text, x, y);
			
			g2.setFont(arial_40);
			g2.setColor(Color.yellow);
			text="Time is: "+dFormat.format(Time)+'!';
			textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=pan.screenWidth/2-textLength/2;
			y=pan.screenHeight/2+3*pan.tileSize;
			g2.drawString(text, x, y);
			
			
			g2.setFont(arial_80);
			g2.setColor(Color.RED);
			text="Congratulations!";
			textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=pan.screenWidth/2-textLength/2;
			y=pan.screenHeight/2+2*pan.tileSize;
			g2.drawString(text, x, y);
			
			pan.gameThread=null;
			
		}
		else if (gameOver==true){
			String text;
			int textLength;
			int x;
			int y;
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			text="You lost your 3 lives!";
			textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=pan.screenWidth/2-textLength/2;
			y=pan.screenHeight/2;
			g2.drawString(text, x, y);
			
			g2.setFont(arial_40);
			g2.setColor(Color.yellow);
			text="Time is: "+dFormat.format(Time)+'!';
			textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=pan.screenWidth/2-textLength/2;
			y=pan.screenHeight/2+3*pan.tileSize;
			g2.drawString(text, x, y);
			
			
			g2.setFont(arial_80);
			g2.setColor(Color.RED);
			text="Game Over!";
			textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=pan.screenWidth/2-textLength/2;
			y=pan.screenHeight/2+2*pan.tileSize;
			g2.drawString(text, x, y);
			
			pan.gameThread=null;	
		}
		else {
			g2.setFont(arial_20);
			g2.setColor(Color.white);
			g2.drawImage(keyImage, 14*(pan.tileSize), pan.tileSize/4, pan.tileSize/2, pan.tileSize/2,null);
			g2.drawString("x "+pan.hero.hasKey, 14*(pan.tileSize)+pan.tileSize/2+5,30);
			Time+=(double)1/60;
			g2.drawString("Time: "+dFormat.format(Time), (pan.tileSize)*7,pan.tileSize/2);
		}
	}

}
