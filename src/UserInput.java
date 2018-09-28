import java.util.ArrayList;
import java.util.Scanner;

public final class UserInput {

  private UserInput() {}

  static public Integer IntegerInput() {
    Boolean inputError = true;
    Integer input = 0;

    while(inputError == true) {
      try {
        Scanner scanner = new Scanner(System.in);
        input = Integer.parseInt(scanner.nextLine());
        inputError = false;
      } catch (Exception e) {
        System.out.print("Erreur, veuillez saisir un nombre : ");
      }
    }

    return input;
  }

  static public Position PositionInput() {
    System.out.print("Ligne : ");
    int ligne = IntegerInput();
    System.out.print("Colonne : ");
    int colonne = IntegerInput();

    return new Position(ligne, colonne);
  }

  static public String VerifiedInput(ArrayList<String> values) {
    Boolean inputError = true;
    String input = "";

	while(inputError == true) {
	  Scanner scanner = new Scanner(System.in);
	  input = scanner.nextLine();
	
	  if(values.contains(input)) {
	    inputError = false;
	  }
	  else {
	    System.out.print("Erreur, veuillez saisir une valeur autorisée : ");
	      }
	    }

	return input;
  }

	public static void endTurn() {
		System.out.print("Veuillez entrez une touche pour continuer");
	    String input = "";
	
	    while (input == "") {
	    	Scanner scanner = new Scanner(System.in);
	    	input = scanner.nextLine();
	    }
	}

}