import java.util.ArrayList;

public class PorteAvion extends PionChampLateral {

	public PorteAvion() {
		this.life = 2;
		this.size = 5;
		this.champDeTir = 2;
		this.nom = "Porte-avion";
		this.initPos();
		this.posChampDeTir = new ArrayList<Position>();
		this.setPosChampDeTir(this.size);
	}

	@Override
	protected void initPos() {
		this.pos = new ArrayList<Position>();
		Position pos1 = new Position(1,2);
		Position pos2 = new Position(1,3);
		Position pos3 = new Position(1,4);
		Position pos4 = new Position(1,5);
		this.pos.add(pos1);
		this.pos.add(pos2);
		this.pos.add(pos3);
		this.pos.add(pos4);
	}
	
}