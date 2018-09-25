import java.util.Scanner;

public final class PlayerFactory {

  private PlayerFactory() {}

  static public Player createPlayerAskName() {
    System.out.print("Enter your name: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    scanner.close();

    return new Player.Builder(input).build();
  }

}
