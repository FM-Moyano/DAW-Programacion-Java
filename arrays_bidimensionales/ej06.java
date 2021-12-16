package arrays_bidimensionales;
/*
 * Modifica el programa anterior de tal forma que no se repita ning�n n�mero en el array
 */

public class ej06 {
  private static final int MAX_NUMBER = 1000;
  private static final int COLUMNAS = 10;
  private static final int FILAS = 6;

  public static void main(String[] args) {
 // Generaci�n de n�meros
    int tabla[][] = new int [FILAS][COLUMNAS];
    for(int fila = 0; fila < FILAS; fila++) {
      for(int columna = 0; columna < COLUMNAS; columna++) {
        // Correcci�n
        int aleatorio;
        boolean yaGenerado;
        do {
          aleatorio = (int) ( Math.random()*(MAX_NUMBER+1));
          // Comprobamos si se ha generado
          yaGenerado = false;
          // Miramos filas anteriores
          for (int f=0; f < fila && !yaGenerado; f++) {
            for(int c = 0; c < COLUMNAS && !yaGenerado; c++) {
              if(aleatorio == tabla[f][c]) {
                yaGenerado = true;
              }
            }
          }
          // Buscamos en la fila actual
          for(int c = 0; c < columna && !yaGenerado; c++) {
            if(aleatorio == tabla[fila][c]) {
              yaGenerado = true;
            }
          }
        } while (yaGenerado);


        tabla[fila][columna] = aleatorio;
      }
    }

    // Impresi�n de tabla    
    for(int[] filas: tabla) {
      for(int columnas: filas) {
        System.out.print(columnas + "\t");
      }
      System.out.println();
    }

    // Extracci�n de n�mero m�ximo
    int max = tabla[0][0];
    for(int[] filas: tabla) {
      for(int columnas: filas) {
        if(columnas > max) {
          max = columnas;
        }
      }
    }

    // Extracci�n n�mero m�nimo
    int min = tabla[0][0];
    for(int[] filas: tabla) {
      for(int columnas: filas) {
        if (columnas<min) {
          min = columnas;
        }
      }
    }

    System.out.println("N�mero m�ximo: " + max);
    System.out.println("N�mero m�nimo: " + min);

  }
 

}
