package arrays_bidimensionales;
/*
 * Escribe un programa que pida 20 números enteros. Estos números se deben
 * introducir en un array de 4 filas por 5 columnas. El programa mostrará las
 * sumas parciales de filas y columnas igual que si de una hoja de cálculo se
 * tratara. La suma total debe aparecer en la esquina inferior derecha.
 */

import java.util.Scanner;
public class ej02 {
  
  private static final int COLUMNAS = 5;
  private static final int FILAS = 4;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    int[][] tabla = new int[FILAS][COLUMNAS];
    int[] sumaFilas = new int[FILAS];
    int[] sumaColumnas = new int[COLUMNAS];
    int total = 0;
    
    for (int fila = 0; fila < FILAS;fila++) {
      for(int columna = 0; columna< COLUMNAS; columna++) {
        System.out.print("Introduce un valor: ");
        tabla[fila][columna] = s.nextInt();
        
        // Cáculos
        int celda = tabla[fila][columna];
        sumaFilas[fila] += celda;
        sumaColumnas[columna] += celda;
        total += celda;
      }
    }
    System.out.println();
    
    for(int fila = 0; fila < FILAS; fila++) {
      for(int columna = 0; columna < COLUMNAS; columna++) {
        System.out.printf("%5d\t", tabla[fila][columna]);
      }
      System.out.printf("| %5d\n", sumaFilas[fila]);
    }
    
    String linea = "-".repeat(6);
    for (int columna = 0; columna < COLUMNAS; columna++) {
      System.out.print(linea + "\t");
    }
    System.out.println("| " + linea);
    
    for(int columna = 0; columna <COLUMNAS; columna++) {
      System.out.printf("%5d\t", sumaColumnas[columna]);
    }
    System.out.printf("| %5d\n", total);
    
    s.close();
  }

}
