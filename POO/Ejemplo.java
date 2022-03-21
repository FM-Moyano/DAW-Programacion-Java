package POO;

//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import util.Util;

public class Ejemplo {

  public static void main(String[] args) {

    for(int i= 0; i< 11;i++) {
      System.out.println(Util.randomInt(10, 20));
    }
    
    String fecha = Util.readStr("Introduce una fecha");
    
   if(!(Util.isDateOk(fecha))) {
    System.out.println("Fecha incorrecta"); 
   }
   
   Map<Integer,String> diccionario = new HashMap<>();
   diccionario.put(1, "uno");
   diccionario.put(2, "dos");
   diccionario.put(3, "tres");
   diccionario.put(4, "cuatro");
   
   //String[] diccionarioStr = diccionario.keySet().toArray(new String[0]);

   
   
  }

   

}
