package ej00estructuras_alternativas;
/*
 * Programa que pide un año y nos dice si es bisiento o no
 */

import java.util.Scanner;

public class Ejercicio12 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Programa que nos dice si un año es bisiesto o no");
    System.out.print("Introduce un año: ");
    int year = s.nextInt();

    if(year % 4 == 0 && year % 100 != 0) {
      System.out.println("El año es bisiesto");
    }
    else {
      System.out.println("El año no es bisiesto");
    }
    s.close();
  }
}
