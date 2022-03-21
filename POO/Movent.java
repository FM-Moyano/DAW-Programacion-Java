package POO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movent {

  private static int lastNumber= 0;
  public static double saldoAnterior = 0 ;
  public double saldo;
  int number;
  LocalDateTime dateTime;
  double amount;
  String concept;
  
  
  public Movent(double amount, String concept) {
    this.dateTime = LocalDateTime.now();
    this.amount = amount;
    this.concept = concept;
    lastNumber++;
    number = lastNumber;
    saldo = saldoAnterior  +amount;
    saldoAnterior = saldo;
 
  }
  public Movent(LocalDateTime dateTime, double amount, String concept) {
    this.dateTime = dateTime;
    this.amount = amount;
    this.concept = concept;
    lastNumber++;
    number = lastNumber;
    saldo = saldoAnterior  +amount;
    saldoAnterior = saldo;
  }

 
  public static void setSaldoAnterior(double saldo) {
    Movent.saldoAnterior = saldo;
  }
  public double getAmount() {
    return amount;
  }
  
  @Override
  public String toString() {
    if(amount <0) {
      return number + "\t" +dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\t " 
          +dateTime.format(DateTimeFormatter.ofPattern("HH:mm")) + "\t " +"\t" + amount
          + "\t" + saldo + "\t" + concept;
    }else {
      
    }
    return number + "\t" + dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\t " +dateTime.format(DateTimeFormatter.ofPattern("HH:mm")) + "\t "+ amount
        + "\t \t" + saldo + "\t" + concept;
  }
  
  
}
