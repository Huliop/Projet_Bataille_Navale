import java.util.Scanner;

public final class PlayerFactory {

  private PlayerFactory() {}

  static public Player createPlayerAskName() {
    System.out.print("Entrez votre nom : ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    return new Player.Builder(input).build();
  }

}