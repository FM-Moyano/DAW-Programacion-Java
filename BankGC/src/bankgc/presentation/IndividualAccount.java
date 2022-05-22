package BankGC.src.bankgc.presentation;


import BankGC.src.bankgc.business.AccountsManager;
import BankGC.src.bankgc.business.Transactions;
import BankGC.src.bankgc.business.TransactionsIllegalArgumentException;
import BankGC.src.bankgc.data.DAOException;
import util.Menu;
import static BankGC.src.util.Keyboard.*;

public class IndividualAccount {

  private AccountsManager accountsManager;
  private static int id; 

  public static void main(String[] args) throws DAOException {
    exitIFErrorArgs(args);
    String url = "jdbc:sqlite:C:\\Users\\fmmoy\\OneDrive\\Escritorio\\DAW\\Programacion\\java\\BDD\\cuentasBancarias.db";
    String user = System.getenv("USER");
    String password = System.getenv("PASSWORD");

    id = Integer.parseInt(args[0]);

    try {
      IndividualAccount program = new IndividualAccount(url, user, password);
      program.run();
      System.out.println("¡Hasta la próxima! ;-)");
    } catch (DAOException e) {
      System.err.println("Error al conectar con la base de datos");
      e.printStackTrace();
    }

  }

  private static void exitIFErrorArgs(String[] args) {
    if(args.length !=1) {
      System.err.println("Número de argumentos erróneo.");
      System.exit(1);
    }

    try {
      Integer.parseInt(args[0]);
    }catch (NumberFormatException e) {
      System.err.println("El argumento no es un número de cuenta. ");
      System.exit(2);
    } 
  }

  public IndividualAccount(String url, String user, String password) throws DAOException {
    accountsManager = new AccountsManager(url, user, password);
    accountsManager.isLow(id);
    //accountsManager.getAccount(id);
  }

  private void run() throws DAOException {
    Menu menu = createMenu();
    int option;

    do {
      option = menu.choose();

      /*if (option > 1 && option < 6 && id==0) {
        System.out.println("Primero debe introducir una fecha.\n");
        continue;
      }*/
      switch (option) {
        case 1 -> listMovements();
        case 2 -> balance();
        case 3 -> ingress();
        case 4 -> withdrawals();
        case 5 -> transfer();
      }
    } while (option != menu.lastOption());
    accountsManager.close();
  }

  /*private void enterAccountNumber() {

    try {
      int id2 = readInt("Introduce el número de cuenta");
      accountsManager.getAccount(id2);
      accountsManager.isLow(id);
      id = id2;
    } catch (DAOException e) {
      System.err.println(e.getMessage());
    }
  }*/

  private void listMovements() {
    try {
      for (Transactions transaction: accountsManager.getTransactions(id)) {
        System.out.println(transaction);
        System.out.println("-------------------------");
      }
    } catch (DAOException e) {
      System.err.println("No se ha podido obtener la lista de cuentas: " + e.getMessage());
    }
  }

  private void balance() {

    try {
      double balance = accountsManager.balance(id);
      System.out.println("Saldo Actual: " + balance);
    } catch (DAOException e) {
      System.err.println("Error en el saldo" +e.getMessage() );
    }
  }

  private void ingress() {
    try {
      accountsManager.ingress(id, readDouble("Introduce la cantidad"));
      System.out.println("\n¡Ingreso realizado!");
    } catch (TransactionsIllegalArgumentException | DAOException e) {
      System.err.println("No se ha podido realizar el ingreso" + e.getMessage());
      //e.printStackTrace();
    }
  }

  private void transfer() {
    try {
      accountsManager.transfer(id, readInt("Introduce el número del cuenta receptora: "), readDouble("Introduce el importe: "));
      System.out.println("\n¡Transferencia realizada!");
    } catch (TransactionsIllegalArgumentException | DAOException e) {
      System.err.println("La transferencia no se pudo realizar." + e.getMessage());
    }
  }



  private void withdrawals() {
    try {
      accountsManager.withdrawals(id, readDouble("Introduce la cantidad"));
      System.out.println("\n¡Cargo realizado!");
    } catch (TransactionsIllegalArgumentException | DAOException e) {
      System.err.println("No se ha podido realizar el cargo " + e.getMessage());
      //e.printStackTrace();
    }

  }


  private Menu createMenu() {
    return new Menu("\nGestión de Cuenta de usuario "+ id +" del BankGC",  "Listar los movimientos", "Ver saldo",
        "Ingreso de cuenta", "Salida de Cuenta","Transferencia", "Terminar");
  }

}
