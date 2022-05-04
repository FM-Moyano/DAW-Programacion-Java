package ficheros;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import util.Util;

public class Ejercicio3Tanda2v2 {

  public static void main(String[] args) {

    Util.argumentoVacio(args);
    
    int ocurrencias = 0;
    String palabra = args[1];
    
    try {
      List<String> fichero = Files.readAllLines(Paths.get(args[0]));
      
      for(String f : fichero) {
        if(f.equals(palabra)){
          ocurrencias++;
        }
      }
      System.out.println("El fichero " + args[0] + " tiene " + ocurrencias + " ocurrencias de la palabra " + args[1]);

      
    }catch (Exception e) {
      System.err.print("Error de Lectura/Escritura" + e.getMessage());
      e.printStackTrace();
    }

  }

}
