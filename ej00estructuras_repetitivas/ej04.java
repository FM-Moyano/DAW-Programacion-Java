package ej00estructuras_repetitivas;
/*
 * Programa que imprime todos los n�meros pares entre dos n�meros que se le pidan al usuario.
 */

import java.util.Scanner;
public class ej04 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Programa que pide dos numeros y muestra los n�meros pares entre esos dos n�meros ");
    
    System.out.print("Introduce el primer n�mero: ");
    int num1 = s.nextInt();
    System.out.print("Introduce el segundo n�mero: ");
    int num2 = s.nextInt();
    
    for(int candidato = num1; candidato<= num2;candidato ++) {
      if(candidato % 2 == 0) {
        System.out.println(candidato);
      }
      
    }
    
    s.close();
  }

}
