package POO.colecciones_diccionarios;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio10 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    HashMap<String, String> m = new HashMap<>();
    
    m.put("raton", "mouse");
    m.put("teclado", "keyboard");
    m.put("llaves", "keys");
    m.put("guitarra", "guitar");
    m.put("pantalones", "pants");
    m.put("camiseta", "T shirt");
    m.put("cama", "bed");
    m.put("puerta", "door");
    m.put("mascarilla", "face mask");
    m.put("ordenador", "computer");
    m.put("ventana", "window");
    m.put("platos", "plates");
    m.put("altavoz", "speaker");
    m.put("auriculares", "headphones");
    m.put("telefono", "phone");
    m.put("lampara", "lamp");
    m.put("gymnasio", "gym");
    m.put("mancuernas", "dumbbells");
    m.put("pantalla", "screen");
    m.put("perro", "dog");

    
    System.out.print("Introduce una palabar en español, para traducir: ");
    String palabra = s.nextLine();
  
    if(m.containsKey(palabra)) {
      System.out.println("Español: " + palabra + " Ingés: "+ m.get(palabra) );
    }else {
      System.out.println("La plabra introducida no está en el diccionario");
    }
  
  s.close();
  }

}
