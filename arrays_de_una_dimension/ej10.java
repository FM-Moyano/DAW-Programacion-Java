package arrays_de_una_dimension;

import java.util.Arrays;

/*
 * Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100
 * y que los almacene en un array. El programa debe ser capaz de pasar todos
 * los números pares a las primeras posiciones del array (del 0 en adelante) y
 * todos los números impares a las celdas restantes. Utiliza arrays auxiliares si es necesario.
 */
public class ej10 {
  
  private static final int TOTAL_NUMEROS = 20;
  private static final int INICIO = 0;
  private static final int FINAL = 100;

  public static void main(String[] args) {
    
    int[] numeros = new int[TOTAL_NUMEROS];
    for(int i = 0; i<TOTAL_NUMEROS;i++) {
      numeros[i] = INICIO + (int) (Math.random()*(FINAL-INICIO+1));
    }
    
    System.out.println("Array original: " + Arrays.toString(numeros));
    
    int[] pares = new int[TOTAL_NUMEROS];
    int[] impares = new int[TOTAL_NUMEROS];
    int totalPares = 0;
    int totalImpares = 0;
    
    for (int numero: numeros) {
      // Comprobación par o inpar
      if(numero%2 == 0) {
        pares[totalPares] = numero;
        totalPares++;
      }else {
        impares[totalImpares] = numero;
        totalImpares++;
      }
    }
    
    // Pasar pares a la primeras posiciones
    for(int i = 0; i < totalPares; i++) {
      numeros[i] = pares[i];
    }
    
    for(int i = 0; i< totalImpares; i++) {
      numeros[totalPares+i] = impares[i];
    }
    System.out.println("Array procesado: " + Arrays.toString(numeros));

  }

}
