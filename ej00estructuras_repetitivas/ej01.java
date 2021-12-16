/*
 * Programa que sortea un número de 1 a 100 y va pidiendo números y va respondiendo si el número a adivinar es mayor o menor que el introducido,
 * a demás de los intentos que te quedan (tienes 10 intentos para acertarlo). El programa termina cuando se acierta el número
 *  (además te dice en cuantos intentos lo has acertado), si se llega al limite de intentos te muestra el número que había generado.
 *
 *
 */

package ej00estructuras_repetitivas;

import java.util.Scanner;

public class ej01 {

  private static final int INTENTOS_MAXIMOS = 11 ;

  public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
    System.out.println("Programa que sortea un número entre 1 y 100, se tienen 10 intentos para acertarlo");

    int sorteo = (int)(Math.random()*100) + 1;
    int intentos = 1;

    System.out.print("Introduce un número entre 1 y 100: ");
    int num = s.nextInt();

    System.out.println(sorteo);

    for(int i = 2; sorteo != num && i < INTENTOS_MAXIMOS; i++) {

      if(num == sorteo) {
        System.out.println("Enhorabuena has acertado el número"); 
      }
      else if(num > sorteo) {
        System.out.println("Has introducido un número mayor");
        System.out.print("Introduce un número entre 1 y 100: ");
        num = s.nextInt();
        System.out.println();
        intentos += 1;
      }
      else {
        System.out.println("Has introducido un número menor");
        System.out.print("Introduce un número entre 1 y 100: ");
        num = s.nextInt();
        System.out.println();
        intentos += 1;
      }
    }
    if (num == sorteo){
      System.out.println("Has adivinado el número en el intento " + intentos );
    }
    else {
      System.out.println("Te has quedado sin intentos");
    }


    s.close();
  }

}
