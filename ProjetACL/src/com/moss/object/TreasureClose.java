package com.moss.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

public class TreasureClose extends Objects {
	
	GamePanel pan;
	int mazeNumero = Maze.getNumero();
	
	public TreasureClose(GamePanel pan) {
		
		this.pan = pan;
		
		String path;
		File file;
		path=Main.currentDir +"/images/treasure/treasureClose.png";
		file = new File(path);
		name="Treasure close";
		
		ListofPosX.add(2);
		ListofPosX.add(12);
		ListofPosX.add(10);
		ListofPosY.add(8);
		ListofPosY.add(8);
		ListofPosY.add(6);
		
		try {
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setTreasure() {
		 pan.obj[1]=new TreasureClose(pan);
		 pan.obj[1].x=ListofPosX.get(mazeNumero)*pan.tileSize;
		 pan.obj[1].y=ListofPosY.get(mazeNumero)*pan.tileSize;
	}
}
