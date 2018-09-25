
public class Jeu {

	public static void main(String[] args) {
		// On créer les joueurs
		System.out.println("Entrons le nom des joueurs !");
		Player p1 = PlayerFactory.createPlayerAskName();
		Player p2 = PlayerFactory.createPlayerAskName();
		System.out.println("");

		// Les joueurs placent les bateaux
		System.out.println("Plaçons les bateaux !");
		p1.placerPions();
		p2.placerPions();
		System.out.println("");
		
		// TODO boucler sur la condition de victoire
		// p1.turn(p2);
		// p2.turn(p1);
	}

}
