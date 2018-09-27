public class PionChampFrontal extends Pion {

	// ================================================================================================
	// CONSTRUCTOR
	// ================================================================================================
	private PionChampFrontal(Builder b) {
		super(b);
	}

	public static class Builder extends GenericBuilder<Builder> {

		@Override
		public PionChampFrontal build() {
			return new PionChampFrontal(this);
		}

	}



	@Override
	protected void setPosChampDeTir(int grilleSize) {
		Position positions = new Position(0,0);
		int val = 0;
		Position t1 = this.positions.get(0);
		Position t2 = this.positions.get(1);
		int x1 = t1.getPosX();
		int y1 = t1.getPosY();
		int x2 = t2.getPosX();
		int y2 = t2.getPosY();
		
		// S'ils sont sur la même ligne
		if (x1 - x2  == 0) {
			// Alors c'est vers la droite	
			if (this.valPosModulo(y1 - y2, grilleSize) == 1) {
				// On ajoute au champ de tir les (champ) cases de devant vers la droite
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.valPosModulo(y1+i, grilleSize);
					positions = new Position(x1, val);
					shootingRangePositions.add(positions);
				}
			}
			// Sinon c'est vers la gauche
			else {
				// On ajoute au champ de tir les (champ) cases de devant vers la gauche
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.valPosModulo(y1-i, grilleSize);
					positions = new Position(x1, val);
					shootingRangePositions.add(positions);
				}
			}			
		}
		// S'ils sont sur la même colonne
		else {
			// Alors c'est vers le bas
			if (this.valPosModulo(x1 - x2, grilleSize) == 1) {
				// On ajoute au champ de tir les (champ) cases de devant vers le bas
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.valPosModulo(x1+i, grilleSize);
					positions = new Position(val, y1);
					shootingRangePositions.add(positions);
				}
			}
			// Sinon c'est vers le haut
			else {
				// On ajoute au champ de tir les (champ) cases de devant vers le haut
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.valPosModulo(x1-i, grilleSize);
					positions = new Position(val, y1);
					shootingRangePositions.add(positions);
				}
			}		
		}
	}

}
