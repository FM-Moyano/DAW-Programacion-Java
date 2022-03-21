package POO.colecciones_diccionarios;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class Ejercicio9 {

  public static void main(String[] args) {
    List<Carta> baraja =  new ArrayList<>();

    do {
      Carta carta = new Carta();
      if(!baraja.contains(carta)) {
        baraja.add(carta);
      }
    }while(baraja.size() < 10);


    //Collections.sort(baraja);
    
    for(Carta carta : baraja) {
      System.out.println(carta);
    }
  }

}
