package funciones;

import java.util.Scanner;

public class Prueba2Numeros {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Introduce el primer n�mero: ");
    int num1 = s.nextInt();
    System.out.print("Introduce el segundo n�mero: ");
    int num2 = s.nextInt();
    s.close();
    System.out.println("-------------------------------------------------------------------------");
    
  
    // Potencia
    System.out.println("potencia de dos n�meros "+ num1+ " y " +num2+ ": "+ Matematicas.potencia(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    // Quitar por detras.
    System.out.println("Le vamos a quitar al n�mero "+ num1+", "+num2+" n�meros por detras:");
    System.out.println(Matematicas.quitaPorDetras(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    // Quitar por delante
    System.out.println("Le vamos a quitar al n�mero "+ num1+", "+num2+" n�meros por delante:");
    System.out.println(Matematicas.quitarPorDelante(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //DigitoN
    System.out.println("DigitoN numero: "+num1+" Posici�n: "+num2);
    System.out.println(Matematicas.digitoN(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //Posici�n digito
    System.out.println("Posici�n Digito N�mero: "+num1+" D�gito: "+num2+" Posici�n: "+Matematicas.posicionDigito(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //Pegar por detras
    System.out.println("Pegar por detras N�mero: "+num2+" D�gito: "+num2+" N�mero Pegado: "+Matematicas.pegarPorDetras(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //Pegar por delante
    System.out.println("Pegar por delante N�mero: "+num2+" D�gito: "+num2+" N�mero Pegado: "+Matematicas.pegarPorDelante(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    // Juntar n�meros
    System.out.println("Juntar n�meros Numero1: "+num1+" N�mero2: "+num2+" Numero Junto: "+Matematicas.juntarNumeros(num1, num2));
  }

}
