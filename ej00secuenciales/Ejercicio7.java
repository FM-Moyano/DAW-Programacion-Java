package ej00secuenciales;
import java.util.Scanner;

public class Ejercicio7 {
  public static void main(String[]args) {
    Scanner leer = new Scanner(System.in);

    System.out.print("Ingrese el número de minutos: ");
    int min = leer.nextInt();
    int horas = min / 60;
    int minutos = min % 60;
    System.out.println(horas+" horas y "+ minutos+" minutos");
    leer.close();
  }
}
