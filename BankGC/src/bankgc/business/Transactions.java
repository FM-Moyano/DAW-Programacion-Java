package BankGC.src.bankgc.business;

import java.time.LocalDateTime;

public class Transactions {
  private int account_id;
  private double amount;
  private LocalDateTime localDateTime;
  private MovementType type;
  private int transferAccountNumber;
  //private String concept;

  public Transactions(int account_id, double amount,LocalDateTime localDateTime,MovementType type, int transferAccountNumber ) {
    this.account_id = account_id;
    this.amount = amount;
    this.type = type;
    this.transferAccountNumber = transferAccountNumber;
    this.localDateTime = localDateTime;
  }
  
  public Transactions(int account_id, double amount,MovementType type, int transferAccountNumber ) {
    this(account_id, amount,LocalDateTime.now(),type,  transferAccountNumber);
  }
  
  public Transactions(int account_id, double amount,MovementType type) {
    this(account_id,amount,type,0);
  }

  public int getAccount_id() {
    return account_id;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public MovementType getType() {
    return type;
  }

  public int getTransferAccountNumber() {
    return transferAccountNumber;
  }

  @Override
  public String toString() {
    return "Movimientos: \n Cuenta: " + account_id + "\n Impote: " + amount + "\n Fecha: "
        + localDateTime + " \n Tipo de Movimiento: " + type + 
        ((type == MovementType.TRANSFERENCIA_ENVIADA || type == MovementType.TRANSFERENCIA_RECIBIDA) ? "\nNumero de Cuenta de Transferencia: " +
        transferAccountNumber : "");     
  }
  
  
  
  

}
