package com.moss.main;

public class Maze {
	int sizex,sizey;
	private Tile[][] lab;
	
	public Maze(int sizex,int sizey) {
		this.sizex = sizex;
		this.sizey = sizey;
		lab = new Tile[sizex][sizey];
		for(int i=0;i<sizex;i++) {
			for(int j=0;j<sizey;j++) {
				lab[i][j] = new Tile(i,j);
			}
		}
	}
	
	public void showMaze() {
		for(int i=0;i<sizex;i++) {
			for(int j=0;j<sizey;j++) {
				System.out.print(lab[i][j].getType(i,j));
			}
			System.out.print("\n");
		}
	}
	
}