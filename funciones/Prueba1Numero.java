package funciones;
import java.util.Scanner;

public class Prueba1Numero {

  public static void main(String[] args) {
   Scanner s = new Scanner(System.in);
   System.out.print("Introduce un número: ");
   int n = s.nextInt();
   s.close();

   
   //Es primo;
    //System.out.println("El número "+ n + " ¿es primo?: "+ Matematicas.esPrimo(n)); 

    
  //Siguiente primo
  System.out.println("El siguiente primo de " + n + " es " + Matematicas.siguientePrimo(n));
  System.out.println("---------------------------------------------------------------");
  
   
  // Digitos
   System.out.println("El número "+ n + " tiene " + Matematicas.digitos(n)+ " dígitos");
   System.out.println("---------------------------------------------------------------");

   
   //Voletea
   System.out.println("Voltea Número: "+n+" Número Volteado: "+ Matematicas.voltea(n));
   System.out.println("---------------------------------------------------------------");
   
   //esCapicua
   System.out.println("¿Es capicua? Número: "+n+" Resultado: "+ Matematicas.esCapicua(n));

  
  
  
  }
} 
