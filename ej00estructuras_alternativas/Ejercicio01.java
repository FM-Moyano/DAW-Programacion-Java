package ej00estructuras_alternativas;

public class Ejercicio01 {
  public static void main(String[] args) {
    System.out.print("Introduce el primer n�mero: ");
    int num1 = Integer.parseInt( System.console().readLine());
    System.out.print("Introduce el segundo n�mero: ");
    int num2 = Integer.parseInt(System.console().readLine());

    if(num1 > num2){
      System.out.println("El primer n�mero es mayor");
    }
    else{
      System.out.println("EL segundo n�mero es mayor");
    }



  }

}

