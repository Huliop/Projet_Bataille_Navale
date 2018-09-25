
public class Jeu {

	public static void main(String[] args) {
		Player p1 = new Player();
		Player p2 = new Player();
		
		// TODO boucler sur la condition de victoire
		p1.turn(p2);
		p2.turn(p1);
	}

}
