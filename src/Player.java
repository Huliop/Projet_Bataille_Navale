import java.util.ArrayList;
import java.util.List;

public class Player {
	
	// ================================================================================================
	// ATTRIBUTES
	// ================================================================================================
	private String name;
	private boolean hasBeenHit;
	private Grille gameBoard;
	private List<Pion> listPion;
	
	// ================================================================================================
	// CONSTRUCTOR
	// ================================================================================================
	private Player(Builder b) {
		name = b.name;
		this.hasBeenHit = true; // Initialisé à true pour empêcher le déplacement de bateau au 1er tour
		this.gameBoard = new Grille();
		this.listPion = new ArrayList<Pion>();

		Pion croiseur = PionFactory.createCroiseur();
		Pion pav = PionFactory.createPorteAvion();
		Pion torp = PionFactory.createTorpilleur();
		Pion sub = PionFactory.createSousMarin();
		Pion ctrtorp = PionFactory.createContreTorpilleur();

		this.listPion.add(croiseur);
		this.listPion.add(pav);
		this.listPion.add(torp);
		this.listPion.add(sub);
		this.listPion.add(ctrtorp);
	}

	public static class Builder {

		private String name;

		public Builder(String name) {
			this.name = name;
		}

		public Player build() {
			return new Player(this);
		}

	}

	// ================================================================================================
	// PRIVATE FUNCTIONS
	// ================================================================================================
	private Boolean canShoot(Position p) {
		for(Pion pion: listPion) {
			if(pion.canShoot(p)) return true;
		}

		return false;
	}

	private void updateGameBoard() {
		gameBoard.update(listPion);
	}

	private boolean hit(List<Pion> adversaireList, Position pos) {
		for(Pion pion : adversaireList) {
			for(Position p: pion.getPositions()) {
				if(
					p.getLine() == pos.getLine() &&
					p.getRow() == pos.getRow()
				) {
					if(pion.looseLife()) {
						adversaireList.remove(pion);
						System.out.println("Touché, coulé !");
					}
					else System.out.println("Touché !");
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean shoot(Position pos, List<Pion> adversaireList) {
		for(Pion p : this.listPion) {
			if(p.canShoot(pos)) {
				if(hit(adversaireList, pos)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	private void moveBoat() {
		System.out.println("Vous n'avez pas été touché, vous avez le droit de déplacer un bateau !");
		System.out.print("Veuillez sélectionner un bateau parmi les suivants : ");

		for(int i = 0; i < listPion.size(); i++) {
			System.out.print(i+" "+listPion.get(i).getName()+((i < listPion.size() - 1) ? ", " : "."));
		}

		System.out.println("");

		int boatNumber = 0;
		Boolean boatError = true;
		while(boatError) {
			System.out.print("Bateau numéro : ");
			boatNumber = UserInput.IntegerInput();

			if(
				boatNumber < 0 ||
				boatNumber >= listPion.size()
			) {
				System.out.println("Numéro incorrect, veuillez recommencer.");
			}
			else boatError = false;
		}

		System.out.println("Bateau sélectionné : "+boatNumber);

		// TODO: bouger le bateau
	}

	// ================================================================================================
	// PUBLIC FUNCTIONS
	// ================================================================================================
	public String getName() {
		return this.name;
	}

	public void placePions() {
		System.out.println("");
		System.out.println(this.getName()+", veuillez placer vos bateaux.");

		for(Pion p: listPion) {
			Boolean bateauError = true;

			System.out.println(this.gameBoard);
			
			while(bateauError) {
				System.out.println(this.getName()+", où voulez-vous placer le "+p.getName()+" ?");
				Position boatPosition = UserInput.PositionInput();
				Integer x = boatPosition.getLine();
				Integer y = boatPosition.getRow();

				System.out.print("Orientation (h pour horizontal, v pour vertical) : ");
				ArrayList<String> authorized = new ArrayList<String>();
				authorized.add("h");
				authorized.add("v");
				String orientation = UserInput.VerifiedInput(authorized);
				
				if(orientation.contains("h")) {
					p.placeHorizontalPion(x, y, Grille.getSize());
				}
				else {
					p.placeVerticalPion(x, y, Grille.getSize());
				}

				if(this.gameBoard.addBoat(p)) {
					bateauError = false;
				}
				else {
					System.out.println("Impossible de placer le bateau ici, veuillez recommencer.");
				}
			}
		}

		System.out.println("Super, voici la position de vos bateaux :");
		System.out.println(this.gameBoard);
	}

	/**
	 * @return true si le joueur a gagné, false sinon
	 */
	public Boolean turn(Player adversaire) {
		if(!this.hasBeenHit) {
			System.out.println(gameBoard);
			moveBoat();
		}
		this.hasBeenHit = false;

		System.out.println(gameBoard);

		Position shootPosition = new Position(0, 0);
		Boolean shootError = true;
		while(shootError) {
			System.out.println(this.getName()+", où voulez-vous tirer ?");
			shootPosition = UserInput.PositionInput();

			if(canShoot(shootPosition)) shootError = false;
			else System.out.println("Impossible de tirer ici, veuillez saisir une position correcte.");
		}
		
		if(shoot(shootPosition, adversaire.listPion)) {
			adversaire.hasBeenHit = true;
			adversaire.updateGameBoard();
		}
		else {
			System.out.println("Raté ...");
		}

		return(adversaire.listPion.size() == 0);
	}

}
