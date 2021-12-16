package ej00estructuras_alternativas;

import java.util.Scanner;
import java.lang.Math;

/*
 *Programa que lee la A, B y C que corresponden a los lados
de un triangulo, determina quee tipo de triangulo es
 *Autor: Francisco Manuel Moyano Coleto
 */
public class Ejercicio11 {
  public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    
    System.out.print("Introduce A: ");
    int a = leer.nextInt();
    System.out.print("Introduce B: ");
    int b = leer.nextInt();
    System.out.print("Introduce C: ");
    int c = leer.nextInt();
    leer.close();
    
    if(a == b && b == c) {
      System.out.println("El triangulo es equilatero");
    }
    else {
      if(Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2)) || Math.pow(b, 2) == (Math.pow(a, 2)+ Math.pow(c, 2)) || Math.pow(c, 2) == (Math.pow(b, 2)+Math.pow(a, 2)) ) {
        System.out.println("El triangulo es 'Rectangulo'");
      }
      else if(a == b || a == c || b == c) {
        System.out.println("El triangulo es 'Isóceles'");
      }
      else {
        System.out.println("El triangulo es 'Escaleno'");
      }
    }
  }

}
