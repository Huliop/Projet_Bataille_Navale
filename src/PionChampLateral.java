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



	// On met à jour les positions sur lesquelles peut tirer notre pion
	@Override
	protected void setPosChampDeTir(int grilleSize) {
		Position t1 = this.positions.get(0);
		Position t2 = this.positions.get(1);
		
		// S'ils sont sur la même ligne 
		if ((t1.getPosX() - t2.getPosX()) == 0) {
			// On ajoute les deux cases au dessous et en dessous au champ de tir pour chaque cellule du pion
			for (int i = 0; i < this.size; i++) {
				Position positions = this.positions.get(i);
				int x = positions.getPosX();
				int y = positions.getPosY();
				Position pos1 = new Position(this.valPosModulo(x+1, grilleSize), y);
				Position pos2 = new Position(this.valPosModulo(x+2, grilleSize), y);
				Position pos3 = new Position(this.valPosModulo(x-1, grilleSize), y);
				Position pos4 = new Position(this.valPosModulo(x-2, grilleSize), y);
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
				int x = positions.getPosX();
				int y = positions.getPosY();
				Position pos1 = new Position(x, this.valPosModulo(y+1, grilleSize));
				Position pos2 = new Position(x, this.valPosModulo(y+2, grilleSize));
				Position pos3 = new Position(x, this.valPosModulo(y-1, grilleSize));
				Position pos4 = new Position(x, this.valPosModulo(y-2, grilleSize));
				shootingRangePositions.add(pos1);
				shootingRangePositions.add(pos2);
				shootingRangePositions.add(pos3);
				shootingRangePositions.add(pos4);
			}			
		}
	}

}