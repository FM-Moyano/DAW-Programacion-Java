package POO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CashRegister {
  
  List<Movent> cashRegister = new ArrayList<>();
  
  
  public void add(LocalDateTime dateTime, double amount, String concept) {
    Movent movent = new Movent(dateTime,amount,concept);
    cashRegister.add(movent);
 
  }
  
  public void add(double amount, String concept) {
    Movent movent = new Movent(amount,concept);
    cashRegister.add(movent);
  }
  
  public void deleteLast() {
    cashRegister.remove(cashRegister.size()-1);   
    
  }
  
  @Override
  public String toString() {
    String moventStr ="LISTADO DE MOVIMIENTOS DE CAJA\n"
        +"-----------------------\n"
        +"Numero\t Fecha   \t Hora\t Entrada Salida\t SALDO\t Comcepto\n";
        for(Movent e : cashRegister) {
          moventStr += e +"\n";
        }
        return moventStr;
  }
  
}
