package projet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanneauJeu extends JPanel implements Runnable {
	// Variables et Constantes
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;

	final int tileSize = originalTileSize * scale;// 48x48 tile
	final int maxScreenCol = 16;
	final int maxScreenLigne = 12;
	final int screenLargeur = tileSize * maxScreenCol; // 768pixels
	final int screenHauteur = tileSize * maxScreenLigne; // 576 pixels
	
	//FPS
	int FPS=60;

	Clavier clavier=new Clavier();
	Thread gameThread;
	
	//positons par defaut du joueur
	int heroX=100;
	int heroY=100;
	int speedHero=4;

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
		if(clavier.upPressed) {
			heroY-=speedHero;
		}
		if(clavier.downPressed) {
			heroY+=speedHero;
		}
		if(clavier.leftPressed) {
			heroX-=speedHero;
		}
		if(clavier.rightPressed) {
			heroX+=speedHero;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fillRect(heroX, heroY, tileSize, tileSize);
		g2.dispose();
	}

	@Override
	public void run() {
		double drawInterval=1000000000/FPS;
		double delta=0;
		long lastTime=System.nanoTime();
		long currentTime;
		while (gameThread != null) {
			
			currentTime=System.nanoTime();
			delta+= (currentTime-lastTime)/drawInterval;
			lastTime=currentTime;
			if(delta>=1) {
				// Update Informations
				update();
				// Draw the screen
				repaint();
				delta--;
			}
		}

	}

}
