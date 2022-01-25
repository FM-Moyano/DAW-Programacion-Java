package funciones;

import java.util.Arrays;

public class Mezcla {

  public static void main(String[] args) {
    int[] array1 = {1,3,5,7,8,9};
    int[] array2 = {2,4,6};
    System.out.println("Vamos a mezclar estos dos arrays, array1 : " + Arrays.toString(array1) + " y array2: " + Arrays.toString(array2));
    System.out.println(" Array mezclado: " + Arrays.toString(mezcla(array1, array2)));
  }
  
  public static int[] mezcla(int[] array1, int[] array2) {
    int[] arrayMezclado = new int[array1.length+array2.length];
    int longitudMinimaArray = (array1.length < array2.length) ? array1.length : array2.length;
   
    
    for( int i =0; i < longitudMinimaArray; i++) {
      arrayMezclado[i*2] = array1[i];
      arrayMezclado[i*2 + 1] = array2[i];
    }
    
    int[] arrayMayor = (array1.length > array2.length) ? array1 : array2;  
    for(int i = longitudMinimaArray; i < arrayMayor.length; i++) {
      arrayMezclado[longitudMinimaArray + i] = arrayMayor[i];
    }
    return arrayMezclado;
  }

}
