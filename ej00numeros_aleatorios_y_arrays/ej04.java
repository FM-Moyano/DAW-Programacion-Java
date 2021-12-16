package ej00numeros_aleatorios_y_arrays;
/*
 * programa que pinte por pantalla una serpiente con un “serpenteo” aleatorio.
 * La cabeza se representará con el carácter @ y se debe colocar  
 * exactamente en la posición 13 (con 12 espacios delante). 
 * A partir de ahí, el cuerpo irá serpenteando de la siguiente manera:
 * se generará de forma aleatoria un valor entre tres posibles que hará
 * que el siguiente carácter se  coloque una posición a la izquierda del anterior,
 * alineado con el anterior o una posición a la derecha del anterior. 
 * La longitud de la serpiente se pedirá por teclado y se supone que 
 * el usuario introducirá un dato correcto.
 */
import java.util.Scanner;
public class ej04 {

  private static final char CABEZA = '@';
  private static final char CUERPO = '*';

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Introduce la longitud de la serpiente: ");
    int longitud = s.nextInt();
    int blancos = 12;
    System.out.println(" ".repeat(blancos)+ CABEZA);
    
    for (int i=1; i < longitud; i++) {
      int posicion = -1 +(int)(Math.random()*3);
      System.out.println(" ".repeat(blancos - posicion)+ CUERPO);
      
    }
    
    s.close();
  }

}
