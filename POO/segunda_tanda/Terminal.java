package POO.segunda_tanda;

public class Terminal {

  private String numero;
  private int conversacion = 0;
  
  public Terminal(String n) {
    numero = n;
  }
  
  public void llama(Terminal t, int c) {
    conversacion += c;
    t.conversacion += c;
  }
  
  @Override
  public String toString() {
    return "Nº " + numero + " - " + conversacion + "s de conversación";
  }
}
