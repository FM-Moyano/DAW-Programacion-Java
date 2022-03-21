package POO.primera_tanda;

public class Dice {
  private int caras = 6;
  private int caraVisible;
  
  public Dice() {
    roll();
  }
  
  public Dice(int num) {
    caraVisible = num;
  }
  
  public Dice(int num, int caras) {
    caraVisible = num;
    this.caras = caras;
  }
  
  public void roll() {
    caraVisible = (int)(Math.random()*caras)+1;
  }

  
  public int getCaras() {
    return caras;
  }

  public int getCaraVisible() {
    return caraVisible;
  }

  @Override
  public String toString() {
    return "[" + caraVisible + "]";
  }
  
  
}
