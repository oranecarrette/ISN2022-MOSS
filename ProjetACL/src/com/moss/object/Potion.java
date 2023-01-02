package com.moss.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

public class Potion extends Objects {
		// MEMBER VARIABLES
		GamePanel pan;
		int mazeNumber = Maze.getMazeNumber();
		// DEFAULT CONSTRUCTOR
		public Potion(GamePanel pan) {
			
			// MEMBER VARIABLES
			this.pan = pan;

			// DEFAULT VALUES
			// Name
			name = "Potion";
			// Position
			ListofPosX.add(14);
			ListofPosX.add(11);
			ListofPosX.add(14);
			ListofPosY.add(1);
			ListofPosY.add(3);
			ListofPosY.add(1);
			// Display
			getPotionImage();
		}
		
		/* Method loading the key image */
		public void getPotionImage() {
			
			String path = new String();
			File file;
			
			try {
				path = Main.currentDir +"/images/Objects/potion.png";
				file = new File(path);
				image=ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/* Method setting the key position considering the maze selected at the beginning of the game */
		public void setPotionPosition() {
			 pan.obj[3]=new Potion(pan);
			 pan.obj[3].x=ListofPosX.get(mazeNumber)*pan.tileSize;
			 pan.obj[3].y=ListofPosY.get(mazeNumber)*pan.tileSize;
		}

		/* Method returning the key position considering the maze selected at the beginning of the game */
		public int[] getPotionPosition() {
			x = ListofPosX.get(mazeNumber);
			y = ListofPosY.get(mazeNumber);
			int[] position = {x, y};
			return position;
		}
}


