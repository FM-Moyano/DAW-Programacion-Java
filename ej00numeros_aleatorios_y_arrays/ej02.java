package ej00numeros_aleatorios_y_arrays;
/*
 * Programa que vaya generando n�meros aleatorios pares entre 0 y 100 y que no termine de generar n�meros hasta que no saque el 24. 
 * El  programa deber� decir al final cu�ntos n�meros se han generado.
 */
public class ej02 {

  public static void main(String[] args) {
    int paresGenerados = 0;
    int num = (int)(Math.random()*101);

    while(num!= 24) {
      num = (int)(Math.random()*101);

      if(num % 2 == 0) {
        paresGenerados +=1;
      }
    }
    System.out.println("Se han genarado "+ paresGenerados+ " n�meros pares");
  }

}
