package ej00secuenciales;

import java.util.Scanner;

public class Ejercicio4 {
  public static void main(String[]args) {
    Scanner leer = new Scanner(System.in);
    System.out.print("Programa que realiza la suma, resta, divisi�n y multiplicaci�n de dos n�mero");
    
    System.out.print("Ingrese el primer n�mero: ");
    int num1 = leer.nextInt();
    System.out.print("Ingrese el segundo n�mero: ");
    int num2 = leer.nextInt();

    int suma = num1 + num2;
    int resta = num1 - num2;
    int division = num1 / num2;
    int multiplicacion = num1 * num2;

    System.out.println(num1 +" + "+num2+" = "+suma); 
    System.out.println(num1 +" - "+num2+" = "+resta);
    System.out.println(num1 +" / "+num2+" = "+division);
    System.out.println(num1 +" * "+num2+" = "+multiplicacion);
    leer.close();
  }

}
