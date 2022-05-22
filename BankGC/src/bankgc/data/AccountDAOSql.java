package BankGC.src.bankgc.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import BankGC.src.bankgc.business.Account;
import BankGC.src.bankgc.business.CustomersManager;
import BankGC.src.bankgc.business.MovementType;
import BankGC.src.bankgc.business.Transactions;


public class AccountDAOSql implements AccountDAO{
  
  private Connection connection;

  public AccountDAOSql(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(String customer_id) throws DAOException {
    String sql = "INSERT INTO ACCOUNTS (customer_id, alive) VALUES ('" + customer_id 
    + "', 1)";
    CustomersManager customersManager = new CustomersManager(new DAOManager(connection));
    customersManager.get(customer_id);
    executeUpdate(sql);
    
  }

  @Override
  public void close() throws DAOException {
    try {
      connection.close();
    } catch (SQLException e) {
      throw new DAOException(e);
    }
    
  }

  @Override
  public void set(Account account) throws DAOException {
    String sql =
        "UPDATE ACCOUNTS SET customer_id ='" + account.getCustomer_id() + "',alive='" + account.getAlive()
            + "' WHERE id='" + account.getId()+ "'";
    int rowsUpdated = executeUpdate(sql);
    if (rowsUpdated == 0) {
      throw new DAOException("No existe ninguna cuenta con ese id " + account.getId());
    }
    
  }

  @Override
  public Account getAccount(int id) throws DAOException {
    String sql = "SELECT * FROM ACCOUNTS WHERE id='" + id + "'";
    try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);) {
      if (!resultset.next()) {
        throw new DAOException("El ID " + id + " no existe en la base de datos");
      }
      return new Account(id, resultset.getString("customer_id"), resultset.getInt("alive"));
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }
  
  

  @Override
  public void unsubscribe(int id) throws DAOException {
    String sql =
        "UPDATE ACCOUNTS SET alive=0 WHERE id=" + id + "'";
    int rowsUpdated = executeUpdate(sql);
    if (rowsUpdated == 0) {
      throw new DAOException("No existe ninguna cuenta con ese ID " + id);
    }
    
  }

  @Override
  public List<Account> getAccounts() throws DAOException {
    return getAccounts("SELECT * FROM ACCOUNTS");
  }

  @Override
  public List<Account> getAccounts(String sql) throws DAOException {
    try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);) {
      List<Account> list = new ArrayList<>();
      while (resultset.next()) {
        list.add(new Account(resultset.getInt("id"), resultset.getString("customer_id"),
            resultset.getInt("alive")));
      }
      return list;
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }
  
  private int executeUpdate(String sql) throws DAOException {
    try (Statement statement = connection.createStatement()) {
      return statement.executeUpdate(sql);
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }

 

  @Override
  public void ingress(int id, double amount) throws DAOException {
    Transactions transactions = new Transactions(id, amount, MovementType.INGRESO);
    String sql = "INSERT INTO TRANSACTIONS (account_id, amount,datetime,type) VALUES (" + transactions.getAccount_id() 
        + ","+ transactions.getAmount() + ", '" + transactions.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString() +"','" + transactions.getType()+ "')";
    getAccount(id);    
    executeUpdate(sql);
    
  }

  @Override
  public void withdrawals(int id, double amount) throws DAOException {
    Transactions transactions = new Transactions(id, amount, MovementType.CARGO);
    String sql = "INSERT INTO TRANSACTIONS (account_id, amount,datetime,type) VALUES (" + transactions.getAccount_id() 
        + ","+ transactions.getAmount() + ", '" + transactions.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString() +"','" + transactions.getType() + "')";
    getAccount(id);    
    executeUpdate(sql);
    
        
  }

  @Override
  public void transfer(int transmitter_id, int receiver_id, double amount) throws DAOException {
    Transactions transactionsE = new Transactions(transmitter_id, amount, MovementType.TRANSFERENCIA_ENVIADA,receiver_id);
    Transactions transactionsR = new Transactions(receiver_id, amount, MovementType.TRANSFERENCIA_RECIBIDA,transmitter_id);

    String sql = "INSERT INTO TRANSACTIONS VALUES (" + transactionsE.getAccount_id() 
        + ","+ transactionsE.getAmount() + ", '" + transactionsE.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString()
        +"','" + transactionsE.getType() + "',"+ transactionsE.getTransferAccountNumber() +")";
    String sql1 = "INSERT INTO TRANSACTIONS VALUES (" + transactionsR.getAccount_id() 
    + ","+ transactionsR.getAmount() + ", '" + transactionsR.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString()
    +"','" + transactionsR.getType() + "',"+ transactionsR.getTransferAccountNumber() +")";
    
    getAccount(receiver_id);
    getAccount(transmitter_id);
        executeUpdate(sql);
        executeUpdate(sql1);
    
  }

  @Override
  public List<Transactions> getTransactions(int id) throws DAOException {
    String sql = "SELECT * FROM TRANSACTIONS WHERE ACCOUNT_ID = " + id;
    try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);) {
      List<Transactions> list = new ArrayList<>();
      while (resultset.next()) {
        LocalDateTime date = LocalDateTime.parse(resultset.getString("datetime"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        MovementType type = MovementType.valueOf(resultset.getString("type"));
        list.add(new Transactions(resultset.getInt("account_id"), resultset.getDouble("amount"),
            date, type,resultset.getInt("num_account_transfer")));
      }
      return list;
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }

  @Override
  public boolean isLow(int id) throws DAOException {
    String sql = "SELECT ALIVE FROM ACCOUNTS WHERE ID ="  + id ;
    try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);) {
      int alive = resultset.getInt("ALIVE");
      if(alive == 1) {
        return false;
      }else {
        return true;
      }
      
  } catch (SQLException e) {
    throw new DAOException(e);
  }

  }
}
  
