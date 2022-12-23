package com.moss.main;

// USEFUL IMPORTS
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");
	static GamePanel pan = new GamePanel();

	public static void main(String[] args) {

		// Creation of the window
		Window window = new Window();
		// Set up of the game
		pan.setupGame();
		// Start of the game's thread on the game panel
		pan.startGameThread();

	}

}
