package POO.colecciones_diccionarios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio6 {
  public static Scanner s = new Scanner(System.in);
  public static void main(String[] args) {


    Map<String, String> usuario = new HashMap<>();

    usuario.put("usuario", "usuario");
    usuario.put("Moyano", "Moyano1234");



    for(int n = 0; n <3; n++) {
      System.out.print("Introduce el usuario: ");
      String user = s.nextLine();
      System.out.print("Introduce la contraseña: ");
      String passwd = s.nextLine();

      if(usuario.containsKey(user) && passwd.equals(usuario.get(user))) {
        System.out.println("Ha accedido al área restringida");
        break;
      }else {
        System.out.println("Usuario o contraseña incorrectos");
        if(n==2) {
          System.out.println("Lo siento, no tiene acceso al área restringida");
        }
      }

    }

  }
}
