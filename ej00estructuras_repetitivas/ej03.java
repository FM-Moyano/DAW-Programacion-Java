package ej00estructuras_repetitivas;

/*
 * Programa que pida caracteres e imprima ëVOCALí si son vocales y ëNO VOCALí en caso contrario, el programa termina cuando se introduce un espacio.
 */

import java.util.Scanner;
public class ej03 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String vocales = "AEIOU¡…Õ”⁄‹";
    
    for(String caracter = ""; !(caracter.equals(" "));) {
      System.out.print("Introduce un caracter: ");
      caracter = s.nextLine().toUpperCase();
      
      while(caracter.length() != 1) {
        System.out.println("No has introducido un car·cter");
        System.out.print("Introduce un caracter: ");
        caracter = s.nextLine().toUpperCase();
      }  
      
      if(caracter.equals(" ")) {
        System.out.println("Has introducido un espacio, termina el programa");
      }
      
      else if(vocales.indexOf(caracter)!= -1) {
        System.out.println("VOCAL");
      }
      else {
        System.out.println("NO VOCAL");
      }
    }
    
  
    s.close();
  }

}
