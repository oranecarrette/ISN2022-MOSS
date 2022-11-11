package com.moss.personange;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.Clavier;
import com.moss.main.PanneauJeu;

public class Hero extends Personnage {
	PanneauJeu pan;
	Clavier clavier;

	public Hero(PanneauJeu pan, Clavier clavier) {
		this.pan = pan;
		this.clavier = clavier;
		setDefaultValue();
		getPlayerImage();
	}

	public void setDefaultValue() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_0.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_0.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_1.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_0.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (clavier.upPressed) {
			direction = "up";
			y -= speed;
		}
		if (clavier.downPressed) {
			direction = "down";
			y += speed;
		}
		if (clavier.leftPressed) {
			direction = "left";
			x -= speed;
		}
		if (clavier.rightPressed) {
			direction = "right";
			x += speed;
		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "up":
			image = up;
			break;
		case "down":
			image = down;
			break;
		case "left":
			image = left;
			break;
		case "right":
			image = right;
			break;
		}
		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null);
		
	}


}
