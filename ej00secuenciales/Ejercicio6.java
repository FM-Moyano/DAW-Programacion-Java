package ej00secuenciales;

import java.util.Scanner;

/**
 * Este programa muestra la media de tres números
 * @author fmmoy
 */
public class Ejercicio6 {
  public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);

    System.out.print("Ingrese el primer número: ");
    int num1 = leer.nextInt();
    System.out.print("Ingrese el segundo número: ");
    int num2 = leer.nextInt();
    System.out.print("Ingrese el tercer número: ");
    int num3 = leer.nextInt();
    
    double media = (num1 + num2 + num3) / 3.0;
    System.out.println("la media de "+ num1+", "+num2+" y "+num3+" es "+media); 
    leer.close();
  }
}