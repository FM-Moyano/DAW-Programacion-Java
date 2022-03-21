package POO.colecciones_diccionarios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio16 {
  public static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {

    Map<String,String> ciudad = new HashMap<>();

    ciudad.put("ESPA�A", "MADRID");
    ciudad.put("PORTUGAL","LISBOA");
    ciudad.put("FRANCIA", "PARIS");
    
    for(;;) {
      System.out.print("Escribe el nombre de un pa�s y te dir� su capital: ");
      String paisCandidato = s.nextLine().toUpperCase();
      
      if(paisCandidato.equals("SALIR")) {
        break;
      }else if(ciudad.containsKey(paisCandidato)) {
        System.out.println("La capital de " + paisCandidato + " es " + ciudad.get(paisCandidato));
      }else {
        System.out.print("no conozco la respuesta �C�al es la capital de "+paisCandidato + "?: ");
        String capital = s.next().toUpperCase();
        System.out.println("Gracias por ense�arme nuevas capitales.");
        ciudad.put(paisCandidato.toUpperCase(), capital.toUpperCase());
      }
      
    }
  }

}
