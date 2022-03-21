/**
 * Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un
    ArrayList y que luego calcule la suma, la media, el máximo y el mínimo de esos
    números. El tamaño de la lista también será aleatorio y podrá oscilar entre 10
    y 20 elementos ambos inclusive.
    Ejercicios 2, 6, 8, 9, 10, 11, 12, 16, 17, 18, 22.
 */

package POO.colecciones_diccionarios;

import java.util.ArrayList;
import java.util.List;
import util.Util;

public class Ejercicio2 {

  public static void main(String[] arg) {

    int suma = 0;
    int maximo = Integer.MIN_VALUE;
    int minimo = Integer.MAX_VALUE;
    //int size = (int) (Math.random()*(20-10+1)+10);ç
    int size = Util.randomInt(10, 20);


    List<Integer> lista = new ArrayList<>();


    for(int n = 0;n< size; n++) {
      lista.add(Util.randomInt(1,100)); 
    }

    System.out.println("Lista genrada " + lista);
    
    for(int n : lista) {
      suma += n;
      
      if(n > maximo) {
        maximo = n;
      }
      if(n < minimo) {
        minimo = n;
      }
    }
    
    System.out.println("El valor máximo de la lista es "+ maximo);
    System.out.println("El valor mínimo de la lista es " + minimo);
    System.out.println("La suma de los valores de la lista es " + suma);
    System.out.println("La media de la lsita es " + suma / size);
  }
}
