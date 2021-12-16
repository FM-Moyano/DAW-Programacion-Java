package arrays_bidimensionales;
/*
 * Realiza un programa que rellene un array de 6 filas por 10 columnas con
 * n�meros enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A
 * continuaci�n, el programa deber� dar la posici�n tanto del m�ximo como del m�nimo.
 */
public class ej05 {

  private static final int COLUMNAS = 10;
  private static final int FILAS = 6;
  private static final int INICIO = 100;
  private static final int FINAL = 999;
  
  public static void main(String[] args) {
    int [][] tabla = new int[FILAS][COLUMNAS];
    int maximo = Integer.MIN_VALUE;
    int minimo = Integer.MAX_VALUE;
    int filaMaximo = 0;
    int columnaMaximo = 0;
    int filaMinimo = 0;
    int columnaMinimo = 0;
    
    
    for(int fila = 0; fila< FILAS; fila++) {
      for(int columna = 0; columna < COLUMNAS; columna++) {
        tabla[fila][columna] = INICIO + (int) (Math.random()*(FINAL-INICIO+1));
        if(tabla[fila][columna] > maximo) {
          maximo = tabla[fila][columna];
          filaMaximo = fila;
          columnaMaximo = columna;
        }
        if(tabla[fila][columna] <  minimo) {
          minimo = tabla[fila][columna];
          filaMinimo = fila;
          columnaMinimo = columna;
        }
      }
    }
    System.out.println("El n�mero m�ximo es "+ maximo+ " y est� en la posicion ["+filaMaximo + ","+columnaMaximo+"]");
    System.out.println("El n�mero m�nimo es "+ minimo+ " y est� en la posicion ["+filaMinimo + ","+columnaMinimo+"]");
    

  }

}
