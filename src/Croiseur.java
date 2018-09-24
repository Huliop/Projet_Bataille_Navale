import java.util.ArrayList;

public class Croiseur extends PionChampFrontal {

	public Croiseur() {
		this.life = 2;
		this.size = 4;
		this.champDeTir = 2;
		this.nom = "Croiseur";
		this.initPos();
	}
	
	@Override
	protected void initPos() {
		this.pos = new ArrayList<Position>();
		Position pos1 = new Position(6,6);
		Position pos2 = new Position(6,7);
		Position pos3 = new Position(6,8);
		Position pos4 = new Position(6,9);
		this.pos.add(pos1);
		this.pos.add(pos2);
		this.pos.add(pos3);
		this.pos.add(pos4);
		
	}

}
