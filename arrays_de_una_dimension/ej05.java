package arrays_de_una_dimension;
/*
 * Escribe un programa que pida 10 n�meros por teclado y que luego muestre los
n�meros introducidos junto con las palabras �m�ximo� y �m�nimo� al lado del
m�ximo y del m�nimo respectivamente.
 */
import java.util.Scanner;
public class ej05 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int[] num = new int[10];
        
    //Introducir datos
    for(int i=0;i<10;i++) {
      System.out.print("Introduce un n�mero: ");
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
