package BankGC.src.bankgc.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOManager {
  
  private Connection connection;

  public DAOManager(Connection connection) {
    this.connection = connection;
  }
  
  public DAOManager(String url, String user, String password) throws DAOException {
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      throw new DAOException("No se puede conectar a la base de datos: " + e.getMessage());
    }
  }

  public CustomerDAO getCustomerDAO() throws DAOException {
    if (connection != null) {  // válido para cualquier base de datos sql
      return new CustomerDAOSql(connection);
    }
    throw new DAOException("No hay conexión establecida con una fuente de datos");
  }
  
  
  public AccountDAO getAccountDAO() throws DAOException {
    if (connection != null) {  // válido para cualquier base de datos sql
      return new AccountDAOSql(connection);
    }
    throw new DAOException("No hay conexión establecida con una fuente de datos");
  }
  
  
  

}
