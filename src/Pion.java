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
		case "Contre Torpilleur":
			this.size = 3;
			this.champDeTir = 2;
			this.nom = "Contre torpilleur";
		case "Croiseur":
			this.size = 4;
			this.champDeTir = 2;
			this.nom = "Croiseur";
		case "Porte-Avion":
			this.size = 5;
			this.champDeTir = 2;
			this.nom = "Porte-avion";	
		case "Sous-marin":
			this.size = 3;
			this.champDeTir = 4;
			this.nom = "Sous-marin";
		case "Torpilleur":
			this.size = 2;
			this.champDeTir = 5;
			this.nom = "Torpilleur";
		default:
			this.size = 2;
			this.champDeTir = 2;
			this.nom = "Default";
		}
		
		this.initPos(this.nom);
		this.posChampDeTir = new ArrayList<Position>();
		this.setPosChampDeTir();
	}
	
	protected void initPos(String nom) {
		// TODO A modifier pour que ça soit le joueur qui choisisse où mettre ses pions
	}
	
	protected abstract void setPosChampDeTir();
	
	public boolean peutTirer(Position pos) {
		return this.posChampDeTir.contains(pos);
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
}
