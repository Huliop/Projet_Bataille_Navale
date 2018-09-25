import java.util.List;

public class Grille {

	private Integer WATER = 0;
	private Integer BOAT = 1;

	private static final int size = 10;
	private int[][] terrain;
	
	public Grille() {
		iniTerrain();
	}

	private void iniTerrain() {
		this.terrain = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.setWater(i, j);
			}
		}
	}
	

	public static int getSize() {
		return size;
	}
	
	public int[][] getTerrain() {
		return terrain;
	}

	public Boolean isWater(int x, int y) {
		return(this.terrain[x][y] == WATER);
	}

	public Boolean isBoat(int x, int y) {
		return(this.terrain[x][y] == BOAT);
	}

	private void setWater(int x, int y) {
		this.terrain[x][y] = WATER;
	}

	private void setBoat(int x, int y) {
		this.terrain[x][y] = BOAT;
	}
	
	public Boolean addBoat(Pion p) {
		List<Position> positions = p.getPos();

		// On vérifie qu'il n'y a pas déjà un bateau
		for(Position position: positions) {
			if(this.isBoat(position.getPosX(), position.getPosY())) {
				return false;
			}
		}

		// Puis on ajoute le bateau
		for(Position position: positions) {
			this.setBoat(position.getPosX(), position.getPosY());
		}

		return true;
	}
	
	public String toString() {
		String ret = (this.size < 11) ? " " : "  ";

		for(int i = 0; i < size; i++) {
			ret += (i < 10) ? " "+i : i;
		}

		ret += "\n";

		for (int i = 0; i < size; i++) {
			ret += i;

			for (int j = 0; j < size; j++) {
				ret += " ";

				if(isWater(i, j)) {
					ret += "~";
				}
				else if(isBoat(i, j)) {
					ret += "B";
				}
				else {
					ret += " ";
				}
			}

			ret += (i != size - 1) ? "\n" : "";
		}

		return ret;
	}
	
}