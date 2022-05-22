package BankGC.src.bankgc.business;

public enum MovementType {

 INGRESO, CARGO, TRANSFERENCIA_ENVIADA, TRANSFERENCIA_RECIBIDA;
  
  public String code() {
    String code = null;
    switch(this) {
      case INGRESO -> code = "INGR";
      case CARGO -> code = "CARG";
      case TRANSFERENCIA_ENVIADA -> code = "TENV";
      case TRANSFERENCIA_RECIBIDA -> code = "TREC";
    }
    return code;
  }
}
