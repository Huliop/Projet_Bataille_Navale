import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	
	// TODO ajouter la dimension stratégique de pouvoir voir où on a tiré et ce qui a marché?
	private String name;
	private boolean estTouche;
	private String adversTouche;
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
		this.adversTouche = ""; // TODO faire en sorte que quand on touche quelqu'un son nom soit dans cette variable
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

	public void turn(Player adversaire) {
		if (!this.estTouche) {
			this.estTouche = false;
			// TODO Le joueur peut déplacer un pion jusqu'à deux positions en veillant à mettre à jour ses paramètres
		}
		// TODO Demander au joueur sur quelle position il veut attaquer
		// if (tire(pos, adversaire.listPion)) {
			// adversaire.estTouche = true;
			// System.out.println("Vous avez touché : " + adversTouche);
			// TODO Si le joueur a gagné, arrêter le jeu	
		// }	
	}

	public void placerPions() {
		System.out.println("");
		System.out.println(this.getNom()+", veuillez placer vos bateaux.");

		for(Pion p: listPion) {
			Boolean bateauError = true;

			System.out.println(this.grille);
			
			while(bateauError) { 
				System.out.print("Entrez la ligne du "+p.getNom()+" : ");
				Integer x = UserInput.IntegerInput();

				System.out.print("Entrez la colonne du "+p.getNom()+" : ");
				Integer y = UserInput.IntegerInput();

				System.out.print("Entrez l'orientation du "+p.getNom()+" (h pour horizontal, v pour vertical) : ");
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
	
	public boolean touche(List<Pion> list, Position pos) {
		for (Pion p : list) {
			if (p.getPos().contains(pos)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean tire(Position pos, List<Pion> list) {
		for (Pion p : this.listPion) {
			if (p.peutTirer(pos)) {
				if (touche(list, pos)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
	
}
