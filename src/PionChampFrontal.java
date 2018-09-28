
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
		Position position = new Position(0,0);
		int val, val2 = 0;
		Position t1 = this.positions.get(0);
		Position tn = this.positions.get(this.getSize() - 1);
		int x1 = t1.getLine();
		int y1 = t1.getRow();
		int xn = tn.getLine();
		int yn = tn.getRow();
		
		// S'ils sont sur la même ligne
		if (x1 - xn  == 0) {
			// On ajoute au champ de tir les (champ) cases de devant et derrière
			for (int i = 1; i < this.shootingRange + 1; i++) {
				val = this.moduloPosition(y1-i, grilleSize);
				val2 = this.moduloPosition(yn+i, grilleSize);
				position = new Position(x1, val);
				shootingRangePositions.add(position);
				position = new Position(xn, val2);
				shootingRangePositions.add(position);
			}
		}
		// S'ils sont sur la même colonne
		else {
			// On ajoute au champ de tir les (champ) cases de devant et derrière
			for (int i = 1; i < this.shootingRange + 1; i++) {
				val = this.moduloPosition(x1-i, grilleSize);
				val2 = this.moduloPosition(xn+i, grilleSize);
				position = new Position(val, y1);
				shootingRangePositions.add(position);
				position = new Position(val2, yn);
				shootingRangePositions.add(position);
			}	
		}
	}

}
