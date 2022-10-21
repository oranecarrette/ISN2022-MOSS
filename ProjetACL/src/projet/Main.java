package projet;

public class Main {

	public static void main(String[] args) {
		Hero h=new Hero(5,2);
		/*System.out.println(h);
		h.moveUp();
		System.out.println(h);
		h.moveRight();
		System.out.println(h);*/
		Tile t=new Tile();
		//System.out.println(t.getType());
		Labyrinth lab=new Labyrinth(20, 20);
		lab.afficherLabyrinth();
	}

}
