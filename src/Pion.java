import java.util.ArrayList;
import java.util.List;

public abstract class Pion {
	
	// =================================================================================================
	// ATTRIBUTES
	// =================================================================================================
	protected int life;
	protected int size;
	protected int shootingRange;
	protected String name;
	protected List<Position> positions;
	protected List<Position> shootingRangePositions;
	
	// ================================================================================================
	// CONSTRUCTOR
	// ================================================================================================
	protected Pion(GenericBuilder<?> b) {
		this.name = b.name;
		this.size = b.size;
		this.shootingRange = b.shootingRange;
		this.life = 2;
		this.positions = new ArrayList<Position>();
		this.shootingRangePositions = new ArrayList<Position>();
	}

	public abstract static class GenericBuilder<T extends GenericBuilder<T>> {

		private String name;
		private int size;
		private int shootingRange;

		public GenericBuilder() {}

		public GenericBuilder<T> addName(String name) {
			this.name = name;
			return this;
		}

		public GenericBuilder<T> addSize(int size) {
			this.size = size;
			return this;
		}

		public GenericBuilder<T> addShootingRange(int shootingRange) {
			this.shootingRange = shootingRange;
			return this;
		}

		abstract public Pion build();

	}
	
	// ================================================================================================
	// PROTECTED FUNCTIONS
	// ================================================================================================
	protected abstract void setShootingRangePositions(int grilleSize);

	// ================================================================================================
	// PUBLIC FUNCTIONS
	// ================================================================================================
	public int moduloPosition(int i, int mod) {
		return (i%mod + mod)%mod;
	}

	public int getSize() {
		return this.size;
	}
	
	public int getLife() {
		return this.life;
	}

	public int getShootingRange() {
		return this.shootingRange;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Position> getPositions() {
		return this.positions;
	}
	
	public List<Position> getShootingRangePositions() {
		return this.shootingRangePositions;
	}

	public int setLife() {
		return this.life;
	}

	/**
	 * @return true si le bateau est détruit, false sinon
	 */
	public Boolean looseLife() {
		this.life--;
		return(this.life == 0);
	}

	public boolean canShoot(Position positions) {
		for(Position p: shootingRangePositions) {
			if(
				p.getLine() == positions.getLine() &&
				p.getRow() == positions.getRow()
			) return true;
		}

		return false;
	}
	
	public void placeVerticalPion(int x, int y, int grilleSize) {
		this.positions = new ArrayList<Position>();

		Position headPosition = new Position(
			this.moduloPosition(x, grilleSize),
			this.moduloPosition(y, grilleSize)
		);
		this.positions.add(headPosition);

		for(int i = 1; i < getSize(); i++) {
			Position p = new Position(
				this.moduloPosition(x + i, grilleSize),
				this.moduloPosition(y, grilleSize)
			);
			this.positions.add(p);
		}

		setShootingRangePositions(grilleSize);
	}

	public void placeHorizontalPion(int x, int y, int grilleSize) {
		this.positions = new ArrayList<Position>();

		Position headPosition = new Position(
			this.moduloPosition(x, grilleSize),
			this.moduloPosition(y, grilleSize)
		);
		this.positions.add(headPosition);

		for(int i = 1; i < getSize(); i++) {
			Position p = new Position(
				this.moduloPosition(x, grilleSize),
				this.moduloPosition(y + i, grilleSize)
			);
			this.positions.add(p);
		}

		setShootingRangePositions(grilleSize);
	}

	public String toString() {
		String ret = "Positions de "+this.getName()+" : ";

		for(Position p: this.positions) {
			ret += "("+p.getLine()+", "+p.getRow()+") ";
		}

		return ret;
	}

}
