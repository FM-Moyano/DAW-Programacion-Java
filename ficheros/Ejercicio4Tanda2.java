package ficheros;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import util.Util;

public class Ejercicio4Tanda2 {

  public static void main(String[] args) {

    Util.argumentoVacio(args);

    
    try {
      
      String fichero1 = Files.readString(Paths.get(args[0]));
      
      

      while (fichero1.indexOf("/*") != -1) {
        fichero1 = fichero1.substring(0, fichero1.indexOf("/*"))
            + fichero1.substring(fichero1.indexOf("*/")+2);
      }
      
      while (fichero1.indexOf("//") != -1) {
        fichero1 = fichero1.substring(0, fichero1.indexOf("//"))
            + fichero1.substring(fichero1.indexOf("\n", fichero1.indexOf("//")));
      }
      
      BufferedWriter fichero2 = Files.newBufferedWriter(Paths.get(args[1]),
          StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);      
      
      fichero2.write(fichero1);
      fichero2.close();
      
    }catch (Exception e) {
      System.err.print("Error de Lectura/Escritura" + e.getMessage());
      e.printStackTrace();    }
  }

}
