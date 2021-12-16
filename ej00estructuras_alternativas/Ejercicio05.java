package ej00estructuras_alternativas;

/*
 *Programa que lee la edad de dos personas y dice quien es mas joven, 
 *si tienen la misma edad hay de saberlo
 */

public class Ejercicio05 {
  public static void main(String[] args) {
    System.out.print("Introduce la edad de la primera persona: ");
    int edad1 = Integer.parseInt(System.console().readLine());

    System.out.print("Introduce la edad de la segunda persona: ");
    int edad2 = Integer.parseInt(System.console().readLine());

    if (edad1 == edad2) {
      System.out.println("Las dos personas tienen la misma edad");
    } else if (edad1 < edad2) {
      System.out.println("La primera persona es más joven que la segunda");
    } else {
      System.out.println("La segunda persona es más joven que la primera");
    }  
  }
}
