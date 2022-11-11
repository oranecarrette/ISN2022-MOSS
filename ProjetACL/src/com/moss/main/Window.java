package com.moss.main;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() { //Window's constructor
		windowProperties();
		this.setVisible(true); //window's display
	}
	
	private void windowProperties() { //window's configuration
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop of the program when the window is closed
		//this.setSize(768,576); //window's dimensions
		this.setResizable(false); //when a window is created, its dimensions cannot be changed
		this.setAlwaysOnTop(true); //when a window is created, it's always displayed in the foreground
		this.setTitle("MOSS's Game"); //window's title
		this.add(Main.pan); //addition of the GamePanel on the window 
		this.pack(); //adjustement of the window to the GamePanel 
		this.setLocationRelativeTo(null); //positioning of the window in the middle of the screen
	}
}