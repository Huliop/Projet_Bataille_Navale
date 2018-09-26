import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	
	// TODO ajouter la dimension stratégique de pouvoir voir où on a tiré et ce qui a marché?
	private String name;
	private boolean estTouche;
	private Grille grille;
	private PionChampFrontal croiseur;
	private PionChampLateral pav;
	private PionChampFrontal torp;
	private PionChampFrontal sub;
	private PionChampLateral ctrtorp;
	private List<Pion> listPion;
	
	private Player(Builder b) {
		name = b.name;

		this.estTouche = false;
		this.grille = new Grille();
		this.croiseur = new PionChampFrontal("Croiseur");
		this.pav = new PionChampLateral("Porte-avion");
		this.torp = new PionChampFrontal("Torpilleur");
		this.sub = new PionChampFrontal("Sous-marin");
		this.ctrtorp = new PionChampLateral("Contre torpilleur");
		iniListPion();
	}

	public static class Builder {
		private String name;

		public Builder(String name) {
			this.name = name;
		}

		public Player build() {
			return new Player(this);
		}
	}

	public String getNom() {
		return this.name;
	}

	private void iniListPion() {
		this.listPion = new ArrayList<Pion>();
		this.listPion.add(this.croiseur);
		this.listPion.add(this.pav);
		this.listPion.add(this.torp);
		this.listPion.add(this.sub);
		this.listPion.add(this.ctrtorp);
	}

	/**
	 * @return true si le joueur a gagné, false sinon
	 */
	public Boolean turn(Player adversaire) {
		if (!this.estTouche) {
			this.estTouche = false;
			// TODO Le joueur peut déplacer un pion jusqu'à deux positions en veillant à mettre à jour ses paramètres
		}

		System.out.println(grille);

		Position shootPosition = new Position(0, 0);
		Boolean shootError = true;
		while(shootError) {
			System.out.println(this.getNom()+", où voulez-vous tirer ?");
			shootPosition = UserInput.PositionInput();

			if(canShoot(shootPosition)) shootError = false;
			else System.out.println("Impossible de tirer ici, veuillez saisir une position correcte.");
		}
		
		if (tire(shootPosition, adversaire.listPion)) {
			adversaire.estTouche = true;

			// TODO Si le joueur a gagné, arrêter le jeu
		}
		else {
			System.out.println("Raté ...");
		}

		return false; // TODO: retourner true si le joueur a gagné
	}

	public void placerPions() {
		System.out.println("");
		System.out.println(this.getNom()+", veuillez placer vos bateaux.");

		for(Pion p: listPion) {
			Boolean bateauError = true;

			System.out.println(this.grille);
			
			while(bateauError) {
				System.out.println(this.getNom()+", où voulez-vous placer le "+p.getNom()+" ?");
				Position boatPosition = UserInput.PositionInput();
				Integer x = boatPosition.getPosX();
				Integer y = boatPosition.getPosY();

				System.out.print("Orientation (h pour horizontal, v pour vertical) : ");
				ArrayList<String> authorized = new ArrayList<String>();
				authorized.add("h");
				authorized.add("v");
				String orientation = UserInput.VerifiedInput(authorized);
				
				if(orientation.contains("h")) {
					p.placerPionHorizontal(x, y, this.grille.getSize());
				}
				else {
					p.placerPionVertical(x, y, this.grille.getSize());
				}

				if(this.grille.addBoat(p)) {
					bateauError = false;
				}
				else {
					System.out.println("Impossible de placer le bateau ici, veuillez recommencer.");
				}
			}
		}

		System.out.println("Super, voici la position de vos bateaux :");
		System.out.println(this.grille);
	}
	
	public boolean touche(List<Pion> adversaireList, Position pos) {
		for (Pion pion : adversaireList) {
			for(Position p: pion.getPos()) {
				if(
					p.getPosX() == pos.getPosX() &&
					p.getPosY() == pos.getPosY()
				) {
					if(pion.looseLife()) System.out.println("Touché, coulé !"); // TODO: enlever le bateau si coulé
					else System.out.println("Touché !");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean tire(Position pos, List<Pion> adversaireList) {
		for (Pion p : this.listPion) {
			if (p.peutTirer(pos)) {
				if (touche(adversaireList, pos)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	private Boolean canShoot(Position p) {
		for(Pion pion: listPion) {
			if(pion.peutTirer(p)) return true;
		}

		return false;
	}
	
}
