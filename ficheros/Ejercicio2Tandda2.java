package ficheros;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import util.Util;

public class Ejercicio2Tandda2 {

  public static void main(String[] args) {

    Util.argumentoVacio(args);

    try {
      List<String> fichero1 = Files.readAllLines(Paths.get(args[0]));
      List<String> fichero2 = Files.readAllLines(Paths.get(args[1]));

      BufferedWriter ficheroUnico = Files.newBufferedWriter(Paths.get(args[2]),
          StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

      //Mezclar las líneas de ambos ficheros hasta la longitud del más corto
      int numeroDeLineasMenor = Math.min(fichero1.size(), fichero2.size());

      for(int i=0; i< numeroDeLineasMenor; i++) {
        ficheroUnico.append(fichero1.get(i));
        ficheroUnico.newLine();
        ficheroUnico.append(fichero2.get(i));
        ficheroUnico.newLine();
      }

      //Añadir las lineas del fichero con la longitud más larga
      List<String> ficheroMasLargo = (fichero1.size() < fichero2.size()) ? fichero2 : fichero1;

      for(int i = numeroDeLineasMenor; i < ficheroMasLargo.size()-1; i++) {
        ficheroUnico.append(ficheroMasLargo.get(i));
        ficheroUnico.newLine();
      }
      ficheroUnico.append(ficheroMasLargo.get(ficheroMasLargo.size()-1));


      ficheroUnico.close();

    }catch (IOException e) {
      System.err.print("Error de Lectura/Escritura" + e.getMessage());
      e.printStackTrace();
    }

  }

}
