package com.moss.maze;

import com.moss.main.GamePanel;
import com.moss.main.Main;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import javax.imageio.ImageIO;

public class Maze {

	GamePanel pan;
	Tile[] tile; // types of tile stored in a table
	public static int maze[][];

	public Maze(GamePanel pan) {
		this.pan = pan;
		tile = new Tile[5]; // 5 types of tile for now
		maze = new int[pan.maxScreenRow][pan.maxScreenCol]; // the maze!!! finally
		getTileImage();
		loadMaze(Main.currentDir + "/src/mazes/maze1.txt");
	}

	public void getTileImage() {
		String path = new String();
		File file;
		try {
			path = Main.currentDir + "/images/Tiles/ground.png";
			file = new File(path);
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(file);

			path = Main.currentDir + "/images/Tiles/wall.png";
			file = new File(path);
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(file);

			path = Main.currentDir + "/images/Tiles/water.png";
			file = new File(path);
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMaze(String mapPath) {
		File file = new File(mapPath);
		BufferedReader bufferedReader = null;
		String line;
		String mapCase[];
		int col = 0;
		int row = 0;
		try {
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				for (col = 0; col < pan.maxScreenCol; col++) {
					mapCase = line.split(" ");
					maze[row][col] = Integer.parseInt(mapCase[col]);
				}
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pan.maxScreenRow; i++) {
			for (int j = 0; j < pan.maxScreenCol; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.print("\n");
		}

		/*
		 * try { InputStream is = getClass().getResourceAsStream(filePath);
		 * BufferedReader br = new BufferedReader(new InputStreamReader(is));
		 * 
		 * int column = 0; int row = 0;
		 * 
		 * while (column < pan.maxScreenCol && row < pan.maxScreenRow) { String line =
		 * br.readLine();
		 * 
		 * while (column < pan.maxScreenCol) { String numbers[] = line.split(" "); int
		 * tileType = Integer.parseInt(numbers[column]);
		 * 
		 * maze[column][row] = tileType; column ++; }
		 * 
		 * if (column == pan.maxScreenCol) { column = 0; row ++; } } br.close(); }
		 * catch(Exception e) {
		 * 
		 * } for(int i=0;i<pan.maxScreenCol;i++) { for(int j=0;j<pan.maxScreenRow;j++) {
		 * System.out.print(maze[i][j]); } System.out.print("\n"); }
		 */

	}

	// the origin of the game panel's baseframe is at the top left corner
	public static boolean isWall(int column, int row, String direction) {

		boolean wall = false;

		switch (direction) {
		case "up":
			if (maze[column][row - 1] == 1) {
				wall = true;
			}
			break;
		case "down":
			if (maze[column][row + 1] == 1) {
				wall = true;
			}
			break;
		case "left":
			if (maze[column - 1][row] == 1) {
				wall = true;
			}
			break;
		case "right":
			if (maze[column + 1][row] == 1) {
				wall = true;
			}
			break;
		}

		return wall;
	}

	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;

		for (row = 0, y = 0; row < pan.maxScreenRow; row++, y += pan.tileSize) {
			for (col = 0, x = 0; col < pan.maxScreenCol; col++, x += pan.tileSize) {
				g2.drawImage(tile[maze[row][col]].image, x, y, pan.tileSize, pan.tileSize, null);

			}
		}
	}
}