package funciones;

import java.util.Scanner;

public class MenuOperadores {
  public static Scanner s = new Scanner(System.in);
  public static int resultado = 0;
  public static int a = 0;
  public static int b = 0;
  
  public static void main(String[] args) {
    Boolean menuActivo = true;
    
    while(menuActivo) {
      int opcion = menu();
      if(opcion > 1 && opcion < 6 && a == 0 && b == 0) {
       System.out.println("Primero debes introducir los valores a y b"); 
       continue;
      }
      
      switch (opcion) {
        case 1 -> introducir();
        case 2 -> sumar();
        case 3 -> restar();
        case 4 -> multiplicar();
        case 5 -> dividir();
        case 6 -> menuActivo = false;
        default -> System.out.println("Debes introducir una opcion valida");
      }
    }

  }
  
  
 public static int menu() {
   System.out.println();
   System.out.println("        Menu");
   System.out.println("-----------------------");
   System.out.println("1. Introducir valores a y b\n"
       +"2. Sumar \n"
       +"3. Restar\n"
       +"4. Multiplicar\n"
       +"5. Dividir\n"
       +"6. Salir\n");
   System.out.println("Introduce una opción: ");
   int opcion = s.nextInt();
   
   s.nextLine();
   System.out.println();
   
   return opcion;
 }
 
 public static void introducir() {
   System.out.println("Introdice el valor de a: ");
   a = s.nextInt();
   System.out.println("Introduce el valor de b: ");
   b = s.nextInt();
 }
 
 public static void sumar() {
 System.out.println("La suma de a y b es: " + a +" + " + b + " = " + (a+b));  
 }
 
 public static void restar() {
   System.out.println("La resta de a y b es: " + a +" - " + b + " = "+ (a-b));  
   }

 public static void multiplicar() {
   System.out.println("La multiplicacion de a y b es: " + a +" * " + b + " = "+ (a*b));  
   }
 
 public static void dividir() {
   System.out.println("La division de a y b es: " + a +" / " + b + " = "+ (a/b));  
   }
 
}
