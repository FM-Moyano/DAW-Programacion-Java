package POO.colecciones_diccionarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio12 {

  public static void main(String[] args) {
    List<Carta> baraja = new ArrayList<>();
    
    do {
      Carta carta = new Carta();
      if(!baraja.contains(carta)) {
       baraja.add(carta); 
      }
    }while(baraja.size() < 6);
  
  
    Map<Integer,Integer> puntos = new HashMap<>();
    puntos.put(1, 11);
    puntos.put(3,10);
    puntos.put(10, 2);
    puntos.put(11, 3);
    puntos.put(12, 4);
    
    int puntuacion = 0;
    
    for(Carta carta : baraja) {
      System.out.println(carta);
      if(puntos.containsKey(carta.getNumero())) {
       puntuacion += puntos.get(carta.getNumero()); 
      }
    }
    System.out.println(puntuacion + " Puntos.");
  }

}
