package arrays_de_una_dimension;
/*
 *Programa que lea 10 n�meros por teclado y que luego los muestre
 *en orden inverso, es decir, el primero que se introduce es el �ltimo en mostrarse
 *y viceversa.
 */
import java.util.Scanner;
public class ej03 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    int[] num = new int[10];
    
    //Introducir datos
    for(int i=0;i<10;i++) {
      System.out.print("Introduce un n�mero: ");
      num[i] = s.nextInt();
    }
    
    // Impresi�n
    for(int i=9;i>=0;i--) {
      System.out.println("N�mero "+(i+1)+": "+num[i]);
    }
    
    s.close();
  }

}
