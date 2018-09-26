
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
		
		// Le jeu commence
		System.out.println("Que la partie commence !");
		while(
			!p1.turn(p2) &&
			!p2.turn(p1)
		) { } // TODO: récupérer les valeurs de retour bon savoir qui a gagné
	}

}
