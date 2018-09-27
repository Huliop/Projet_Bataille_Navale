
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
		Boolean p1Win, p2Win;
		while(
			!(p1Win = p1.turn(p2)) &&
			!(p2Win = p2.turn(p1))
		) { }

		String winner;
		String loser;
		if(p1Win) {
			winner = p1.getNom();
			loser = p2.getNom();
		}
		else {
			winner = p2.getNom();
			loser = p1.getNom();
		}

		System.out.println("Bravo "+winner+", vous avez gagné contre "+loser+" !");
	}

}
