/*
 * Programa que sortea un n�mero de 1 a 100 y va pidiendo n�meros y va respondiendo si el n�mero a adivinar es mayor o menor que el introducido,
 * a dem�s de los intentos que te quedan (tienes 10 intentos para acertarlo). El programa termina cuando se acierta el n�mero
 *  (adem�s te dice en cuantos intentos lo has acertado), si se llega al limite de intentos te muestra el n�mero que hab�a generado.
 *
 *
 */

package ej00estructuras_repetitivas;

import java.util.Scanner;

public class ej01 {

  private static final int INTENTOS_MAXIMOS = 11 ;

  public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
    System.out.println("Programa que sortea un n�mero entre 1 y 100, se tienen 10 intentos para acertarlo");

    int sorteo = (int)(Math.random()*100) + 1;
    int intentos = 1;

    System.out.print("Introduce un n�mero entre 1 y 100: ");
    int num = s.nextInt();

    System.out.println(sorteo);

    for(int i = 2; sorteo != num && i < INTENTOS_MAXIMOS; i++) {

      if(num == sorteo) {
        System.out.println("Enhorabuena has acertado el n�mero"); 
      }
      else if(num > sorteo) {
        System.out.println("Has introducido un n�mero mayor");
        System.out.print("Introduce un n�mero entre 1 y 100: ");
        num = s.nextInt();
        System.out.println();
        intentos += 1;
      }
      else {
        System.out.println("Has introducido un n�mero menor");
        System.out.print("Introduce un n�mero entre 1 y 100: ");
        num = s.nextInt();
        System.out.println();
        intentos += 1;
      }
    }
    if (num == sorteo){
      System.out.println("Has adivinado el n�mero en el intento " + intentos );
    }
    else {
      System.out.println("Te has quedado sin intentos");
    }


    s.close();
  }

}
