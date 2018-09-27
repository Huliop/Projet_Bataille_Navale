import java.util.List;

public class Grille {

	// =================================================================================================
	// ATTRIBUTES
	// =================================================================================================
	private static final int size = 15;
	private Case[][] battlefied;
	
	// =================================================================================================
	// CONSTRUCTOR
	// =================================================================================================
	public Grille() {
		initBattlefield();
	}

	// =================================================================================================
	// PRIVATE FUNCTIONS
	// =================================================================================================
	private void initBattlefield() {
		this.battlefied = new Case[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.battlefied[i][j] = new Case.Builder().water().build();
			}
		}
	}

	// =================================================================================================
	// PUBLIC FUNCTIONS
	// =================================================================================================
	public static int getSize() {
		return size;
	}
	
	public Boolean addBoat(Pion p) {
		List<Position> boatPositions = p.getPositions();
		List<Position> shootPositions = p.getShootingRangePositions();

		// On vérifie qu'il n'y a pas déjà un bateau
		for(Position pos: boatPositions) {
			if(this.battlefied[pos.getLine()][pos.getRow()].isBoat()) {
				return false;
			}
		}

		// On ajoute le bateau
		for(Position pos: boatPositions) {
			this.battlefied[pos.getLine()][pos.getRow()].setBoat(
				p.getName().charAt(0)
			);
		}

		// On ajoute le champ de tir du bateau
		for(Position pos: shootPositions) {
			this.battlefied[pos.getLine()][pos.getRow()].setShootingRange();
		}

		return true;
	}

	public void update(List<Pion> boats) {
		initBattlefield();

		for(Pion boat: boats) {
			addBoat(boat);
		}
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
				String padding = (battlefied[i][j].isShootingRange()) ? ">" : " ";
				ret += padding+battlefied[i][j].getLetter();
			}

			ret += (i != size - 1) ? "\n" : "";
		}

		return ret;
	}

}
