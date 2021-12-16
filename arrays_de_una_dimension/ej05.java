package arrays_de_una_dimension;
/*
 * Escribe un programa que pida 10 números por teclado y que luego muestre los
números introducidos junto con las palabras “máximo” y “mínimo” al lado del
máximo y del mínimo respectivamente.
 */
import java.util.Scanner;
public class ej05 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int[] num = new int[10];
        
    //Introducir datos
    for(int i=0;i<10;i++) {
      System.out.print("Introduce un número: ");
      num[i] = s.nextInt();
    }
    
    int maximo = Integer.MIN_VALUE;
    int minimo = Integer.MAX_VALUE;
    
    for(int i=0;i<10;i++) {
          
     if(num[i]>maximo) {
       maximo = num[i];
     }
     if(num[i]<minimo) {
       minimo = num[i];
     }
    }
     
     for(int i=0;i<10;i++) {
       if(num[i]==maximo) {
         System.out.println(num[i]+" maximo");
       }
       else if(num[i]==minimo) {
         System.out.println(num[i] + " minimo");
       }
       else {
         System.out.println(num[i]);
       }
     } 
    
    
    
    
    s.close();
  }

}
