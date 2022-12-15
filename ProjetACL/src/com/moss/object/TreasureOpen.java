package com.moss.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.Main;

public class TreasureOpen  extends AllObject{
	
	public TreasureOpen() {
		String path;
		File file;
		path=Main.currentDir +"/images/treasure/treasureOpen.png";
		file = new File(path);
		name="Treasure open";
		try {
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
