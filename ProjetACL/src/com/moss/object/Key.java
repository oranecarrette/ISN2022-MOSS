package com.moss.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.GamePanel;
import com.moss.main.Main;
import com.moss.maze.Maze;

public class Key extends Objects {
	
	GamePanel pan;
	int mazeNumero = Maze.getNumero();
	
	public Key(GamePanel pan) {
		
		this.pan = pan;
		
		String path;
		File file;
		path=Main.currentDir +"/images/treasure/key.png";
		file = new File(path);
		name="Key";
		
		ListofPosX.add(10);
		ListofPosX.add(4);
		ListofPosX.add(14);
		ListofPosY.add(1);
		ListofPosY.add(3);
		ListofPosY.add(10);
		
		
		try {
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	public void setKey() {
		 pan.obj[0]=new Key(pan);
		 pan.obj[0].x=ListofPosX.get(mazeNumero)*pan.tileSize;
		 pan.obj[0].y=ListofPosY.get(mazeNumero)*pan.tileSize;
	}

}
