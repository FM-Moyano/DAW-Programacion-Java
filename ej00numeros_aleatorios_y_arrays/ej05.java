package ej00numeros_aleatorios_y_arrays;

import java.util.Arrays;

/*
 * Muestra 50 n�meros enteros aleatorios entre 100 y 199 (ambos incluidos)
 * separados por espacios. Muestra tambi�n el m�ximo, el m�nimo, la moda,
 * la media, la mediana y la desviaci�n t�pica de esos n�meros.
 */
public class ej05 {
  
  private static final int TOTAL_NUMEROS = 50;
  private static final int INICIO = 100;
  private static final int FINAL = 199;

  public static void main(String[] args) {
    int maximo = INICIO;
    int minimo = FINAL;
    int[] numeros = new int[TOTAL_NUMEROS];
    int[] frecuencia = new int[FINAL - INICIO +1];
    int suma = 0;
    
    
    for(int i=0; i<TOTAL_NUMEROS;i++) {
      int num = INICIO +(int) (Math.random()*(FINAL-INICIO+1));
      
      System.out.println("N�mero "+i+": "+num);
      if(num < minimo) {
        minimo = num;
      }
      if (num > maximo) {
        maximo = num;
      }
      ++frecuencia[num-INICIO];
      suma += num;
      numeros[i] = num;
    }
    // Imprimimos el m�ximo, el m�nimo y la media
    System.out.println("M�ximo: "+maximo);
    System.out.println("M�nimo: "+minimo);
    System.out.println("Media: "+(double) suma/TOTAL_NUMEROS);
    
    // C�culo de la mediana e impresi�n
    Arrays.sort(numeros);
    
    double mediana;
    if(numeros.length % 2 == 0) {
      int n1 = numeros[TOTAL_NUMEROS/2 - 1];
      int n2 = numeros[TOTAL_NUMEROS/2];
      mediana = (double) (n1+n2)/2;
    }else {
      mediana = numeros[TOTAL_NUMEROS/2];
    }
    
    System.out.println("Mediana: " + mediana);
   
    // C�culo de la moda
    int maximaFrecuencia = Integer.MIN_VALUE;
    for (int moda: frecuencia) {
      if(moda > maximaFrecuencia) {
        maximaFrecuencia = moda;
      } 
    }
    // Imprimir todos n�meros que tengan el valor de moda 
    System.out.print("Moda(s): ");
    for(int n = INICIO; n <= FINAL;n++) {
      if (frecuencia[n - INICIO] == maximaFrecuencia) {
        System.out.print( n + " ");
      }
    }
    System.out.println("(" + maximaFrecuencia + " veces)");
    
    // Desviaci�n tipica 
    suma = 0;
    for (int n: numeros) {
      suma += Math.pow(n - mediana, 2);
    }
    double desviacion = Math.sqrt(suma / TOTAL_NUMEROS);
    System.out.println("Desviaci�n t�pica: " + desviacion);
  }

}
