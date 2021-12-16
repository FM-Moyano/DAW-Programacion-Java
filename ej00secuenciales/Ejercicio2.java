package ej00secuenciales;

import java.util.Scanner;

public class Ejercicio2 {
  public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);

    System.out.print("Introduce la base: ");
    int base = leer.nextInt();
    System.out.print("Introduce  la altura: ");
    int altura = leer.nextInt();

    int perimeters = base * 2 + altura * 2;
    int area = base * altura;

    System.out.println("El perimetro es " + perimeters);
    System.out.println("EL area es " + area);
    leer.close();
  }
}
