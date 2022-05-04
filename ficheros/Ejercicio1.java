package ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import util.Util;

public class Ejercicio1 {

  public static void main(String[] args) {
    
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("primos.txt"));
      
      for (int i = 1; i <= 500; i++) {
        if(Util.esPrimo(i)) {
          bw.write(i + "\n");
        }
      }
      bw.close();
      
    }catch(IOException e) {
      System.err.println("Error de escritura");
    }
   
    
  }

}
