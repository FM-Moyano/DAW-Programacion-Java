package POO.primera_tanda;

import java.util.Arrays;

public class TesterDice {

  public static void main(String[] args) {
    System.out.println("Primeros 4 dados: ");
    Dice dice1 = new Dice();
    Dice dice2 = new Dice(6);
    Dice dice3 = new Dice(4,10);
    Dice dice4 = new Dice();
    System.out.println(dice1);
    System.out.println(dice2);
    System.out.println(dice3);
    System.out.println(dice4);
    System.out.println();
    
   
    
    
    Dice dice5 = new Dice();
    Dice dice6 = new Dice(6);
    Dice dice7 = new Dice(4,10);
    dice5.roll();
    dice6.roll();
    dice7.roll();
    System.out.println("dados con roll");
    System.out.println(dice5);
    System.out.println(dice6);
    System.out.println(dice7);
    System.out.println();
    
    
    
    Dice[] dices = {dice1,dice2,dice3,dice4};
    System.out.println("Array de dados");
    System.out.println(Arrays.toString(dices));

  }

}
