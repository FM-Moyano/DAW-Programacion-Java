package POO.colecciones_diccionarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ejercicio11v2 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int respuestasValidas = 0;

    HashMap<String, String> diccionario = new HashMap<>();

    diccionario.put("raton", "mouse");
    diccionario.put("teclado", "keyboard");
    diccionario.put("llaves", "keys");
    diccionario.put("guitarra", "guitar");
    diccionario.put("pantalones", "pants");
    diccionario.put("camiseta", "T shirt");
    diccionario.put("cama", "bed");
    diccionario.put("puerta", "door");
    diccionario.put("mascarilla", "face mask");
    diccionario.put("ordenador", "computer");
    diccionario.put("ventana", "window");
    diccionario.put("platos", "plates");
    diccionario.put("altavoz", "speaker");
    diccionario.put("auriculares", "headphones");
    diccionario.put("telefono", "phone");
    diccionario.put("lampara", "lamp");
    diccionario.put("gymnasio", "gym");
    diccionario.put("mancuernas", "dumbbells");
    diccionario.put("pantalla", "screen");
    diccionario.put("perro", "dog");

    //Creamos una lista con 5 números aleatorios para las claves del diccionario.
    List<Integer> key = new ArrayList<>();

    for(int i =0; i < 5; i++) {
      key.add((int)(Math.random()*20));
    }

    //Array con las claves del diccioonario 
    String[] arrayDiccionario = diccionario.keySet().toArray(new String[0]);


    for(int i =0; i <5; i++) {
      System.out.print("Español: "+arrayDiccionario[key.get(i)] + " Ingles : ");
      String traduccion = s.nextLine();

      if(traduccion.equals(diccionario.get(arrayDiccionario[key.get(i)]))) {
        respuestasValidas++;
      }
    }

    System.out.println("Has tenído "+ respuestasValidas + " respuestas correctas y "+ (5-respuestasValidas) + " respuestas incorrectas");

    s.close();
  }

}
