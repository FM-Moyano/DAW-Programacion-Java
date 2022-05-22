package BankGC.src.bankgc.business;

import java.util.List;
import BankGC.src.bankgc.data.AccountDAO;
import BankGC.src.bankgc.data.DAOException;
import BankGC.src.bankgc.data.DAOManager;

public class AccountsManager {
  
  private AccountDAO accountDAO;
  private DAOManager daoManager;
  
  public AccountsManager(DAOManager daoManager) throws DAOException {
    this.accountDAO = daoManager.getAccountDAO();
    
  }

  public AccountsManager(String url, String user, String password) throws DAOException {
    daoManager = new DAOManager(url, user, password);
    accountDAO = daoManager.getAccountDAO();
  }
  
  public void add(String customer_id) throws DAOException {
    accountDAO.add(customer_id);
    
  }
  
  public Account getAccount(int id) throws DAOException {
    return accountDAO.getAccount(id);
  }
  
  public void unsubscribe(int id ) throws DAOException {
    accountDAO.unsubscribe(id);
  }

  public void ingress(int id, double amount) throws DAOException {
    throwexceptionifamountisnegative(amount);
    accountDAO.ingress(id, amount);
  }
  
  public void withdrawals(int id, double amount ) throws DAOException {
    throwExceptionIfAmountIsLess(amount,id);
    throwexceptionifamountisnegative(amount);
    accountDAO.withdrawals(id, amount);
  }
  
  public void transfer(int transmitter_id, int receiver_id, double amount) throws DAOException {
    throwExceptionIfAmountIsLess(amount,transmitter_id);
    throwexceptionifamountisnegative(amount);
    accountDAO.transfer(transmitter_id, receiver_id, amount);
  }
  
  public List<Account> getList() throws DAOException {
    return accountDAO.getAccounts();
  }
  
  public List<Account> getList(String sql) throws DAOException {
    return accountDAO.getAccounts(sql);
  }

  public List<Transactions> getTransactions(int id) throws DAOException{
    return accountDAO.getTransactions(id);
  }
  
  public void close() throws DAOException {
    accountDAO.close();
  }
  
  public double balance(int id) throws DAOException {
    double balanceV = 0;
      for(Transactions transaction: getTransactions(id)) {
        if(transaction.getType() == MovementType.INGRESO || transaction.getType() == MovementType.TRANSFERENCIA_RECIBIDA) {
          balanceV += transaction.getAmount();
        }else {
          balanceV -= transaction.getAmount();
        }
      } 
      return balanceV;
  }
  
  public void throwexceptionifamountisnegative(double amount) {
    if(amount<= 0) {
      throw new TransactionsIllegalArgumentException("EL importe no puede ser menor o igual a 0");
    }
  }
  
  public void throwExceptionIfAmountIsLess(double amount, int id) throws DAOException {
    if(amount> balance(id)) {
      throw new TransactionsIllegalArgumentException("EL importe no puede ser mayor al saldo");
    }
  }

  public void isLow(int id) throws DAOException {
    if(accountDAO.isLow(id)) {
      throw new TransactionsIllegalArgumentException("Esta cuenta está de baja");
    }
    
  }
  
  
}
