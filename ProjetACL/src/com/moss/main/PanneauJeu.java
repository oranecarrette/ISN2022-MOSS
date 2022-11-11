package com.moss.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.moss.personange.Hero;

public class PanneauJeu extends JPanel implements Runnable {
	// Variables et Constantes
	final int originalTileSize = 16;
	final int scale = 3;

	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenLigne = 12;
	final int screenLargeur = tileSize * maxScreenCol;
	final int screenHauteur = tileSize * maxScreenLigne;

	// FPS
	int FPS = 60;

	Clavier clavier = new Clavier();
	Thread gameThread;
	Hero hero = new Hero(this, clavier);

	// positons par defaut du joueur
	int heroX = 100;
	int heroY = 100;
	int speedHero = 4;

	public PanneauJeu() {
		this.setPreferredSize(new Dimension(screenLargeur, screenHauteur));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(clavier);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void update() {
		hero.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		hero.draw(g2);
		g2.dispose();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		while (gameThread != null) {

			currentTime = System.nanoTime();
			timer += (currentTime - lastTime);
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if (delta >= 1) {
				// Update Informations
				update();
				// Draw the screen
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}

	}

}
