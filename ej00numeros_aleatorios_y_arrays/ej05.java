package ej00numeros_aleatorios_y_arrays;

import java.util.Arrays;

/*
 * Muestra 50 números enteros aleatorios entre 100 y 199 (ambos incluidos)
 * separados por espacios. Muestra también el máximo, el mínimo, la moda,
 * la media, la mediana y la desviación típica de esos números.
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
      
      System.out.println("Número "+i+": "+num);
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
    // Imprimimos el máximo, el mínimo y la media
    System.out.println("Máximo: "+maximo);
    System.out.println("Mínimo: "+minimo);
    System.out.println("Media: "+(double) suma/TOTAL_NUMEROS);
    
    // Cáculo de la mediana e impresión
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
   
    // Cáculo de la moda
    int maximaFrecuencia = Integer.MIN_VALUE;
    for (int moda: frecuencia) {
      if(moda > maximaFrecuencia) {
        maximaFrecuencia = moda;
      } 
    }
    // Imprimir todos números que tengan el valor de moda 
    System.out.print("Moda(s): ");
    for(int n = INICIO; n <= FINAL;n++) {
      if (frecuencia[n - INICIO] == maximaFrecuencia) {
        System.out.print( n + " ");
      }
    }
    System.out.println("(" + maximaFrecuencia + " veces)");
    
    // Desviación tipica 
    suma = 0;
    for (int n: numeros) {
      suma += Math.pow(n - mediana, 2);
    }
    double desviacion = Math.sqrt(suma / TOTAL_NUMEROS);
    System.out.println("Desviación típica: " + desviacion);
  }

}
