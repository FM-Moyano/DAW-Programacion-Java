package ej00numeros_aleatorios_y_arrays;
/*
 * programa que llena la pantalla de caracteres aleatorios (a lo Matrix) con el código ascii entre el 32 y el 126.
 */
public class ej03 {

  public static void main(String[] args) {
    for(;;) {
      int num = (int)(Math.random()*(126-32)+32);
      System.out.print((char)num);
    }

  }

}
