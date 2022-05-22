package BankGC.src.bankgc.data;

import java.util.List;
import BankGC.src.bankgc.business.Customer;

public interface CustomerDAO {
  
  public void add(Customer customer) throws DAOException;

  public void close() throws DAOException;

  public void set(Customer customer) throws DAOException;

  public Customer getCustomer(String dni) throws DAOException;

  public void removeCustomer(String dni) throws DAOException;

  public List<Customer> getCustomers() throws DAOException;

  public List<Customer> getCustomers(String filter) throws DAOException;

  public void haveAccount(String dni) throws DAOException;

}
