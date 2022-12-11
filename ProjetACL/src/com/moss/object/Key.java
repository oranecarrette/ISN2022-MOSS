package com.moss.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.Main;

public class Key extends AllObject {
	
	public Key() {
		String path;
		File file;
		path=Main.currentDir +"/images/treasure/key.png";
		file = new File(path);
		name="Key";
		try {
			image=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
