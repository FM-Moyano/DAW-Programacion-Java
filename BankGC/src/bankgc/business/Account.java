package BankGC.src.bankgc.business;

public class Account {

  private int id;
  private String customer_id;
  private int alive;
  
  /*public Account(String customer_id){
    setCustomer_id(customer_id);
    
  }*/

  public Account(int id,String customer_id, int alive){
    setCustomer_id(customer_id);
    setAlive(alive);
    setId(id);
    
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(String customer_id) {
    this.customer_id = customer_id;
  }

  public int getAlive() {
    return alive;
  }

  public void setAlive(int alive) {
    this.alive = alive;
  }

  @Override
  public String toString() {
    return "Id= " + id + ", DNI cliente=" + customer_id + ", Estado=" + ((alive==1) ? "activa" : "baja");
  }
  
  
}
