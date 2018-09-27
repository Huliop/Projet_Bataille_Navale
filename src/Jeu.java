
public class Jeu {

	public static void main(String[] args) {
		// On créer les joueurs
		System.out.println("Entrons le nom des joueurs !");
		Player p1 = PlayerFactory.createPlayerAskName();
		Player p2 = PlayerFactory.createPlayerAskName();
		System.out.println("");

		// Les joueurs placent les bateaux
		System.out.println("Plaçons les bateaux !");
		p1.placePions();
		p2.placePions();
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
			winner = p1.getName();
			loser = p2.getName();
		}
		else {
			winner = p2.getName();
			loser = p1.getName();
		}

		System.out.println("Bravo "+winner+", vous avez gagné contre "+loser+" !");
	}

}
