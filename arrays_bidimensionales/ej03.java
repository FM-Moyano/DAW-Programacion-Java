package arrays_bidimensionales;

public class ej03 {
  
  private static final int COLUMNAS = 5;
  private static final int FILAS = 4;
  private static final int INICIO = 100;
  private static final int FINAL = 999;

  public static void main(String[] args) {
    int[][] tabla = new int[FILAS][COLUMNAS];
    int[] sumaFilas = new int[FILAS];
    int[] sumaColumnas = new int[COLUMNAS];
    int total = 0;
    
    for (int fila = 0; fila < FILAS;fila++) {
      for(int columna = 0; columna< COLUMNAS; columna++) {
        tabla[fila][columna] = INICIO + (int) (Math.random()*(FINAL-INICIO)+1);
        
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

  }

}
