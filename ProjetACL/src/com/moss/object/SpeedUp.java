package com.moss.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

public class SpeedUp extends Objects {
	// MEMBER VARIABLES
			GamePanel pan;
			int mazeNumber = Maze.getMazeNumber();
			// DEFAULT CONSTRUCTOR
			public SpeedUp(GamePanel pan) {
				
				// MEMBER VARIABLES
				this.pan = pan;

				// DEFAULT VALUES
				// Name
				name = "SpeedUp";
				// Position
				ListofPosX.add(1);
				ListofPosX.add(1);
				ListofPosX.add(1);
				ListofPosY.add(10);
				ListofPosY.add(10);
				ListofPosY.add(10);
				// Display
				getSpeedUpImage();
			}
			
			/* Method loading the key image */
			public void getSpeedUpImage() {
				
				String path = new String();
				File file;
				
				try {
					path = Main.currentDir +"/images/Objects/speed.png";
					file = new File(path);
					image=ImageIO.read(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			/* Method setting the key position considering the maze selected at the beginning of the game */
			public void setSpeedUpPosition() {
				 pan.obj[4]=new SpeedUp(pan);
				 pan.obj[4].x=ListofPosX.get(mazeNumber)*pan.tileSize;
				 pan.obj[4].y=ListofPosY.get(mazeNumber)*pan.tileSize;
			}

			/* Method returning the key position considering the maze selected at the beginning of the game */
			public int[] getSpeedUpPosition() {
				x = ListofPosX.get(mazeNumber);
				y = ListofPosY.get(mazeNumber);
				int[] position = {x, y};
				return position;
			}
}
