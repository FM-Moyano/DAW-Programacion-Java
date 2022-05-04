package ficheros.dos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ej03CountWords {

  public static void main(String[] args) {

    ErrorIfArgsWrong(args);
    
    String fileName = args[0];
    String wordToCount = args[1];
    int counter = 0;
    
    try {
      String file = Files.readString(Paths.get(fileName));
      file = file.toLowerCase();
      wordToCount = wordToCount.toLowerCase();
      
      while (file.indexOf(wordToCount) != -1) {
        file = file.substring(file.indexOf(wordToCount)
            + wordToCount.length(), file.length());
        counter++;
      }
      
      System.out.println("El fichero: " +fileName+ "\nLa palabra: " +wordToCount
          + "\nOcurencias: " +counter);
      
    } catch (IOException e) {
      System.err.println("No se ha podido abrir el fichero.");
    }
  }
  
  private static void ErrorIfArgsWrong(String[] args) {
    if (args.length != 2) {
      System.err.print("Error! El programa necesita el nombre del fichero y la palabra a contar."
          + "\n Ejemplo: Ej03CountWords fichero.txt palabra");
      System.exit(1);
    }
  }

}
