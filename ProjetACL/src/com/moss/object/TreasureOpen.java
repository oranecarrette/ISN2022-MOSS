package com.moss.object;

// USEFUL IMPORTS
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// OTHER CLASSES IMPORTS
import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

//the class TreasureOpen is a subclass of the Objects class and represents the treasure when it's opened

public class TreasureOpen extends Objects{
	
	// MEMBER VARIABLES
	GamePanel pan;
	int mazeNumber = Maze.getMazeNumber();
	
	// DEFAULT CONSTRUCTOR
	public TreasureOpen(GamePanel pan) {
		this.pan = pan;
		
		// DEFAULT VALUES
		// Name
		name = "Treasure open";
		// Position
		ListofPosX.add(2);
		ListofPosX.add(12);
		ListofPosX.add(10);
		ListofPosY.add(8);
		ListofPosY.add(8);
		ListofPosY.add(6);
		// Display
		getOpenTreasureImage();
	}
	
	/* Method loading the opened treasure image */
	public void getOpenTreasureImage() {
		
		String path = new String();
		File file;
		
		try {
			path = Main.currentDir +"/images/Objects/treasureOpen.png";
			file = new File(path);
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Method setting the opened treasure position considering the maze selected at the beginning of the game */
	public void setOpenTreasurePosition() {
		 pan.obj[2]=new TreasureOpen(pan);
		 pan.obj[2].x=ListofPosX.get(mazeNumber)*pan.tileSize;
		 pan.obj[2].y=ListofPosY.get(mazeNumber)*pan.tileSize;
	}

}
