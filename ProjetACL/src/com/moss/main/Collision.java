package com.moss.main;
import com.moss.character.Character;
import com.moss.character.Monster;

public class Collision {
	GamePanel pan;
	Monster monster;
	
	public Collision(GamePanel pan){
		this.pan=pan;
	}
	
	public void checkTile(Character character,Monster monster) {
		int characterx1=character.x+character.solidArea.x;
		int characterx2=characterx1+character.solidArea.width;
		int charactery1=character.y+character.solidArea.y;
		int charactery2=charactery1+character.solidArea.height;
		
		int leftCol=characterx1/pan.tileSize;
		int rightCol=characterx2/pan.tileSize;
		int topRow=charactery1/pan.tileSize;
		int bottomRow=charactery2/pan.tileSize;
		
		int tile1,tile2;
		int xm,ym;
		
		int[] monsterPosition = monster.getMonsterPosition();
		xm = monsterPosition[0]/pan.tileSize;
		ym = monsterPosition[1]/pan.tileSize;
		
		switch(character.direction) {
		case"up":
			topRow=(charactery1-character.speed)/pan.tileSize;
			tile1=pan.maze.maze[topRow][leftCol];
			tile2=pan.maze.maze[topRow][rightCol];
			if(pan.maze.tile[tile1].impassable==true ||pan.maze.tile[tile2].impassable==true) {
				character.collisionOn=true;
			} else if(pan.maze.maze[topRow][leftCol]==2 ||pan.maze.maze[topRow][rightCol]==2 ) {
				character.holeOn=true;
			} else if((leftCol == xm)&&(topRow == ym) ||(rightCol == xm)&&(topRow == ym) ) {
				character.collisionOn=true;
				character.monsterOn=true;
			}
			break;
		case"down":
			bottomRow=(charactery2+character.speed)/pan.tileSize;
			tile1=pan.maze.maze[bottomRow][leftCol];
			tile2=pan.maze.maze[bottomRow][rightCol];
			if(pan.maze.tile[tile1].impassable==true ||pan.maze.tile[tile2].impassable==true) {
				character.collisionOn=true;
			} else if(pan.maze.maze[bottomRow][leftCol]==2 ||pan.maze.maze[bottomRow][rightCol]==2 ) {
				character.holeOn=true;
			} else if((leftCol == xm)&&(bottomRow == ym) ||(rightCol == xm)&&(bottomRow == ym) ) {
				character.collisionOn=true;
				character.monsterOn=true;
			}
			break;
		case"right":
			rightCol=(characterx2+character.speed)/pan.tileSize;
			tile1=pan.maze.maze[topRow][rightCol];
			tile2=pan.maze.maze[bottomRow][rightCol];
			if(pan.maze.tile[tile1].impassable==true ||pan.maze.tile[tile2].impassable==true) {
				character.collisionOn=true;
			} else if(pan.maze.maze[topRow][rightCol]==2 ||pan.maze.maze[bottomRow][rightCol]==2 ) {
				character.holeOn=true;
			} else if((rightCol == xm)&&(topRow == ym) ||(rightCol == xm)&&(bottomRow == ym) ) {
				character.collisionOn=true;
				character.monsterOn=true;
			}
			break;
		case"left":
			leftCol=(characterx1-character.speed)/pan.tileSize;
			tile1=pan.maze.maze[topRow][leftCol];
			tile2=pan.maze.maze[bottomRow][leftCol];
			if(pan.maze.tile[tile1].impassable==true ||pan.maze.tile[tile2].impassable==true) {
				character.collisionOn=true;
			} else if(pan.maze.maze[topRow][leftCol]==2 ||pan.maze.maze[bottomRow][leftCol]==2 ) {
				character.holeOn=true;
			} else if((leftCol == xm)&&(topRow == ym) ||(leftCol == xm)&&(bottomRow == ym) ) {
				character.collisionOn=true;
				character.monsterOn=true;
			}			
			break;
		}
	}
	
	public int checkObject(Character character,boolean hero) {
		int index=-1;
		for(int i=0;i<pan.obj.length;i++) {
			if(pan.obj[i]!=null) {
				character.solidArea.x=character.x+character.solidArea.x;
				character.solidArea.y=character.y+character.solidArea.y;
				
				pan.obj[i].solidArea.x=pan.obj[i].x+pan.obj[i].solidArea.x;
				pan.obj[i].solidArea.y=pan.obj[i].y+pan.obj[i].solidArea.y;
				
				switch(character.direction) {
				case "up":
					character.solidArea.y-=character.speed;
					if(character.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision==true) {
							character.collisionOn=true;
						}
						if(hero==true) {
							index=i;
						}
					}
					break;
				case "down":
					character.solidArea.y+=character.speed;
					if(character.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision==true) {
							character.collisionOn=true;
						}
						if(hero==true) {
							index=i;
						}
					}
					break;
				case "right":
					character.solidArea.x+=character.speed;
					if(character.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision==true) {
							character.collisionOn=true;
						}
						if(hero==true) {
							index=i;
						}
					}
					break;
				case "left":
					character.solidArea.x-=character.speed;
					if(character.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision==true) {
							character.collisionOn=true;
						}
						if(hero==true) {
							index=i;
						}
					}
					break;
				}
				character.solidArea.x=character.solidAreaDefaultX;
				character.solidArea.y=character.solidAreaDefaultY;
				pan.obj[i].solidArea.x=pan.obj[i].solidAreaDefaultX;
				pan.obj[i].solidArea.y=pan.obj[i].solidAreaDefaultY;
			}
		}
		return index;
	}
	
}
