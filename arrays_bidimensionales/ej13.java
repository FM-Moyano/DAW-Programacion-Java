package arrays_bidimensionales;
/*
 * Realiza un programa que calcule la estatura media, mínima y máxima en
 * centímetros de personas de diferentes países. El array que contiene los
 * nombres de los paises es el siguiente: pais = {“España”, “Rusia”, “Japón”,
 * “Australia”}. Los datos sobre las estaturas se deben simular mediante un
 * array de 4 filas por 10 columnas con números aleatorios generados al azar entre
 * 140 y 210. Los decimales de la media se pueden despreciar. Los nombres de
 * los países se deben mostrar utilizando el array de países (no se pueden escribir directamente).
 */
public class ej13 {
  
  private static final int INICIO = 140;
  private static final int FINAL = 210;
  private static final int FILAS = 4;
  private static final int COLUMNAS = 10;

  public static void main(String[] args) {
    String[] paises = {"España", "Rusia", "Japón", "Australia"};
    int[][] medidas = new int[FILAS][COLUMNAS];
    int[] sumaPais = new int[FILAS];
    int[] maximoPais = new int[FILAS];
    int[] minimoPais = new int[FILAS];
    int maximo = Integer.MIN_VALUE;
    int minimo = Integer.MAX_VALUE;
    
    for( int fila = 0; fila< FILAS;fila++) {
      for(int columna = 0; columna<COLUMNAS; columna++) {
        medidas[fila][columna] = INICIO +(int)(Math.random()*(FINAL-INICIO +1));
        if(medidas[fila][columna] > maximo) {
          maximoPais[fila] = medidas[fila][columna];
        }
        if(medidas[fila][columna] < minimo) {
          minimoPais[fila] = medidas[fila][columna];
        }
        int celda = medidas[fila][columna];
        sumaPais[fila] += celda;
      } 
    }
    System.out.printf("\t".repeat(12)+"| Minimo  "+"Maximo  "+"Media\n");
    
    for(int fila = 0; fila < FILAS; fila++) {
      System.out.printf("%10s: ",paises[fila]);
      for(int columna = 0; columna < COLUMNAS; columna++) {
        System.out.printf("%5d\t", medidas[fila][columna]);
      }
      System.out.printf("| %5d\t", minimoPais[fila]);
      System.out.printf(" %5d\t", maximoPais[fila]);
      System.out.printf("%5d\n",sumaPais[fila]/10);
    }
    

  }

}
