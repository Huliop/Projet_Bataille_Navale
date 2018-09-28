public final class PionFactory {

  private PionFactory() {}

  static public Pion createContreTorpilleur() {
    return new PionChampLateral
    .Builder()
    .addName("Contre torpilleur")
    .addSize(3)
    .addShootingRange(2)
    .build();
  }

  static public Pion createCroiseur() {
    return new PionChampFrontal
    .Builder()
    .addName("Croiseur")
    .addSize(4)
    .addShootingRange(2)
    .build();
  }

  static public Pion createPorteAvion() {
    return new PionChampLateral
    .Builder()
    .addName("Porte-avion")
    .addSize(5)
    .addShootingRange(2)
    .build();
  }

  static public Pion createSousMarin() {
    return new PionChampFrontal
    .Builder()
    .addName("Sous-marin")
    .addSize(3)
    .addShootingRange(4)
    .build();
  }

  static public Pion createTorpilleur() {
    return new PionChampFrontal
    .Builder()
    .addName("Torpilleur")
    .addSize(2)
    .addShootingRange(5)
    .build();
  }

  static public Pion createDefault() {
    return new PionChampFrontal
    .Builder()
    .addName("Default")
    .addSize(2)
    .addShootingRange(2)
    .build();
  }

}