package com.moss.labyrinth;

public class Lab {
	
	int sizex,sizey;
	private Tile[][] lab;
	
	public Lab (int sizex,int sizey) {
		this.sizex = sizex;
		this.sizey = sizey;
		lab = new Tile[sizex][sizey];
		for(int i=0;i<sizex;i++) {
			for(int j=0;j<sizey;j++) {
				lab[i][j] = new Ground();
			}
		}
	}
	
	public void showLabyrinth() {
		for(int i=0;i<sizex;i++) {
			for(int j=0;j<sizey;j++) {
				System.out.print(lab[i][j].getType());
			}
			System.out.print("\n");
		}
	}

}
