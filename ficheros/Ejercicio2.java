package ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("primos.txt"));

      String linea;
      while((linea=br.readLine()) != null)
        System.out.println(linea);

      br.close();

    }catch (IOException e) {
      System.err.println("Error de lectura");
    }
  }

}
