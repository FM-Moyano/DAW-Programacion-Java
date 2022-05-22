package BankGC.src.bankgc.presentation;

import static BankGC.src.util.Keyboard.*;
import BankGC.src.bankgc.business.Customer;
import BankGC.src.bankgc.business.CustomerIllegalArgumentException;
import BankGC.src.bankgc.business.CustomersManager;
import BankGC.src.bankgc.data.DAOException;
import util.Menu;

public class CustomersManagement {

  private CustomersManager customersManager;

  public static void main(String[] args) {
    String url = "jdbc:sqlite:C:\\Users\\fmmoy\\OneDrive\\Escritorio\\DAW\\Programacion\\java\\BDD\\cuentasBancarias.db";
    String user = System.getenv("USER");
    String password = System.getenv("PASSWORD");

    try {
      CustomersManagement program = new CustomersManagement(url, user, password);
      program.run();
      System.out.println("¡Hasta la próxima! ;-)");
    } catch (DAOException e) {
      System.err.println("Error al conectar con la base de datos");
      e.printStackTrace();
    }
  }

  public CustomersManagement(String url, String user, String password) throws DAOException {
    customersManager = new CustomersManager(url, user, password);
  }

  private void run() throws DAOException {
    Menu menu = createMenu();
    int option;
    do {
      option = menu.choose();
      switch (option) {
        case 1 -> list();
        case 2 -> add();
        case 3 -> remove();
        case 4 -> modify();
        case 5 -> show();
      }
    } while (option != menu.lastOption());
    customersManager.close();
  }

  private void list() {
    try {
      for (Customer customer: customersManager.getList()) {
        System.out.println(customer);
        System.out.println("---");
      }
    } catch (DAOException e) {
      System.err.println("No se ha podido obtener la lista de clientes: " + e.getMessage());
    }
  }

  private void add() {
    try {
      customersManager.add(readStr("DNI del cliente a añadir"), readStr("Nombre"), readStr("Dirección"),
          readStr("Teléfono"));
      System.out.println("\n¡Cliente añadido!");
    } catch (CustomerIllegalArgumentException | DAOException e) {
      System.err.println("No se ha podido añadir el cliente: " + e.getMessage());
    }
  }

  private void remove() {
    try {
      customersManager.remove(readStr("DNI del cliente a borrar"));
      System.out.println("\n¡Cliente borrado!");
    } catch (DAOException e) {
      System.err.println("No se ha podido borrar el cliente: " + e.getMessage());
    }
  }

  private void modify() {
    try {
      Customer customer = customersManager.get(readStr("DNI del cliente a modificar"));
      customersManager.set(customer.getDni(), read("Nombre", customer.getName()),
          read("Dirección", customer.getAddress()), read("Teléfono", customer.getPhone()));
      System.out.println("\n¡Cliente modificado!");
    } catch (CustomerIllegalArgumentException | DAOException e) {
      System.err.println("No se ha podido modificar el cliente: " + e.getMessage());
    }
  }

  private void show() {
    try {
      Customer customer = customersManager.get(readStr("DNI del cliente a mostrar"));
      System.out.println("\n" + customer);
    } catch (DAOException e) {
      System.err.println("El DNI no existe en la base de datos.");
    }
  }

  private Menu createMenu() {
    return new Menu("\nGestión de clientes del BankGC", "Listado", "Alta de cliente", "Baja de cliente",
        "Modificación de cliente", "Mostrar cliente", "Terminar");
  }
}
