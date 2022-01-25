package funciones;

import java.util.Scanner;

public class Palotes {
  public static void main(String[] args) {
    int n = pideEnteroPositivo();
    System.out.println(n + " En el sistema de palotes: " + convierteEnPalotes(n));
    
  }
  
  public static int pideEnteroPositivo() {
    Scanner s = new Scanner(System.in);
    System.out.println("Inserta un entero positivo: ");
    int n = s.nextInt();
    
    if(n < 0) {
      System.out.println("Has introducido un número negativo.");
      System.out.println("Inserta un entero positivo: ");
      n = s.nextInt();
    }
    s.close();
    return n;
    
  }
  
  public static String convierteEnPalotes(int n) {
    String numeroEnPalotes = "";
    for(int posicion = 0; posicion < Matematicas.digitos(n); posicion++ ) {
      numeroEnPalotes += "| ".repeat(Matematicas.digitoN(n, posicion))+" - ";
    }
    
    numeroEnPalotes = numeroEnPalotes.substring(0, numeroEnPalotes.length()-2);
    return numeroEnPalotes;
  }

}
