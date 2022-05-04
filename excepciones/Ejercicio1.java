package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

  private static final int MAXIMO = 6;
  public static Scanner s = new Scanner(System.in);
  public static void main(String[] args) {
    int max = Integer.MIN_VALUE;

    System.out.println("Introduce un número entero: ");
    for(int i = 0; i <MAXIMO; i++) {

      int numero = 0;
      boolean valido = false;

      do {
        try {
          numero = s.nextInt();
          valido = true;
        }catch(InputMismatchException e) {
          System.err.println("EL dato introdicido no es correcto, intentelo de nuevo"); 
          s.nextLine();
        }

      }while(!valido);
      if(numero > max) {
        max = numero;
      }
    }
    System.out.println("El valor mayor es " + max);
  }

}


