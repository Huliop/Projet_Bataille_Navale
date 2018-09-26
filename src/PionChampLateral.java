public class PionChampLateral extends Pion {

	public PionChampLateral(String nom) {
		super(nom);
	}

	// On met à jour les positions sur lesquelles peut tirer notre pion
	@Override
	protected void setPosChampDeTir(int grilleSize) {
		Position t1 = this.pos.get(0);
		Position t2 = this.pos.get(1);
		
		// S'ils sont sur la même ligne 
		if ((t1.getPosX() - t2.getPosX()) == 0) {
			// On ajoute les deux cases au dessous et en dessous au champ de tir pour chaque cellule du pion
			for (int i = 0; i < this.size; i++) {
				Position pos = this.pos.get(i);
				int x = pos.getPosX();
				int y = pos.getPosY();
				Position pos1 = new Position(this.valPosModulo(x+1, grilleSize), y);
				Position pos2 = new Position(this.valPosModulo(x+2, grilleSize), y);
				Position pos3 = new Position(this.valPosModulo(x-1, grilleSize), y);
				Position pos4 = new Position(this.valPosModulo(x-2, grilleSize), y);
				posChampDeTir.add(pos1);
				posChampDeTir.add(pos2);
				posChampDeTir.add(pos3);
				posChampDeTir.add(pos4);
			}
		}
		// S'ils sont sur la même colonne
		else {
			for (int i = 0; i < this.size; i++) {
				// On ajoute les deux cases à droite et à gauche au champ de tir pour chaque cellule du pion
				Position pos = this.pos.get(i);
				int x = pos.getPosX();
				int y = pos.getPosY();
				Position pos1 = new Position(x, this.valPosModulo(y+1, grilleSize));
				Position pos2 = new Position(x, this.valPosModulo(y+2, grilleSize));
				Position pos3 = new Position(x, this.valPosModulo(y-1, grilleSize));
				Position pos4 = new Position(x, this.valPosModulo(y-2, grilleSize));
				posChampDeTir.add(pos1);
				posChampDeTir.add(pos2);
				posChampDeTir.add(pos3);
				posChampDeTir.add(pos4);
			}			
		}
	}

}