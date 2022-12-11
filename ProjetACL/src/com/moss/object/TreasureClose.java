package com.moss.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.Main;

public class TreasureClose extends AllObject {
	
	public TreasureClose() {
		String path;
		File file;
		path=Main.currentDir +"/images/treasure/treasureClose.png";
		file = new File(path);
		name="Treasure close";
		try {
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
