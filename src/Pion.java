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
	// FUNCTIONS
	// ================================================================================================
	public void placerPionVertical(int x, int y, int grilleSize) {
		this.positions = new ArrayList<Position>();

		Position pInit = new Position(
			this.valPosModulo(x, grilleSize),
			this.valPosModulo(y, grilleSize)
		);
		this.positions.add(pInit);

		for(int i = 1; i < this.size; i++) {
			Position p = new Position(
				this.valPosModulo(x + i, grilleSize),
				this.valPosModulo(y, grilleSize)
			);
			this.positions.add(p);
		}

		setPosChampDeTir(grilleSize);
	}

	public void placerPionHorizontal(int x, int y, int grilleSize) {
		this.positions = new ArrayList<Position>();

		Position pInit = new Position(
			this.valPosModulo(x, grilleSize),
			this.valPosModulo(y, grilleSize)
		);
		this.positions.add(pInit);

		for(int i = 1; i < this.size; i++) {
			Position p = new Position(
				this.valPosModulo(x, grilleSize),
				this.valPosModulo(y + i, grilleSize)
			);
			this.positions.add(p);
		}

		setPosChampDeTir(grilleSize);
	}
	
	protected abstract void setPosChampDeTir(int grilleSize);
	
	public boolean peutTirer(Position positions) {
		for(Position p: shootingRangePositions) {
			if(
				p.getPosX() == positions.getPosX() &&
				p.getPosY() == positions.getPosY()
			) return true;
		}

		return false;
	}
	
	public int valPosModulo(int i, int mod) {
		return (i%mod + mod)%mod;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int setLife() {
		return this.life;
	}

	/**
	 * @return true si le bateau est détruit, false sinon
	 */
	public Boolean looseLife() {
		this.life--;
		if(this.life == 0) return true;
		return false;
	}
	
	public int getChampDeTir() {
		return this.shootingRange;
	}
	
	public String getNom() {
		return this.name;
	}
	
	public List<Position> getPos() {
		return this.positions;
	}
	
	public List<Position> getPosChampDeTir() {
		return this.shootingRangePositions;
	}

	public String toString() {
		String ret = "Positions de "+this.getNom()+" : ";

		for(Position p: this.positions) {
			ret += "("+p.getPosX()+", "+p.getPosY()+") ";
		}

		return ret;
	}

}
