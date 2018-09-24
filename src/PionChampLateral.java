public abstract class PionChampLateral extends Pion {

	@Override
	protected abstract void initPos();

	@Override
	protected void setPosChampDeTir(int size) {				
		Position t1 = this.pos.get(0);
		Position t2 = this.pos.get(1);
		
		// S'ils sont sur la même ligne 
		if ((t1.getPosX() - t2.getPosX()) == 0) {
			// On ajoute les deux cases au dessous et en dessous au champ de tir pour chaque cellule du pion
			for (int i = 0; i < size; i++) {
				Position pos = this.pos.get(i);
				int x = pos.getPosX();
				int y = pos.getPosY();
				Position pos1 = new Position(x, ((y+1)%10 + 10)%10);
				Position pos2 = new Position(x, ((y+2)%10 + 10)%10);
				Position pos3 = new Position(x, ((y-1)%10 + 10)%10);
				Position pos4 = new Position(x, ((y-2)%10 + 10)%10);
				posChampDeTir.add(pos1);
				posChampDeTir.add(pos2);
				posChampDeTir.add(pos3);
				posChampDeTir.add(pos4);
			}
		}
		// S'ils sont sur la même colonne
		else {
			for (int i = 0; i < size; i++) {
				// On ajoute les deux cases à droite et à gauche au champ de tir pour chaque cellule du pion
				Position pos = this.pos.get(i);
				int x = pos.getPosX();
				int y = pos.getPosY();
				Position pos1 = new Position(((x+1)%10 + 10)%10, y);
				Position pos2 = new Position(((x+2)%10 + 10)%10, y);
				Position pos3 = new Position(((x-1)%10 + 10)%10, y);
				Position pos4 = new Position(((x-2)%10 + 10)%10, y);
				posChampDeTir.add(pos1);
				posChampDeTir.add(pos2);
				posChampDeTir.add(pos3);
				posChampDeTir.add(pos4);
			}			
		}
	}

}