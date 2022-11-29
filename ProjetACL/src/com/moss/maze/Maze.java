package com.moss.maze;

import com.moss.main.GamePanel; 

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class Maze {
	
	GamePanel pan;
	Tile[] tile; //types of tile stored in a table
	public static int maze[][]; 
	
	public Maze(GamePanel pan) {
		this.pan=pan;
		tile = new Tile[5]; //5 types of tile for now
		maze = new int[pan.maxScreenCol][pan.maxScreenRow]; //the maze!!! finally
		
		getTileImage();
		loadMaze("/mazes/maze1.txt");
	}
	
	public void loadMaze(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int column = 0;
			int row = 0;
			
			while (column < pan.maxScreenCol && row < pan.maxScreenRow) {
				String line = br.readLine();
				
				while (column < pan.maxScreenCol) {
					String numbers[] = line.split(" ");
					int tileType = Integer.parseInt(numbers[column]);
					
					maze[column][row] = tileType;
					column ++;
				}
				
				if (column == pan.maxScreenCol) {
					column = 0;
					row ++;
				}
			}
			br.close();
		} catch(Exception e) {
			
		}
	}
	
	//the origin of the game panel's baseframe is at the top left corner
	public static boolean isWall(int column, int row, String direction) {

		boolean wall = false;
		
		switch (direction) {
		case "up": 
			if (maze[column][row-1] == 1) { 
				wall = true ;
			}
			break;
		case "down":
			if (maze[column][row+1] == 1) {
				wall = true ;
			}		
			break;
		case "left":
			if (maze[column-1][row] == 1) {
				wall = true ;
			}			
			break;
		case "right":
			if (maze[column+1][row] == 1) {
				wall = true ;
			}				
			break;
		}
		
		return wall;
	}
	
	public void getTileImage() {
		try {
			tile[0] = new Tile(); //ground
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ground.png")); //picture of the ground
			
			tile[1] = new Tile(); //wall
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")); //picture of the wall
		
			tile[2] = new Tile(); //treasure chest
			//picture of the treasure chest
			
			tile[3] = new Tile(); //hole
			//picture of a hole
			
			tile[4] = new Tile(); //portal
			//picture of a portal
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int column = 0;
		int row = 0;
		int x = 0;
		int y = 0 ;
		
		while (column < pan.maxScreenCol && row < pan.maxScreenRow) {
			int tileType = maze[column][row];
			
			g2.drawImage(tile[tileType].image, x, y, pan.tileSize, pan.tileSize, null);
			column ++; //next column
			x += pan.tileSize; //next column in a graphic way
					
			if (column == pan.maxScreenCol) { //if we are at the last column 
				column = 0;
				x = 0;
				row ++; //next row
				y += pan.tileSize; //next row in a graphic way
			}
		}
		
	}
}