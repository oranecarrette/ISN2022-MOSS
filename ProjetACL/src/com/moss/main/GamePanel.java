package com.moss.main;

// USEFUL IMPORTS
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

// OTHER CLASSES IMPORTS
import com.moss.character.Hero;
import com.moss.character.Monster;
import com.moss.maze.Maze;
import com.moss.object.*;

// the class GamePanel is where the whole game takes place... :)

public class GamePanel extends JPanel implements Runnable {

	// MEMBERS VARIABLES
	// Game display
	final int originalTileSize = 16; // 16x16 pixels per tile
	final int scale = 3;
	public final int tileSize = originalTileSize * scale; // 48x48 pixels per tile, in order to make it visible with a
														  // screen resolution of 1080x720 pixels
	public final int maxScreenCol = 16; // 16 columns
	public final int maxScreenRow = 12; // 12 rows
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	int FPS = 60; // frames par second
	// New instances of useful classes 
	public GameInterface GI = new GameInterface(this);
	public Keyboard keyboard = new Keyboard();
	public Thread gameThread;
	public Collision collision = new Collision(this);
	public Maze maze = new Maze(this);
	public Hero hero = new Hero(this, keyboard);
	public Objects obj[] = new Objects[10];
	public Key key = new Key(this);
	public TreasureClose treasureC = new TreasureClose(this);
	public Potion potion = new Potion(this);
	public Life life = new Life(this);
	public SpeedUp speed = new SpeedUp(this);
	public Monster monster = new Monster(this);
	
	Sound sound=new Sound();
	Sound music=new Sound();
	

	// DEFAULT CONSTRUCTOR
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // panel's dimensions
		this.setBackground(Color.black); // background color
		this.setDoubleBuffered(true); // optimisation of the window's rendering
		this.addKeyListener(keyboard);
		this.setFocusable(true);
	}
	
	// METHODS 
	/* Method creating and launching the game's thread */
	public void startGameThread() {
		gameThread = new Thread(this); // new instance of the Thread Class
		gameThread.start(); // thread's launch
	}
	
	public void setupGame() {
		key.setKeyPosition();
		treasureC.setCloseTreasurePosition();
		potion.setPotionPosition();
		speed.setSpeedUpPosition();
		playMusic(0);
	}

	/* Method calling all the update() functions */
	public void update() {
		hero.update(); 
		monster.update();
		life.update();
	}

	/* Method calling all the draw() functions */
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		maze.draw(g2);
		for(int i=0;i<obj.length;i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		life.draw(g2);
		hero.draw(g2);
		monster.draw(g2);
		GI.draw(g2);
		g2.dispose();
	}
	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000 / FPS; // 1000000000 nanoseconds -> 60 pictures per second
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
			
			if (delta >= 1) { // each 1/60 second
				update();
				repaint(); 
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				drawCount = 0;
				timer = 0;
			}
		}
	}
}
