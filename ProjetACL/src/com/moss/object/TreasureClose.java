package com.moss.object;

// USEFUL IMPORTS
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// OTHER CLASSES IMPORTS
import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

// the class TreasureClose is a subclass of the Objects class and represents the treasure when it's closed

public class TreasureClose extends Objects {
	
	// MEMBER VARIABLES
	GamePanel pan;
	int mazeNumber = Maze.getMazeNumber();
	
	// DEFAULT CONSTRUCTOR
	public TreasureClose(GamePanel pan) {
		this.pan = pan;
		
		// DEFAULT VALUES
		// Name
		name = "Treasure close";
		// Position
		ListofPosX.add(2);
		ListofPosX.add(12);
		ListofPosX.add(10);
		ListofPosY.add(8);
		ListofPosY.add(8);
		ListofPosY.add(6);
		// Display
		getCloseTreasureImage();
	}
	
	/* Method loading the closed treasure image */
	public void getCloseTreasureImage() {
		
		String path = new String();
		File file;
		
		try {
			path = Main.currentDir +"/images/Objects/treasureClose.png";
			file = new File(path);
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Method setting the closed treasure position considering the maze selected at the beginning of the game */
	public void setCloseTreasurePosition() {
		 pan.obj[1]=new TreasureClose(pan);
		 pan.obj[1].x=ListofPosX.get(mazeNumber)*pan.tileSize;
		 pan.obj[1].y=ListofPosY.get(mazeNumber)*pan.tileSize;
	}
	
	/* Method returning the closed treasure position considering the maze selected at the beginning of the game */
	public int[] getCloseTreasurePosition() {
		x = ListofPosX.get(mazeNumber);
		y = ListofPosY.get(mazeNumber);
		int[] position = {x, y};
		return position;
	}
}
