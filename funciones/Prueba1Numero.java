package funciones;
import java.util.Scanner;

public class Prueba1Numero {

  public static void main(String[] args) {
   Scanner s = new Scanner(System.in);
   System.out.print("Introduce un n�mero: ");
   int n = s.nextInt();
   s.close();

   
   //Es primo;
    //System.out.println("El n�mero "+ n + " �es primo?: "+ Matematicas.esPrimo(n)); 

    
  //Siguiente primo
  System.out.println("El siguiente primo de " + n + " es " + Matematicas.siguientePrimo(n));
  System.out.println("---------------------------------------------------------------");
  
   
  // Digitos
   System.out.println("El n�mero "+ n + " tiene " + Matematicas.digitos(n)+ " d�gitos");
   System.out.println("---------------------------------------------------------------");

   
   //Voletea
   System.out.println("Voltea N�mero: "+n+" N�mero Volteado: "+ Matematicas.voltea(n));
   System.out.println("---------------------------------------------------------------");
   
   //esCapicua
   System.out.println("�Es capicua? N�mero: "+n+" Resultado: "+ Matematicas.esCapicua(n));

  
  
  
  }
} 
