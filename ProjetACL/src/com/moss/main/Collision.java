package com.moss.main;

// OTHER CLASSES IMPORTS
import com.moss.character.Character;
import com.moss.character.Monster;

//the class Collision is used to handle collisions between characters and the environment, and between characters themselves

public class Collision {

	// MEMBER VARIABLES
	GamePanel pan;
	Monster monster;
	
	// DEFAULT CONSTRUCTOR
	public Collision(GamePanel pan){
		this.pan=pan;
	}
	
	// METHODS
	/* Method checking the type of the tile which the character is moving towards.
	 * It sets :
	 * - The boolean collisionOn to true if the tile is impassable
	 * - The boolean holeOn to true if the tile is a hole */
	public void checkTile(Character character) {
		
		int characterx1=character.x+character.solidArea.x;
		int characterx2=characterx1+character.solidArea.width;
		int charactery1=character.y+character.solidArea.y;
		int charactery2=charactery1+character.solidArea.height;
		
		int leftCol=characterx1/pan.tileSize;
		int rightCol=characterx2/pan.tileSize;
		int topRow=charactery1/pan.tileSize;
		int bottomRow=charactery2/pan.tileSize;
		
		int tile1,tile2;
		
		switch(character.direction) {
		
		case"up":
			topRow=(charactery1-character.speed)/pan.tileSize;
			tile1=pan.maze.maze[topRow][leftCol];
			tile2=pan.maze.maze[topRow][rightCol];
			if(pan.maze.tile[tile1].impassable==true ||pan.maze.tile[tile2].impassable==true) {
				character.collisionOn=true;
			} else if(pan.maze.maze[topRow][leftCol]==2 ||pan.maze.maze[topRow][rightCol]==2 ) {
				character.holeOn=true;
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
			}			
			break;
		}
	}

	/* Method checking if the character is moving towards the monster.
	 * When the character encounters the monster, it sets :
	 * - The boolean collisionOn to true
	 * - The boolean monsterOn to true */
	public void checkMonster(Character character) {
		
		character.solidArea.x=character.x+character.solidArea.x;
		character.solidArea.y=character.y+character.solidArea.y;
		
		pan.monster.solidArea.x=pan.monster.x+pan.monster.solidArea.x;
		pan.monster.solidArea.y=pan.monster.y+pan.monster.solidArea.y;
		
		switch(character.direction) {
		
		case "up":
			character.solidArea.y-=character.speed;
			if(character.solidArea.intersects(pan.monster.solidArea)) {
				character.collisionOn = true;
				character.monsterOn = true;
			}
			break;
		
		case "down":
			character.solidArea.y+=character.speed;
			if(character.solidArea.intersects(pan.monster.solidArea)) {
				character.collisionOn = true;
				character.monsterOn = true;
			}
			break;
		
		case "right":
			character.solidArea.x+=character.speed;
			if(character.solidArea.intersects(pan.monster.solidArea)) {
				character.collisionOn = true;
				character.monsterOn = true;
			}
			break;
		
		case "left":
			character.solidArea.x-=character.speed;
			if(character.solidArea.intersects(pan.monster.solidArea)) {
				character.collisionOn = true;
				character.monsterOn = true;
			}
			break;
		}
		
		character.solidArea.x=character.solidAreaDefaultX;
		character.solidArea.y=character.solidAreaDefaultY;
		
		pan.monster.solidArea.x=pan.monster.solidAreaDefaultX;
		pan.monster.solidArea.y=pan.monster.solidAreaDefaultY;
	}
	

	/* Method checking if the character is moving towards the hero.
	 * When the character encounters the hero, it sets :
	 * - The boolean collisionOn to true
	 * - The boolean monsterOn to true */
	public void checkHero(Character character) {
		
		pan.monster.solidArea.x=pan.monster.x+pan.monster.solidArea.x;
		pan.monster.solidArea.y=pan.monster.y+pan.monster.solidArea.y;
		
		character.solidArea.x=character.x+character.solidArea.x;
		character.solidArea.y=character.y+character.solidArea.y;
		
		switch(pan.monster.direction) {
		
		case "up":
			pan.monster.solidArea.y-=pan.monster.speed;
			if(pan.monster.solidArea.intersects(character.solidArea)) {
				pan.monster.collisionOn = true;
				pan.monster.monsterOn = true;
			}
			break;
		
		case "down":
			pan.monster.solidArea.y+=pan.monster.speed;
			if(pan.monster.solidArea.intersects(character.solidArea)) {
				pan.monster.collisionOn = true;
				pan.monster.monsterOn = true;
			}
			break;
		
		case "right":
			pan.monster.solidArea.x+=pan.monster.speed;
			if(pan.monster.solidArea.intersects(character.solidArea)) {
				pan.monster.collisionOn = true;
				pan.monster.monsterOn = true;
			}
			break;
		
		case "left":
			pan.monster.solidArea.x-=pan.monster.speed;
			if(pan.monster.solidArea.intersects(character.solidArea)) {
				pan.monster.collisionOn = true;
				pan.monster.monsterOn = true;
			}
			break;
		}
		
		pan.monster.solidArea.x=pan.monster.solidAreaDefaultX;
		pan.monster.solidArea.y=pan.monster.solidAreaDefaultY;
		
		character.solidArea.x=character.solidAreaDefaultX;
		character.solidArea.y=character.solidAreaDefaultY;
	}
	
	/* Method checking if the character is on an object.
	 * When the character encounters an object, it sets :
	 * - The boolean collisionOn to true
	 * ????????????????????????????????????????????????????????????????????????? */

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
