package POO.segunda_tanda;

public class CuentaCorriente {

  private long numeroCuenta;
  private int saldo = 0;
  
  public CuentaCorriente() {
    numeroCuenta = (long) (Math.random()*(9999999999l - 1000000000)) +1000000000; 
  }
  
  public CuentaCorriente(int s) {
    numeroCuenta = (long) (Math.random()*(9999999999l - 1000000000)) +1000000000; 
    saldo = s;
  }
  
  public void ingreso(int i) {
    saldo += i;
  }
  
  public void cargo(int c) {
    saldo -= c;
  }

  public void transferencia(CuentaCorriente cuenta, int t) {
    cargo(t);
    cuenta.ingreso(t);
  }
  
  @Override
  public String toString() {
    return "Número de cuenta : " + numeroCuenta + " Saldo: " + saldo +" €";
  }

}
