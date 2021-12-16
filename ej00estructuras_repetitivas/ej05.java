package ej00estructuras_repetitivas;
/*
 * Programa que pide  el limite inferior y superior de un intervalo. Si el l�mite inferior es mayor que el superior lo tiene que volver a pedir. 
 * A continuaci�n se van introduciendo n�meros hasta que introduzcamos el 0. Cuando termine el programa dar� las siguientes informaciones:
 * 
 * La suma de los n�meros que est�n dentro del intervalo (intervalo abierto).
 * Cuantos n�meros est�n fuera del intervalo.
 * Informa si hemos introducido alg�n n�mero igual a los l�mites del intervalo.
 */
import java.util.Scanner;
public class ej05 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.print("Introduce el l�mite inferior: ");
    int limiteInferior = s.nextInt();
    System.out.print("Introduce el l�mite superior: ");
    int limiteSuperior = s.nextInt();
    
    while(limiteInferior >= limiteSuperior) {
      System.out.println("Debes introducir el l�mite inferior menor que le superior");
      System.out.print("Introduce el l�mite inferior: ");
      limiteInferior = s.nextInt();
      System.out.print("Introduce el l�mite superior: ");
      limiteSuperior = s.nextInt();  
    }
    
    int num = 1;
    int igualALimites = 0;
    int fueraLimites = 0;
    int dentroLimites = 0;
    
    
    
    while(num != 0) {
      System.out.print("Introduce un n�mero: ");
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
    
    System.out.println("Iguales a los l�mites: " + igualALimites);
    System.out.println("Fuera de los l�mites: " + fueraLimites);
    System.out.println("Dentro a los l�mites: " + dentroLimites);

    
    s.close();  
  }

}
