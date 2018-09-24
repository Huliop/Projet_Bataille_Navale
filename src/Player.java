import java.util.ArrayList;
import java.util.List;

public class Player {
	
	// TODO ajouter la dimension stratégique de pouvoir voir où on a tiré et ce qui a marché?
	private boolean estTouche;
	private String adversTouche;
	private Grille grille;
	private Croiseur croiseur;
	private PorteAvion pav;
	private Torpilleur torp;
	private SousMarin sub;
	private ContreTorpilleur ctrtorp;
	private List<Pion> listPion;
	
	public Player() {
		this.estTouche = false;
		this.adversTouche = ""; // TODO faire en sorte que quand on touche quelqu'un son nom soit dans cette variable
		this.grille = new Grille();
		this.croiseur = new Croiseur();
		this.pav = new PorteAvion();
		this.torp = new Torpilleur();
		this.sub = new SousMarin();
		this.ctrtorp = new ContreTorpilleur();
		iniListPion();
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
		// }
		
	}
	
	public void setTerrainPion() {
		for (Pion p : listPion) {
			List<Position> listPos = p.getPos();
			for (Position pos : listPos) {
				this.grille.setTerrain(1, pos);
			}
		}
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
