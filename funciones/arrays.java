package funciones;

public class arrays {

  /**
   * 
   * @param n
   * @param minimo
   * @param maximo
   * @return array
   */
  public static int[] genaraArrayInt(int n, int minimo, int maximo) {
    int[] array = new int[n];
    for(int i = 0; i < n; i++) {
      array[i] = minimo + (int) (Math.random()*(maximo-minimo)+1);
    }
    return array;
  }
  
  public static int minimoArrayInt(int[] array) {
    int minimo = Integer.MAX_VALUE;
    for(int i = 0; i < array.length;i++) {
      if(array[i] < minimo) {
        minimo = array[i];
      }
    }
    return minimo;
  }
  
  public static int maximoArrayInt(int[] array) {
    int maximo = Integer.MIN_VALUE;
    for(int i = 0; i < array.length;i++) {
      if(array[i] > maximo) {
        maximo = array[i];
      }
    }
    return maximo;
  }
  
  public static int mediaArrayInt (int[] array) {
    int suma = 0;
    for(int i = 0; i < array.length; i++) {
      suma += array[i];
    }
    int media = suma / array.length;
    return media;
  }
  
  public static boolean estaEnArrayInt(int numero, int[] array) {
    for(int i = 0; i < array.length; i++) {
      if(numero == array[i]) {
        return true;
      }
    }
    return false;
  }
  
  public static int posicionEnArray(int numero, int[] array) {
    for(int i = 0; i < array.length; i++) {
      if(numero == array[i]) {
        return i;
      }
    }return -1;
  }
  
  public static int[] volteaArrayInt(int[] array) {
    int[] copiaArray = new int[array.length];
    for(int i = 0; i < array.length; i++) { // tambien podríamos copiar el array con el metodo "copyof"
      copiaArray[i] = array[i];
    }
   
    for(int i =0; i < array.length;i++) {
      array[i] = copiaArray[array.length -i -1];
    }
    return array;
  }

  /**
   * 
   * @param array
   * @return array rotado
   */
  public static int[] rotaUnoDerechaInt(int[] array) {
    int ultimo = array[array.length-1];
    for(int i = array.length-1; i > 0; i--) {
      array[i] = array[i-1];
    }
    array[0] = ultimo;
    return array;
  }
  
  public static int[] rotaDerechaArrayInt(int[] array, int numero) {
    for(int i = 1; i <= numero; i++) {
      arrays.rotaUnoDerechaInt(array);
    }
    return array;
    
  }
  
  public static int[] rotaUnoIzquierdaInt(int[] array) {
    int primero = array[0];
    for(int i = 0; i < array.length -1; i++) {
      array[i] = array[i+1];
    }
    array[array.length -1] = primero;
    return array;
  }
  
  public static int[] rotaIzquierdaArrayInt(int[] array, int numero) {
    for(int i = 1; i <= numero; i++) {
      arrays.rotaUnoIzquierdaInt(array);
    }
    return array;
  }
}
