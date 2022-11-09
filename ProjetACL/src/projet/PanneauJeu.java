package projet;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanneauJeu extends JPanel implements Runnable{
	// Variables et Constantes
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;

	final int tileSize = originalTileSize * scale;// 48x48 tile 
	final int maxScreenCol=16;
	final int maxScreenLigne=12;
	final int screenLargeur=tileSize*maxScreenCol; //768pixels
	final int screenHauteur=tileSize*maxScreenLigne; //576 pixels
	
	Thread gameThread;
	
	public PanneauJeu() {
		System.out.println(screenHauteur);
		System.out.println(screenLargeur);
		this.setPreferredSize(new Dimension(screenLargeur,screenHauteur));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
	public void startGameThread() {
		gameThread=new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
