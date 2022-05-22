package BankGC.src.bankgc.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import BankGC.src.bankgc.business.Customer;

public class CustomerDAOSql implements CustomerDAO {

  private Connection connection;

  public CustomerDAOSql(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Customer customer) throws DAOException {
    String sql = "INSERT INTO CUSTOMERS (dni, name, address, phone) VALUES ('" + customer.getDni()
    + "','" + customer.getName() + "','" + customer.getAddress() + "','" + customer.getPhone()
    + "')";
    executeUpdate(sql);
  }

  @Override
  public void set(Customer customer) throws DAOException {
    String sql =
        "UPDATE CUSTOMERS SET name='" + customer.getName() + "',address='" + customer.getAddress()
        + "',phone='" + customer.getPhone() + "' WHERE dni='" + customer.getDni() + "'";
    int rowsUpdated = executeUpdate(sql);
    if (rowsUpdated == 0) {
      throw new DAOException("No existe ningún cliente con dni " + customer.getDni());
    }
  }

  @Override
  public void removeCustomer(String dni) throws DAOException {
    String sql = "DELETE FROM CUSTOMERS WHERE dni='" + dni + "'";
    int rowsDeleted = executeUpdate(sql);
    if (rowsDeleted == 0) {
      throw new DAOException("No existe ningún cliente con dni " + dni);
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
  public Customer getCustomer(String dni) throws DAOException {
    String sql = "SELECT * FROM CUSTOMERS WHERE dni='" + dni + "'";
    try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);) {
      if (!resultset.next()) {
        throw new DAOException("El DNI " + dni + " no existe en la base de datos");
      }
      return new Customer(dni, resultset.getString("name"), resultset.getString("address"),
          resultset.getString("phone"));
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }

  @Override
  public List<Customer> getCustomers() throws DAOException {
    return getCustomers("SELECT * FROM CUSTOMERS ORDER BY name");
  }

  @Override
  public List<Customer> getCustomers(String sql) throws DAOException {
    try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);) {
      List<Customer> list = new ArrayList<>();
      while (resultset.next()) {
        list.add(new Customer(resultset.getString("dni"), resultset.getString("name"),
            resultset.getString("address"), resultset.getString("phone")));
      }
      return list;
    } catch (SQLException e) {
      throw new DAOException(e);
    }
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
  public void haveAccount(String dni) throws DAOException {
    String sql = "SELECT * FROM ACCOUNTS WHERE customer_id= '" + dni + "'";
    try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);) {
      if(resultset.next()) {
        throw new DAOException("El cliente tiene cuenta");
      }
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }
}
