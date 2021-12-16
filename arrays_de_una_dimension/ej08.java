package arrays_de_una_dimension;
/*
 * Realiza un programa que pida la temperatura media que ha hecho en cada mes
 * de un determinado año y que muestre a continuación un diagrama de barras
 * horizontales con esos datos. Las barras del diagrama se pueden dibujar a base
 * de asteriscos o cualquier otro carácter.
 */
import java.util.Scanner;
public class ej08 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int[] meses = new int[12];
    
    
    for(int i = 0; i<meses.length;i++) {
      System.out.print("Introduce la temperatura media del mes "+ (i+1) + ": ");
      meses[i] = s.nextInt();
    }
    
    System.out.println();
    System.out.println("--------------------Diagrama-----------------------------");
    System.out.println();
    
    for(int i = 0; i<meses.length;i++) {
      System.out.println("Mes "+ (i+1) + ": " + "*".repeat(meses[i]));
    }
    
    s.close();
  }

}
