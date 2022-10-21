package projet;

public class Hero {
	private int posX;
	private int posY;
	
	public Hero() { //constructeur par defaut
		this.posX=0;
		this.posY=0;
	}
	
	public Hero(int posX,int posY) { //constructeur avec attributs renseignes
		this.posX=posX;
		this.posY=posY;					
	}
	
	public String toString() {
		return "posx= "+posX+"\tposY= "+posY; //\t = tabulations 
	}
	
	public void moveUp() {
		posY--;
	}
	
	public void moveDown() {
		posY++;
	}
	
	public void moveRight() {
		posX++;
	}
	
	public void moveLeft() {
		posX--;
	}
	
	
}
