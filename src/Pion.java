import java.util.ArrayList;
import java.util.List;

public abstract class Pion {
	
	protected int life; // TODO quand un pion se fait toucher lui enlever une vie
	protected int size;
	protected int champDeTir;
	protected String nom;
	protected List<Position> pos;
	protected List<Position> posChampDeTir;
	
	public Pion(String nom) {
		this.life = 2;
		
		switch(nom) {
			case "Contre torpilleur":
				this.size = 3;
				this.champDeTir = 2;
				this.nom = "Contre torpilleur";
				break;
			case "Croiseur":
				this.size = 4;
				this.champDeTir = 2;
				this.nom = "Croiseur";
				break;
				case "Porte-avion":
				this.size = 5;
				this.champDeTir = 2;
				this.nom = "Porte-avion";	
				break;
			case "Sous-marin":
				this.size = 3;
				this.champDeTir = 4;
				this.nom = "Sous-marin";
				break;
			case "Torpilleur":
				this.size = 2;
				this.champDeTir = 5;
				this.nom = "Torpilleur";
				break;
			default:
				this.size = 2;
				this.champDeTir = 2;
				this.nom = "Default";
				break;
		}
		
		this.pos = new ArrayList<Position>();
		this.posChampDeTir = new ArrayList<Position>();
	}
	
	public void placerPionVertical(int x, int y, int grilleSize) {
		this.pos = new ArrayList<Position>();

		Position pInit = new Position(
			this.valPosModulo(x, grilleSize),
			this.valPosModulo(y, grilleSize)
		);
		this.pos.add(pInit);

		for(int i = 1; i < this.size; i++) {
			Position p = new Position(
				this.valPosModulo(x + i, grilleSize),
				this.valPosModulo(y, grilleSize)
			);
			this.pos.add(p);
		}

		setPosChampDeTir(grilleSize);
	}

	public void placerPionHorizontal(int x, int y, int grilleSize) {
		this.pos = new ArrayList<Position>();

		Position pInit = new Position(
			this.valPosModulo(x, grilleSize),
			this.valPosModulo(y, grilleSize)
		);
		this.pos.add(pInit);

		for(int i = 1; i < this.size; i++) {
			Position p = new Position(
				this.valPosModulo(x, grilleSize),
				this.valPosModulo(y + i, grilleSize)
			);
			this.pos.add(p);
		}

		setPosChampDeTir(grilleSize);
	}
	
	protected abstract void setPosChampDeTir(int grilleSize);
	
	public boolean peutTirer(Position pos) {
		for(Position p: posChampDeTir) {
			if(
				p.getPosX() == pos.getPosX() &&
				p.getPosY() == pos.getPosY()
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
		return this.champDeTir;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public List<Position> getPos() {
		return this.pos;
	}
	
	public List<Position> getPosChampDeTir() {
		return this.posChampDeTir;
	}

	public String toString() {
		String ret = "Positions de "+this.getNom()+" : ";

		for(Position p: this.pos) {
			ret += "("+p.getPosX()+", "+p.getPosY()+") ";
		}

		return ret;
	}
}
