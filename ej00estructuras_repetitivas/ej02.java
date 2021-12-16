package ej00estructuras_repetitivas;
/*
 * Programa que pida números (se pedirá por teclado la cantidad de números a introducir). 
 * El programa debe informar de cuantos números introducidos son mayores que 0, menores que 0 e iguales a 0.
 */
import java.util.Scanner;
public class ej02 {
  
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int mayorQue0 = 0;
    int menorQue0 = 0;
    int igualA0 = 0;
    
    System.out.print("Introduce la cantidad de número que vamos a preguntar: ");
    int cantidad = s.nextInt();
    
    for(int i = 0; i< cantidad; i++) {
      System.out.print("Introduce un número: ");
      int num = s.nextInt();
      if(num == 0) {
        igualA0 += 1;
      }
      else if(num > 0) {
        mayorQue0 += 1;
      }
      else {
        menorQue0 += 1;
      }
    }
    System.out.println("Igual que 0: " + igualA0);
    System.out.println("Mayor que 0: " + mayorQue0);
    System.out.println("Menor que 0: " + menorQue0);
    
    
  s.close();
  }

}
