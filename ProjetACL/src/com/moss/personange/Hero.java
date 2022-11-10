package com.moss.personange;

import java.awt.Color;
import java.awt.Graphics2D;

import com.moss.main.Clavier;
import com.moss.main.PanneauJeu;

public class Hero extends Personnage{
	PanneauJeu pan;
	Clavier clavier;
	
	public Hero(PanneauJeu pan, Clavier clavier) {
		this.pan=pan;
		this.clavier=clavier;
		setDefaultValue();
	}
	
	public void setDefaultValue() {
		x=100;
		y=100;
		speed=4;
	}
	
	public void update() {
		if(clavier.upPressed) {
			y-=speed;
		}
		if(clavier.downPressed) {
			y+=speed;
		}
		if(clavier.leftPressed) {
			x-=speed;
		}
		if(clavier.rightPressed) {
			x+=speed;
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(x,y, pan.tileSize, pan.tileSize);
	}

	/*public Hero() { //constructeur par defaut
		this.posX=0;
		this.posY=0;
	}
	
	public Hero(int posX,int posY) { //constructeur avec attributs renseignes
		this.posX=posX;
		this.posY=posY;					
	}
	
	public String toString() {
		return "posx= "+posX+"\tposY= "+posY; //\t = tabulations 
	}
	
	public void moveUp() {
		posY--;
	}
	
	public void moveDown() {
		posY++;
	}
	
	public void moveRight() {
		posX++;
	}
	
	public void moveLeft() {
		posX--;
	}
	*/
	
}
