package com.moss.main;

import com.moss.maze.*;

import javax.swing.JFrame;

public class Main {
	
	static GamePanel pan=new GamePanel();
	
	public static void main(String[] args) {
		
		//Window's creation
		Window window = new Window();
		
		//Start of the game's thread on the game panel
		pan.startGameThread();
		
	}

}
