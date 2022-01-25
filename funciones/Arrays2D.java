package funciones;

public class Arrays2D {

  public static int[][] genaraArrayBilnt(int n, int m,int minimo, int maximo){
   int[][] array = new int[n][m];
   for(int i = 0; i< n; i++) {
     for(int j = 0; j < m; j++) {
       array[i][j] = minimo + (int) (Math.random()*(maximo-minimo)+1);
     }
   }
   return array;
  }
  
 public static int[] coordenadasEnArrayBlint(int[][] array2D, int numero) {
   int[] array = new int[2];
   for(int i = 0; i < array2D.length; i++) {
     for (int j = 0; j < array2D.length; j++) {
       if(array2D[i][j] == numero) {
         array[0]= i;
         array[1]= j;
         return array;
       }
     }
   }
   array[0]= -1;
   array[1]= -1;
   return array;
 }
  
  
  
}
