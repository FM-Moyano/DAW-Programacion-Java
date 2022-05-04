package ficheros.dos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Ej02MixFiles {

  public static void main(String[] args) {
    
    ErrorIfArgsWrong(args);
    
    String fileName1 = args[0];
    String fileName2 = args[1];
    String mixFileName = args[2];
    
    try {
      List<String> file1 = Files.readAllLines(Paths.get(fileName1));
      List<String> file2 = Files.readAllLines(Paths.get(fileName2));
      
      BufferedWriter mixFile = Files.newBufferedWriter(Paths.get(mixFileName),
          StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
      
      for (Object line: mixFiles(file1, file2)) {
        mixFile.write(line + "");
        mixFile.newLine();
      }
      mixFile.close();
      System.out.println("Archivo " + mixFileName + " creado");
      
    } catch (IOException e) {
      System.err.print("Error de Lectura/Escritura");
      e.printStackTrace();
    }

  }
  
  private static void ErrorIfArgsWrong(String[] args) {
    if (args.length != 3) {
      System.err.print("Error! El programa necesita nombres de los ficheros."
          + "\n Ejemplo: Ej02MixFiles fichero1.txt fichero2.txt ficheroMezclado.txt");
      System.exit(1);
    }
  }
  
  private static Object[] mixFiles(List<String> file1, List<String> file2) {
    Object[] a = file1.toArray();
    Object[] b = file2.toArray();
    
    Object[] mixFile = new Object[a.length + b.length];
    
    int colocadosDeA = 0;
    int colocadosDeB = 0;
    int i = 0;
    
    do {
      if (colocadosDeA < a.length) {
      mixFile[i++] = a[colocadosDeA++];
      }
      if (colocadosDeB < b.length) {
      mixFile[i++] = b[colocadosDeB++];
      }
    } while (i < a.length + b.length);
    
    return mixFile;
  }

}
