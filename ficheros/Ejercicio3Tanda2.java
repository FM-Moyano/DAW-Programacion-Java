package ficheros;

import java.nio.file.Files;
import java.nio.file.Paths;
import util.Util;

public class Ejercicio3Tanda2 {

  public static void main(String[] args) {

    Util.argumentoVacio(args);

    try {
      
      String fichero = Files.readString(Paths.get(args[0]));
      String palabra = args[1];
      int ocurrencias = 0;
      
      while(fichero.indexOf(palabra) != -1) {
        fichero = fichero.substring(fichero.indexOf(palabra) + palabra.length(), fichero.length());
        ocurrencias++;
      }
      
      System.out.println("El fichero " + args[0] + " tiene " + ocurrencias + " ocurrencias de la palabra " + args[1]);
     
      

    }catch (Exception e) {
      System.err.print("Error de Lectura/Escritura" + e.getMessage());
      e.printStackTrace();
    }

  }

}
