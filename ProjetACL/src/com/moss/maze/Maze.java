package com.moss.maze;

import com.moss.main.GamePanel;
import com.moss.main.Main;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Maze {

	GamePanel pan;
	public Tile[] tile; // types of tile stored in a table
	public int maze[][];
	
	// creation of an ArrayList which contains indexes
	public ArrayList<Integer> mazeIndex = new ArrayList<Integer>(Arrays.asList(0,1,2));
	public static int mazeNumero;
	
	// creation of an ArrayList which contains the paths of the different mazes
	public ArrayList<String> adressesMazes = new ArrayList<String>(Arrays.asList("maze1","maze2","maze3"));
	public String adresseChoisie = new String();
	
	public Maze(GamePanel pan) {
		this.pan = pan;
		tile = new Tile[5]; // 5 types of tile for now
		maze = new int[pan.maxScreenRow][pan.maxScreenCol]; // the maze!!! finally
		getTileImage();
		getCollisionInformation();
		// Random choice of a maze to load
		mazeNumero = getRandomMaze();
		adresseChoisie = adressesMazes.get(mazeNumero);
		loadMaze(Main.currentDir + "/src/mazes/" + adresseChoisie + ".txt");
	}
	
	// method which selects one maze randomly
	public int getRandomMaze() {
		// Collections.shuffle shuffles the elements of adressesMazes
		Collections.shuffle(mazeIndex);
		Collections.shuffle(mazeIndex);
		// Since the elements of adressesMazes are no longer in their initial order,
		// getting the first element of it permits to choose one maze randomly
		return mazeIndex.get(0);
	}
	
	public static int getNumero() {
	       return mazeNumero;
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

			path = Main.currentDir + "/images/Tiles/hole.png";
			file = new File(path);
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCollisionInformation() {
		tile[1].impassable=true;
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