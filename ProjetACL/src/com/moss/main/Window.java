package com.moss.main;

// USEFUL IMPORTS
import javax.swing.JFrame;

// the class Window allows the creation of a blank window on which the game will take place

public class Window extends JFrame {

	// DEFAULT CONSTRUCTOR
	public Window() { 
		windowProperties();
		this.setVisible(true); // window's display
	}

	// METHODS
	/* Method setting the properties of the window */
	private void windowProperties() { 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when the window is closed, the program stops
		this.setResizable(false); // when a window is created, its dimensions cannot be changed
		this.setAlwaysOnTop(true); // when a window is created, it's always displayed in the foreground
		this.setTitle("MOSS's Game"); // window's title
		this.add(Main.pan); // addition of the GamePanel on the window
		this.pack(); // adjustement of the window to the GamePanel
		this.setLocationRelativeTo(null); // positioning of the window in the middle of the screen
	}
}