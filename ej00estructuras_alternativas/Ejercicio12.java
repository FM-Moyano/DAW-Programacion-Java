package ej00estructuras_alternativas;
/*
 * Programa que pide un a�o y nos dice si es bisiento o no
 */

import java.util.Scanner;

public class Ejercicio12 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Programa que nos dice si un a�o es bisiesto o no");
    System.out.print("Introduce un a�o: ");
    int year = s.nextInt();

    if(year % 4 == 0 && year % 100 != 0) {
      System.out.println("El a�o es bisiesto");
    }
    else {
      System.out.println("El a�o no es bisiesto");
    }
    s.close();
  }
}
