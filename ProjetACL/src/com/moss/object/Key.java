package com.moss.object;

// USEFUL IMPORTS
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// OTHER CLASSES IMPORTS
import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

// the class Key is a subclass of the Objects class and represents the key necessary to open the treasure and win the game

public class Key extends Objects {
	
	// MEMBER VARIABLES
	GamePanel pan;
	int mazeNumber = Maze.getMazeNumber();
	
	// DEFAULT CONSTRUCTOR
	public Key(GamePanel pan) {
		
		// MEMBER VARIABLES
		this.pan = pan;

		// DEFAULT VALUES
		// Name
		name = "Key";
		// Position
		ListofPosX.add(10);
		ListofPosX.add(4);
		ListofPosX.add(14);
		ListofPosY.add(1);
		ListofPosY.add(3);
		ListofPosY.add(10);
		// Display
		getKeyImage();
	}
		
	/* Method loading the key image */
	public void getKeyImage() {
		
		String path = new String();
		File file;
		
		try {
			path = Main.currentDir +"/images/Objects/key.png";
			file = new File(path);
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Method setting the key position considering the maze selected at the beginning of the game */
	public void setKeyPosition() {
		 pan.obj[0]=new Key(pan);
		 pan.obj[0].x=ListofPosX.get(mazeNumber)*pan.tileSize;
		 pan.obj[0].y=ListofPosY.get(mazeNumber)*pan.tileSize;
	}

	/* Method returning the key position considering the maze selected at the beginning of the game */
	public int[] getKeyPosition() {
		x = ListofPosX.get(mazeNumber);
		y = ListofPosY.get(mazeNumber);
		int[] position = {x, y};
		return position;
	}
	
}
