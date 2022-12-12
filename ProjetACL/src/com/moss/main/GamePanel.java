package com.moss.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.moss.character.Hero;
import com.moss.maze.Maze;
import com.moss.object.AllObject;

public class GamePanel extends JPanel implements Runnable {

	// variables and constants
	final int originalTileSize = 16; // 16x16 pixels per tile
	final int scale = 3;

	public final int tileSize = originalTileSize * scale; // 48x48 pixels per tile, in order to make it visible with a
															// screen resolution of 1080x720 pixels
	public final int maxScreenCol = 16; // 16 columns
	public final int maxScreenRow = 12; // 12 rows
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels

	// FPS
	int FPS = 60;

	Keyboard keyboard = new Keyboard(); // new instance of the Keyboard Class
	Thread gameThread;
	public Collision collision=new Collision(this);
	public AssetSetter setter=new AssetSetter(this);
	public GameInterface GI =new GameInterface(this);
	Maze maze = new Maze(this);
	Hero hero = new Hero(this, keyboard); // new instance of the Hero Class
	public AllObject obj[]=new AllObject[10];

	public GamePanel() { // GamePanel's constructor
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // panel's dimensions
		this.setBackground(Color.black); // background color
		this.setDoubleBuffered(true); // optimisation of the window's rendering
		this.addKeyListener(keyboard);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		setter.setObject();
	}

	public void startGameThread() {
		gameThread = new Thread(this); // new instance of the Thread Class
		gameThread.start(); // thread's launch
	}

	public void update() {
		hero.update(); // hero's positions update
	}

	public void paintComponent(Graphics g) { // draw on the GamePanel
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // transtypage to a class of better performances
		maze.draw(g2);
		for(int i=0;i<obj.length;i++) {
			if(obj[i]!=null) {
				obj[i].draw(g2, this);
			}
		}
		hero.draw(g2); // draw the hero on the GamePanel
		GI.draw(g2);
		g2.dispose();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS; // 1000000000 nanoseconds -> 60 pictures per second
		double delta = 0;
		long lastTime = System.nanoTime(); // time at that moment t-1
		long currentTime; // time at that moment
		long timer = 0;
		int drawCount = 0;
		while (gameThread != null) {

			currentTime = System.nanoTime();
			timer += (currentTime - lastTime); // execution time
			delta += (currentTime - lastTime) / drawInterval; // time difference
			lastTime = currentTime;
			if (delta >= 1) { // for each 1/60 second
				update(); // positions' update
				repaint(); // draw of the characters on the GamePanel
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) { // time >= 1 second
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}

	}

}
