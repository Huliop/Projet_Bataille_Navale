public abstract class PionChampFrontal extends Pion {

	@Override
	protected abstract void initPos();

	@Override
	protected void setPosChampDeTir(int champ) {
		Position pos = new Position(0,0);
		Position t1 = this.pos.get(0);
		Position t2 = this.pos.get(1);
		int x1 = t1.getPosX();
		int y1 = t1.getPosY();
		int x2 = t2.getPosX();
		int y2 = t2.getPosY();
		
		// S'ils sont sur la même ligne
		if (x1 - x2  == 0) {
			// Alors c'est vers la droite
			if (((y1 - y2)%10 +10)%10 == 1) {
				// On ajoute au champ de tir les (champ) cases de devant vers la droite
				for (int i = 1; i < champ + 1; i++) {
					pos = new Position(x1, ((y1+i)%10 + 10)%10);
					posChampDeTir.add(pos);
				}
			}
			// Sinon c'est vers la gauche
			else {
				// On ajoute au champ de tir les (champ) cases de devant vers la gauche
				for (int i = 1; i < champ + 1; i++) {
					pos = new Position(x1, ((y1-i)%10 + 10)%10);
					posChampDeTir.add(pos);
				}
			}			
		}
		// S'ils sont sur la même colonne
		else {
			// Alors c'est vers le bas
			if (((x1 - x2)%10 +10)%10 == 1) {
				// On ajoute au champ de tir les (champ) cases de devant vers le bas
				for (int i = 1; i < champ + 1; i++) {
					pos = new Position(((x1+i)%10 + 10)%10, y1);
					posChampDeTir.add(pos);
				}
			}
			// Sinon c'est vers le haut
			else {
				// On ajoute au champ de tir les (champ) cases de devant vers le haut
				for (int i = 1; i < champ + 1; i++) {
					pos = new Position(((x1-i)%10 + 10)%10, y1);
					posChampDeTir.add(pos);
				}
			}		
		}
	}

}
