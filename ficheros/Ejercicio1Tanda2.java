package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Util;

/*
 * Realiza un programa que sea capaz de ordenar alfabéticamente
 * las palabras contenidas en un fichero de texto.
 * El nombre del fichero que contiene las palabras 
 * se debe pasar como argumento en la línea de comandos. 
 * El nombre del fichero resultado debe ser el mismo
 * que el original añadiendo la coletilla sort,
 * por ejemplo palabras_sort.txt .
 * Suponemos que cada palabra ocupa una línea.
 */

public class Ejercicio1Tanda2 {
  
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    Util.argumentoVacio(args);
    
    String ficheroNombre = args[0];
    
    //Ordenamos el fichero
    List<String> ficheroOrdenar = Files.readAllLines(Paths.get(ficheroNombre));
    List<String> contenidoOrdenado = new ArrayList<String>();
    contenidoOrdenado.addAll(ficheroOrdenar);
    Collections.sort(contenidoOrdenado);// con el metodo sort ordenamos el fichero
    
    //creamos el nombre del fichero
    String ficheroNombreCambiado = ficheroNombre.substring(0,ficheroNombre.lastIndexOf(" .")) + "_sort" +
    ficheroNombre.substring(ficheroNombre.lastIndexOf("."));
     
    // Creamosel fichero nuevo con el nombre anteriomente ya creado y escribimos el contenido ya ordenado
    try (var archivoOrdenado = new BufferedWriter(new FileWriter(ficheroNombreCambiado, true))) {
      for(int i = 0; i < contenidoOrdenado.size(); i ++) {
        archivoOrdenado.write(contenidoOrdenado.get(i) + "");
        archivoOrdenado.newLine();
      }
      System.out.println("Fichero ordenado");
    } catch (IOException e) {
      System.out.println("No se ha podido escribir en el fichero");
    }
    
    System.out.println("Fichero sin ordenar");
    
    try {
      BufferedReader br = new BufferedReader(new FileReader(ficheroNombre));

      String linea;
      while((linea=br.readLine()) != null)
        System.out.println(linea);

      br.close();

    }catch (IOException e) {
      System.err.println("Error de lectura");
    }
    
    System.out.println("-------------------------");
    System.out.println("Fichero Ordenado");
    System.out.println();
    
    try {
      BufferedReader br = new BufferedReader(new FileReader(ficheroNombreCambiado));

      String linea;
      while((linea=br.readLine()) != null)
        System.out.println(linea);

      br.close();

    }catch (IOException e) {
      System.err.println("Error de lectura");
    }
    
  }

}
