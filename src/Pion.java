import java.util.List;

public abstract class Pion {
	
	protected int life; // TODO quand un pion se fait touché lui enlever une vie
	protected int size;
	protected int champDeTir;
	protected String nom;
	protected List<Position> pos;
	protected List<Position> posChampDeTir;
	
	
	protected abstract void initPos(); // TODO A modifier pour que ça soit la joueur qui choisisse où mettre ses pions
	
	protected abstract void setPosChampDeTir(int sizeOuChamp);
	
	public boolean peutTirer(Position pos) {
		return this.posChampDeTir.contains(pos);
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
