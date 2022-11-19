package com.moss.maze;

import com.moss.main.GamePanel; 
import com.moss.maze.Tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Maze {
	GamePanel pan;
	private Tile[][] maze;
	
	public BufferedImage ground, wall;
	
	
	public Maze(GamePanel pan) {
		this.pan=pan;
		
		maze = new Tile[16][12];
		for(int col=0;col<16;col++) {
			for(int row=0;row<12;row++) {
				maze[col][row] = new Tile(col,row,0);
			}	
		} 
		maze[4][5] = new Tile(4,5,1);
				
		getTileImage();
	}
	
	public void showMaze() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<16;j++) {
				System.out.print(Tile.getTypeWithPositions(i,j));
			}
			System.out.print("\n");
		}
	}
	
	public void getTileImage() {
		try {
			ground = ImageIO.read(getClass().getResourceAsStream("/tiles/ground.png")); //picture of the ground
			wall = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")); //picture of the wall
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		for (int i=0;i<16;i++) {
			for(int j=0;j<12;j++) {
				switch (Tile.getTypeWithPositions(i,j)) {
				case 0:
					image = ground; 
					break;
				case 1:
					image = wall;
					break;
				}
			g2.drawImage(image, 48*i, 48*j, pan.tileSize, pan.tileSize, null);	
			}
		}
	}
}