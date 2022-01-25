package funciones;

import java.util.Scanner;

public class Prueba2Numeros {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Introduce el primer número: ");
    int num1 = s.nextInt();
    System.out.print("Introduce el segundo número: ");
    int num2 = s.nextInt();
    s.close();
    System.out.println("-------------------------------------------------------------------------");
    
  
    // Potencia
    System.out.println("potencia de dos números "+ num1+ " y " +num2+ ": "+ Matematicas.potencia(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    // Quitar por detras.
    System.out.println("Le vamos a quitar al número "+ num1+", "+num2+" números por detras:");
    System.out.println(Matematicas.quitaPorDetras(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    // Quitar por delante
    System.out.println("Le vamos a quitar al número "+ num1+", "+num2+" números por delante:");
    System.out.println(Matematicas.quitarPorDelante(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //DigitoN
    System.out.println("DigitoN numero: "+num1+" Posición: "+num2);
    System.out.println(Matematicas.digitoN(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //Posición digito
    System.out.println("Posición Digito Número: "+num1+" Dígito: "+num2+" Posición: "+Matematicas.posicionDigito(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //Pegar por detras
    System.out.println("Pegar por detras Número: "+num2+" Dígito: "+num2+" Número Pegado: "+Matematicas.pegarPorDetras(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    //Pegar por delante
    System.out.println("Pegar por delante Número: "+num2+" Dígito: "+num2+" Número Pegado: "+Matematicas.pegarPorDelante(num1, num2));
    System.out.println("-------------------------------------------------------------------------");
    
    // Juntar números
    System.out.println("Juntar números Numero1: "+num1+" Número2: "+num2+" Numero Junto: "+Matematicas.juntarNumeros(num1, num2));
  }

}
