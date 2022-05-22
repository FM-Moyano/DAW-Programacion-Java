package BankGC.src.bankgc.data;

import java.util.List;
import BankGC.src.bankgc.business.Account;
import BankGC.src.bankgc.business.Transactions;


public interface AccountDAO {

  public void add(String customer_id) throws DAOException;

  public void close() throws DAOException;

  public void set(Account account) throws DAOException;

  public Account getAccount(int id) throws DAOException;

  public void unsubscribe(int id) throws DAOException;
  
  public void ingress(int id, double amount) throws DAOException;
  
  public void withdrawals(int id, double amount ) throws DAOException;
  
  public void transfer(int transmitter_id, int receiver_id, double amount) throws DAOException;

  public List<Account> getAccounts() throws DAOException;

  public List<Account> getAccounts(String filter) throws DAOException;

  public List<Transactions> getTransactions(int id) throws DAOException;

  public boolean isLow(int id)throws DAOException;
  
}
