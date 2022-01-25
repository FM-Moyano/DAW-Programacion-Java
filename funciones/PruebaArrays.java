package funciones;

import java.util.Arrays;

public class PruebaArrays {

  public static void main(String[] args) {
    int n = 10;
    int minimo = 2;
    int maximo = 23;
    int[] array1 = {10,5,12,21,6,8,9,12};
    int[][] array2D ={ {1,2,3,4,5,6,7,8},{9,10,11,12,13,14,15,16},{17,18,19,20,21,22,23,24}};
    
    //Generar array
    System.out.println("Genera array: "+ Arrays.toString(arrays.genaraArrayInt(n, minimo, maximo)));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();
    
    
    //Mínimo array
    System.out.println("Minimo de un array Array: "+ Arrays.toString(array1)+" Mínimo: "+ arrays.minimoArrayInt(array1));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();


    //Máximo array
    System.out.println("Máximo de un array Array: "+ Arrays.toString(array1)+" Máximo: "+ arrays.maximoArrayInt(array1));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();

    //Media array
    System.out.println("Media de un array Array: "+ Arrays.toString(array1)+ " Media: "+ arrays.mediaArrayInt(array1));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();

    //Está en array
    System.out.println("Está en array Array: "+ Arrays.toString(array1) + " Número: " + n+ " ¿Está en array?: " + arrays.estaEnArrayInt(n, array1));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();

    //Posición en array 
    System.out.println("Posición en el array  Array: " + Arrays.toString(array1) + " Número: " + n + " Posición: " + arrays.posicionEnArray(n, array1) );
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();
    
    //Voltear Array
    System.out.println("Voltear array  Array: " + Arrays.toString(array1) + " Array volteado: " + Arrays.toString(arrays.volteaArrayInt(array1)));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();
    
    //Rota uno a la derecha
    System.out.println("Rota uno a la derecha Array: " + Arrays.toString(array1) + " Array rotado: " + Arrays.toString(arrays.rotaUnoDerechaInt(array1)));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();
    
    // Rota derecha array
    System.out.println("Rota a la derecha Array: " + Arrays.toString(array1) + " Veces rotado:  " + minimo + " Array rotado: " + Arrays.toString(arrays.rotaDerechaArrayInt(array1,minimo)));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();
    
 // Rota izquierda array
    System.out.println("Rota a la izquierda Array: " + Arrays.toString(array1) + " Veces rotado:  " + minimo + " Array rotado: " + Arrays.toString(arrays.rotaIzquierdaArrayInt(array1,minimo)));
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println();
    
    // Array 2 dimensiones 
    System.out.println("Coordenada en array: " + " numero: " + n + " está en la coordenada: "+ Arrays.toString(Arrays2D.coordenadasEnArrayBlint(array2D, n)));
    System.out.println(array2D.length);
  }

}
