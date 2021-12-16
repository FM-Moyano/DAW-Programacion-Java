package ej00numeros_aleatorios_y_arrays;
/*
 * Programa que muestre tres apuestas de la quiniela en tres columnas para los 14 partidos y el pleno al quince (15 filas)
 * de forma que la probabilidad de que salga un 1 sea  de 1/2, la probabilidad de que salga X sea de 1/3 y la probabilidad 
 * de que salga 2 sea de 1/6. Pista: 1/2 = 3/6 y 1/3 = 2/6.
 * 
 * -Autor: Francisco Manuel Moyano Coleto
 */

public class ej01 {
  
  private static final int PARTIDOS = 15;
  private static final int APUESTAS = 3;
  private static final double DERROTA = 1.0/2;
  private static final double EMPATE = 1.0/3;
  

  public static void main(String[] args) {
    
    char[][] quiniela = new char[PARTIDOS][APUESTAS];
    
    // Generación de la quiniela
    for (int partido=0; partido < PARTIDOS; partido++) {
      for (int apuesta=0; apuesta < APUESTAS; apuesta++) {
        double random = Math.random();
        if(random <= DERROTA) {
          quiniela[partido][apuesta] = '1';
        }
        else if(random <= EMPATE + DERROTA) {
          quiniela[partido][apuesta] = 'x';
        }
        else{
          quiniela [partido][apuesta] = '2';
        }
      }
    }
    
    //Impresión 
    for (int partido=0; partido < PARTIDOS; partido++) {
      System.out.print("Partido "+ (partido+1) + "\t");
      for (int apuesta=0; apuesta < APUESTAS; apuesta++) {
        System.out.print(quiniela[partido][apuesta] + "\t");
      }
      System.out.println();
    }
  }
}
