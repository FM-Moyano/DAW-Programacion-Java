package POO.primera_tanda;

public class Dado {
  
  int cara;
  
  public Dado() {
    lanzar();
  }
  
  public int getCara() {
    return cara;
  }
 
  public void lanzar(){
    cara = (int)(Math.random()*6)+1; 
  }
}
