package BankGC.src.bankgc.business;

import java.util.List;
import BankGC.src.bankgc.data.CustomerDAO;
import BankGC.src.bankgc.data.DAOException;
import BankGC.src.bankgc.data.DAOManager;

public class CustomersManager {

  private CustomerDAO customerDAO;
  private DAOManager daoManager;

  public CustomersManager(DAOManager daoManager) throws DAOException {
    this.customerDAO = daoManager.getCustomerDAO();
    
  }
  
  public CustomersManager(String url, String user, String password) throws DAOException {
    daoManager = new DAOManager(url, user, password);
    customerDAO = daoManager.getCustomerDAO();
  }

  public void set(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

  public Customer get(String dni) throws DAOException {
    return customerDAO.getCustomer(dni);
  }
  
  public void add(String dni, String name, String address, String phone) throws DAOException {
    customerDAO.add(new Customer(dni, name, address, phone));
  }

  public void set(String dni, String name, String address, String phone) throws DAOException {
    customerDAO.set(new Customer(dni, name, address, phone));
  }
  
  public void setName(String dni, String name) throws DAOException {
    Customer customer = get(dni);
    customer.setName(name);
    customerDAO.set(customer);
  }
  
  public void setAddress(String dni, String address) throws DAOException {
    Customer customer = get(dni);
    customer.setAddress(address);
    customerDAO.set(customer);
  }
  
  public void setPhone(String dni, String phone) throws DAOException {
    Customer customer = get(dni);
    customer.setPhone(phone);
    customerDAO.set(customer);
  }

  public void remove(String dni) throws DAOException {
    customerDAO.haveAccount(dni);
    customerDAO.removeCustomer(dni);
  }
  
  public List<Customer> getList() throws DAOException {
    return customerDAO.getCustomers();
  }
  
  public List<Customer> getList(String sql) throws DAOException {
    return customerDAO.getCustomers(sql);
  }

  public void close() throws DAOException {
    customerDAO.close();
  }

}
