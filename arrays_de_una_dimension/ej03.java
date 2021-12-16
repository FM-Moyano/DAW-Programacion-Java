package arrays_de_una_dimension;
/*
 *Programa que lea 10 números por teclado y que luego los muestre
 *en orden inverso, es decir, el primero que se introduce es el último en mostrarse
 *y viceversa.
 */
import java.util.Scanner;
public class ej03 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    int[] num = new int[10];
    
    //Introducir datos
    for(int i=0;i<10;i++) {
      System.out.print("Introduce un número: ");
      num[i] = s.nextInt();
    }
    
    // Impresión
    for(int i=9;i>=0;i--) {
      System.out.println("Número "+(i+1)+": "+num[i]);
    }
    
    s.close();
  }

}
