package ej00estructuras_repetitivas;
/*
 * Programa que pide  el limite inferior y superior de un intervalo. Si el límite inferior es mayor que el superior lo tiene que volver a pedir. 
 * A continuación se van introduciendo números hasta que introduzcamos el 0. Cuando termine el programa dará las siguientes informaciones:
 * 
 * La suma de los números que están dentro del intervalo (intervalo abierto).
 * Cuantos números están fuera del intervalo.
 * Informa si hemos introducido algún número igual a los límites del intervalo.
 */
import java.util.Scanner;
public class ej05 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.print("Introduce el límite inferior: ");
    int limiteInferior = s.nextInt();
    System.out.print("Introduce el límite superior: ");
    int limiteSuperior = s.nextInt();
    
    while(limiteInferior >= limiteSuperior) {
      System.out.println("Debes introducir el límite inferior menor que le superior");
      System.out.print("Introduce el límite inferior: ");
      limiteInferior = s.nextInt();
      System.out.print("Introduce el límite superior: ");
      limiteSuperior = s.nextInt();  
    }
    
    int num = 1;
    int igualALimites = 0;
    int fueraLimites = 0;
    int dentroLimites = 0;
    
    
    
    while(num != 0) {
      System.out.print("Introduce un número: ");
      num = s.nextInt();
      
      if(num == limiteInferior || num == limiteSuperior) {
        igualALimites += 1;
      }
      if (num > limiteInferior && num < limiteSuperior) {
        dentroLimites += 1;
      }
      if (num < limiteInferior || num > limiteSuperior) {
        fueraLimites += 1;
      }
    }
    
    System.out.println("Iguales a los límites: " + igualALimites);
    System.out.println("Fuera de los límites: " + fueraLimites);
    System.out.println("Dentro a los límites: " + dentroLimites);

    
    s.close();  
  }

}
