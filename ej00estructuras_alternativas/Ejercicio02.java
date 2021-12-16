package ej00estructuras_alternativas;
/*
 *Programa que leeun número e indica si es par o impar

-Autor: Francisco Manuel Moyano Coleto
 */
public class Ejercicio02{
  public static void main(String[] args) {
    System.out.print("Introduce un número: ");
    int num = Integer.parseInt(System.console().readLine());
    int resto = num % 2;
    if(resto == 0){
      System.out.println("El numero es par");
    }
    else{
      System.out.println("El número es impar");
    }
  }


}