package ficheros.encriptacionCesar;

import java.util.Scanner;

public class MetdosComunes {

  static final int ARGUMENTS_ERROR = 1;
  static final int READING_ERROR = 2;
  static final int WRITING_ERROR = 3;
  static final int IO_ERROR = 99;

  static Scanner s = new Scanner(System.in);
  static void exitIfWrongArguments(String[] args) {
    if (args.length == 0 || args.length > 2) {
      exitWithError("Número de argumentos erróneo.", ARGUMENTS_ERROR);
    }
  }

  static String getNameTargetFile(String[] args) {
    if (args.length == 2) {
      return args[1];
    }
    confirmFileOverwriting(args[0]);
    return args[0];
  }

  static void confirmFileOverwriting(String nameFile) {
    System.out.println("Tenga en cuenta que este proceso sobreescribirá " + nameFile 
        + " y perderá la información contenida en el mismo.\n");   
    if (!confirm(nameFile)) {
      System.out.println("Proceso cancelado.");
      System.exit(0);
    }
  }

  /*private static boolean confirm() {
    System.out.println("Confirmar? (S/N)");
    String confirm = s.nextLine().toUpperCase();
    do {
      System.out.println("Debes introducir S o N");
    }while(!confirm.equals("S") || !confirm.equals("N") );
    if(confirm.equals("N")) {
      return false; 
    }else {
      return true;
    }

  }*/
  
  public static boolean confirm(String prompt) {
    String resp;
    for (;;) {
      resp = readStr(prompt).toUpperCase();
      if (resp.equals("S") || resp.equals("N")) {
        break;
      }
      System.out.println("Respuesta incorrecta, pulse S o N y después Intro");
    }
    return resp.equals("S");
  }

  static int readKey() {
    int key;
    do {
      System.out.println("Clave (positiva) de la encriptación César");
      key = s.nextInt();
    } while (key <= 0); 
    return key;
  }

  static void exitWithError(String message, int codeError) {
    System.err.println(message);
    System.exit(codeError);
  }
  
  public static String readStr(String prompt) {
    System.out.print(prompt + ": ");
    return s.nextLine();
  }
}
