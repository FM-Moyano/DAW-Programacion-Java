package POO.colecciones_diccionarios;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {

  private long numeroCuenta;
  private int saldo = 0;
  private List<String> movimientos = new ArrayList<>();
  
  

  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }

  public CuentaCorriente() {
    numeroCuenta = (long) (Math.random()*(9999999999l - 1000000000)) +1000000000; 
  }

  public CuentaCorriente(int s) {
    numeroCuenta = (long) (Math.random()*(9999999999l - 1000000000)) +1000000000; 
    saldo = s;
  }

  public void ingreso(int i) {
    saldo += i;
    //movimientos.add("Ingreso de " + i +"€ Saldo: " + String.format("%.2f", saldo) + "€");
    movimientos.add("Ingreso de " + i +"€ Saldo: " + saldo + "€");

  }

  public void cargo(int c) {
    saldo -= c;
    //movimientos.add("Cargo de " + c +"€ Saldo: " + String.format("%.2f", saldo) + "€");
    movimientos.add("Cargo de " + c +"€ Saldo: " + saldo + "€");


  }

  public void transferencia(CuentaCorriente cuenta, int t) {
    saldo -= t;
    cuenta.saldo += t;
    //movimientos.add("Transferencia. recibida de " + t +"€ de la cuenta" + cuenta.numeroCuenta + "Saldo: " + String.format("%.2f", saldo) + "€");
    movimientos.add("Transferencia. recibida de " + t +"€ de la cuenta " + cuenta.numeroCuenta + "Saldo: " + saldo + "€");
    cuenta.movimientos.add("Transferencia. recibida de " + t +"€ de la cuenta " + cuenta.numeroCuenta + "Saldo: " + saldo + "€");
  }
  
  public void movimientos() {
    System.out.println("Movimientos de la cuenta " + numeroCuenta +"\n"
        +"---------------------------------------");
    for(String movimiento : movimientos) {
      System.out.println(movimiento);
    }
  }

  @Override
  public String toString() {
    return "Número de cuenta : " + numeroCuenta + " Saldo: " + saldo +" €";
  }

}
