package BankGC.src.bankgc.presentation;

import static BankGC.src.util.Keyboard.*;
import BankGC.src.bankgc.business.Account;
import BankGC.src.bankgc.business.AccountsManager;
import BankGC.src.bankgc.business.CustomerIllegalArgumentException;
import BankGC.src.bankgc.business.TransactionsIllegalArgumentException;
import BankGC.src.bankgc.data.DAOException;
import util.Menu;

public class AccountsManagement {

  private AccountsManager accountsManager;

  public static void main(String[] args) {
    String url = "jdbc:sqlite:C:\\Users\\fmmoy\\OneDrive\\Escritorio\\DAW\\Programacion\\java\\BDD\\cuentasBancarias.db";
    String user = System.getenv("USER");
    String password = System.getenv("PASSWORD");

    try {
      AccountsManagement program = new AccountsManagement(url, user, password);
      program.run();
      System.out.println("¡Hasta la próxima! ;-)");
    } catch (DAOException e) {
      System.err.println("Error al conectar con la base de datos");
      e.printStackTrace();
    }
  }

  public AccountsManagement(String url, String user, String password) throws DAOException {
    accountsManager = new AccountsManager(url, user, password);
  }



  private void run() throws DAOException {
    Menu menu = createMenu();
    int option;
    do {
      option = menu.choose();
      switch (option) {
        case 1 -> list();
        case 2 -> toRegister();
        case 3 -> unsubscribe();
        case 4 -> ingress();
        case 5 -> withdrawals();
        case 6 -> transfer();
      }
    } while (option != menu.lastOption());
  }

  private void transfer() {
    try {
      accountsManager.transfer(readInt("Introduce el numero de cuenta: "), readInt("Introduce el número del cuenta receptora: "), readDouble("Introduce el importe: "));
      System.out.println("\n¡Transferencia realizada!");
    } catch (TransactionsIllegalArgumentException | DAOException e ) {
      System.err.println("La transferencia no se pudo realizar. "+ e.getMessage());
      //e.printStackTrace();
    }
  }


  private void withdrawals() {
    try {
      accountsManager.withdrawals(readInt("Introduce el numero de cuenta"), readDouble("Introduce la cantidad"));
      System.out.println("\n¡Cargo realizado!");
    } catch (TransactionsIllegalArgumentException | DAOException e) {
      System.err.println("No se ha podido realizar el cargo " + e.getMessage());
      //e.printStackTrace();
    }
  }



  private void ingress() {
    try {
      accountsManager.ingress(readInt("Introduce el numero de cuenta"), readDouble("Introduce la cantidad"));
      System.out.println("\n¡Ingreso realizado!");
    } catch ( TransactionsIllegalArgumentException |  DAOException e) {
      System.err.println("No se ha podido realizar el ingreso " + e.getMessage());
      //e.printStackTrace();
    }

  }



  private void unsubscribe() {
    try {
      accountsManager.unsubscribe(readInt("Inserte el número de cuenta"));
      System.out.println("\n¡Baja de cuenta realizada!");
    } catch (DAOException e) {
      System.err.println("Nose ha podido dar de baja la cuenta ");
    }

  }



  private void toRegister() {
    try {
      accountsManager.add(readStr("DNI del cliente de la cuenta"));
      System.out.println("\n¡Cuenta Creada!");
    } catch (CustomerIllegalArgumentException | DAOException e) {
      System.err.println("No se ha podido añadir la cuenta: " + e.getMessage());
    }

  }



  private void list() {
    try {
      for (Account account: accountsManager.getList()) {
        System.out.println(account);
        System.out.println("-------------------------");
      }
    } catch (DAOException e) {
      System.err.println("No se ha podido obtener la lista de cuentas: " + e.getMessage());
    }
  }



  private Menu createMenu() {
    return new Menu("\nGestión de Cuentas del BankGC", "Listado", "Alta de Cuenta", "Baja de Cuenta",
        "Ingreso de cuenta", "Salida de Cuenta","Transferencia", "Terminar");
  }

}
