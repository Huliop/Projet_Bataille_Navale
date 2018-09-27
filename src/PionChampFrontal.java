
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

	// ================================================================================================
	// PROTECTED FUNCTIONS
	// ================================================================================================
	@Override
	protected void setShootingRangePositions(int grilleSize) {
		Position positions = new Position(0,0);
		int val = 0;
		Position t1 = this.positions.get(0);
		Position t2 = this.positions.get(1);
		int x1 = t1.getLine();
		int y1 = t1.getRow();
		int x2 = t2.getLine();
		int y2 = t2.getRow();
		
		// S'ils sont sur la même ligne
		if (x1 - x2  == 0) {
			// Alors c'est vers la droite	
			if (this.moduloPosition(y1 - y2, grilleSize) == 1) {
				// On ajoute au champ de tir les (champ) cases de devant vers la droite
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.moduloPosition(y1+i, grilleSize);
					positions = new Position(x1, val);
					shootingRangePositions.add(positions);
				}
			}
			// Sinon c'est vers la gauche
			else {
				// On ajoute au champ de tir les (champ) cases de devant vers la gauche
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.moduloPosition(y1-i, grilleSize);
					positions = new Position(x1, val);
					shootingRangePositions.add(positions);
				}
			}			
		}
		// S'ils sont sur la même colonne
		else {
			// Alors c'est vers le bas
			if (this.moduloPosition(x1 - x2, grilleSize) == 1) {
				// On ajoute au champ de tir les (champ) cases de devant vers le bas
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.moduloPosition(x1+i, grilleSize);
					positions = new Position(val, y1);
					shootingRangePositions.add(positions);
				}
			}
			// Sinon c'est vers le haut
			else {
				// On ajoute au champ de tir les (champ) cases de devant vers le haut
				for (int i = 1; i < this.shootingRange + 1; i++) {
					val = this.moduloPosition(x1-i, grilleSize);
					positions = new Position(val, y1);
					shootingRangePositions.add(positions);
				}
			}		
		}
	}

}
