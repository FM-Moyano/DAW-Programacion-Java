package ficheros.dos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ej04RemoveComments {

  public static void main(String[] args) {

    ErrorIfArgsWrong(args);
    
    String fileName = args[0];
    String fileName2 = args[1];
    
    try {
      String file = Files.readString(Paths.get(fileName));
      
      while (file.indexOf("/*") != -1) {
        file = file.substring(0, file.indexOf("/*"))
            + file.substring(file.indexOf("*/")+2);
      }
      
      while (file.indexOf("//") != -1) {
        file = file.substring(0, file.indexOf("//"))
            + file.substring(file.indexOf("\n", file.indexOf("//")));
      }
      
      BufferedWriter file2 = Files.newBufferedWriter(Paths.get(fileName2),
          StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
      
      file2.write(file);
      file2.close();
      System.out.println("Creado archivo: " +fileName2);
      
    } catch (IOException e) {
      System.err.println("No se ha podido abrir el fichero.");
    }

  }
  
  private static void ErrorIfArgsWrong(String[] args) {
    if (args.length != 2) {
      System.err.print("Error! \nSe utilizaría de la siguiente manera:\n"
          + "java QuitaComentarios <PROGRAMA_ORIGINAL> <PROGRAMA_LIMPIO>\n\n"
          + "Por ejemplo:\n"
          + "java QuitaComentarios Hola.java Holav2.java");
      System.exit(1);
    }
  }

}
