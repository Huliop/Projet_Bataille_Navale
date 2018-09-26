
public class Case {

  private Boolean isWater;
  private Boolean isBoat;
  private char letter;
	
	private Case(Builder b) {
    this.isWater = b.isWater;
    this.isBoat = b.isBoat;
    this.letter = b.letter;
  }
	
  public static class Builder {

    private Boolean isWater;
    private Boolean isBoat;
    private char letter;

    public Builder() {}

    public Builder water() {
      this.isWater = true;
      this.isBoat = false;
      this.letter = '~';

      return this;
    }

    public Builder boat(char letter) {
      this.isWater = false;
      this.isBoat = true;
      this.letter = letter;

      return this;
    }

    public Case build() {
      return new Case(this);
    }

  }

  public Boolean isWater() {
    return isWater;
  }

  public Boolean isBoat() {
    return isBoat;
  }

  public char getLetter() {
    return letter;
  }

  public void setWater() {
    this.isWater = true;
    this.isBoat = false;
    this.letter = '~';
  }

  public void setBoat(char letter) {
    this.isWater = false;
    this.isBoat = true;
    this.letter = letter;
  }

}
