
public class PionChampLateral extends Pion {

	// ================================================================================================
	// CONSTRUCTOR
	// ================================================================================================
	public PionChampLateral(Builder b) {
		super(b);
	}

	public static class Builder extends GenericBuilder<Builder> {

		@Override
		public PionChampLateral build() {
			return new PionChampLateral(this);
		}

	}

	// ================================================================================================
	// PROTECTED FUNCTIONS
	// ================================================================================================
	@Override
	protected void setShootingRangePositions(int grilleSize) {
		Position t1 = this.positions.get(0);
		Position t2 = this.positions.get(1);
		
		// S'ils sont sur la même ligne 
		if ((t1.getLine() - t2.getLine()) == 0) {
			// On ajoute les deux cases au dessous et en dessous au champ de tir pour chaque cellule du pion
			for (int i = 0; i < this.size; i++) {
				Position positions = this.positions.get(i);
				int x = positions.getLine();
				int y = positions.getRow();
				Position pos1 = new Position(this.moduloPosition(x+1, grilleSize), y);
				Position pos2 = new Position(this.moduloPosition(x+2, grilleSize), y);
				Position pos3 = new Position(this.moduloPosition(x-1, grilleSize), y);
				Position pos4 = new Position(this.moduloPosition(x-2, grilleSize), y);
				shootingRangePositions.add(pos1);
				shootingRangePositions.add(pos2);
				shootingRangePositions.add(pos3);
				shootingRangePositions.add(pos4);
			}
		}
		// S'ils sont sur la même colonne
		else {
			for (int i = 0; i < this.size; i++) {
				// On ajoute les deux cases à droite et à gauche au champ de tir pour chaque cellule du pion
				Position positions = this.positions.get(i);
				int x = positions.getLine();
				int y = positions.getRow();
				Position pos1 = new Position(x, this.moduloPosition(y+1, grilleSize));
				Position pos2 = new Position(x, this.moduloPosition(y+2, grilleSize));
				Position pos3 = new Position(x, this.moduloPosition(y-1, grilleSize));
				Position pos4 = new Position(x, this.moduloPosition(y-2, grilleSize));
				shootingRangePositions.add(pos1);
				shootingRangePositions.add(pos2);
				shootingRangePositions.add(pos3);
				shootingRangePositions.add(pos4);
			}			
		}
	}

}
