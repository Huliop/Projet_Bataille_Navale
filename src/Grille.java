public class Grille {

	private static final int size = 10;
	private int[][] terrain;
	
	public Grille() {
		iniTerrain();
	}

	private void iniTerrain() {
		this.terrain = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.terrain[i][j] = 0;
			}
		}
	}
	

	public static int getSize() {
		return size;
	}
	
	public int[][] getTerrain() {
		return terrain;
	}
	
	public void setTerrain(int val, Position p) {
		int x = p.getPosX();
		int y = p.getPosY();
		this.terrain[x][y] = val;
	}
	
	public void display() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int val = this.terrain[i][j];
				System.out.print(val + "  ");
			}
			System.out.println("");
		}
	}
	
}