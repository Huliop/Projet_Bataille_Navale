import java.util.List;

public class Grille {

	private static final int size = 15;
	private Case[][] terrain;
	
	public Grille() {
		iniTerrain();
	}

	private void iniTerrain() {
		this.terrain = new Case[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.terrain[i][j] = new Case.Builder().water().build();
			}
		}
	}

	public static int getSize() {
		return size;
	}
	
	public Case[][] getTerrain() {
		return terrain;
	}
	
	public Boolean addBoat(Pion p) {
		List<Position> positions = p.getPos();
		List<Position> shootPositions = p.getPosChampDeTir();

		// On vérifie qu'il n'y a pas déjà un bateau
		for(Position pos: positions) {
			if(this.terrain[pos.getPosX()][pos.getPosY()].isBoat()) {
				return false;
			}
		}

		// On ajoute le bateau
		for(Position position: positions) {
			this.terrain[position.getPosX()][position.getPosY()].setBoat(
				p.getNom().charAt(0)
			);
		}

		// On ajoute le champ de tir du bateau
		for(Position pos: shootPositions) {
			this.terrain[pos.getPosX()][pos.getPosY()].setShootingRange();
		}

		return true;
	}
	
	public String toString() {
		String ret = "  ";

		for(int i = 0; i < size; i++) {
			ret += (i < 10) ? " "+i : i;
		}

		ret += "\n";

		for(int i = 0; i < size; i++) {
			ret += (i < 10) ? " "+i : i;

			for(int j = 0; j < size; j++) {
				String padding = (terrain[i][j].isShootingRange()) ? ">" : " ";
				ret += padding+terrain[i][j].getLetter();
			}

			ret += (i != size - 1) ? "\n" : "";
		}

		return ret;
	}

	public void update(List<Pion> boats) {
		iniTerrain();
		for(Pion boat: boats) {
			addBoat(boat);
		}
	}
	
}