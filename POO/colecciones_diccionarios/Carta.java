package POO.colecciones_diccionarios;

import java.util.Objects;

public class Carta {
  private static String[] p = { "bastos", "copas", "espadas","oros" };
  private static int[] n = { 1, 2, 3, 4, 5, 6, 7, 10, 11, 12};

  private String palo;
  private Integer numero;

  public Carta() {
    palo =(p[(int) (Math.random()*p.length)]);
    numero =(n[(int) (Math.random()*n.length)]);
  }

  public String getPalo() {
    return palo;
  }

  public int getNumero() {
    return numero;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numero, palo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Carta other = (Carta) obj;
    return numero == other.numero && Objects.equals(palo, other.palo);
  }

  @Override
  public String toString() {
    if(numero == 10) {
      return "Sota de " + palo;
    }else if(numero == 11) {
      return "Caballo de " + palo;
    }else if(numero == 12) {
      return "Rey de " + palo;

    }
    return numero + " de " + palo;
  }
  
  
  public int compareTo(Carta c) {
    if(palo.equals(c.getPalo())) {
      return numero.compareTo(c.getNumero());
    }else {
      return palo.compareTo(getPalo());
    }
  }


}
