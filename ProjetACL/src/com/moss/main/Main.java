package com.moss.main;

import com.moss.maze.*;

import javax.swing.JFrame;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");
	static GamePanel pan = new GamePanel();

	public static void main(String[] args) {

		// Window's creationd
		Window window = new Window();
		pan.setupGame();
		// Start of the game's thread on the game panel
		pan.startGameThread();

	}

}
