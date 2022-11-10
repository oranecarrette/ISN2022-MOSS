package com.moss.main;

public class Labyrinth {
	int taillex,tailley;
	private Tile[][] lab;
	
	public Labyrinth(int taillex,int tailley) {
		this.taillex=taillex;
		this.tailley=tailley;
		lab=new Tile[taillex][tailley];
		for(int i=0;i<taillex;i++) {
			for(int j=0;j<tailley;j++) {
				lab[i][j]=new Tile();
			}
		}
	}
	
	public void afficherLabyrinth() {
		for(int i=0;i<taillex;i++) {
			for(int j=0;j<tailley;j++) {
				System.out.print(lab[i][j].getType());
			}
			System.out.print("\n");
		}
	}
	
}
