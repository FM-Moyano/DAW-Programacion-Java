package util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {
  private static Scanner in = new Scanner(System.in);

  public static int randomInt(int min, int max) {
    return min + (int) (Math.random() * (max-min+1));
  }

  public static String readStr(String prompt) {
    System.out.print(prompt + ": ");
    return in.nextLine();
  }

  public static int readInt(String prompt) {
    System.out.print(prompt + ": ");
    int n = in.nextInt();
    in.nextLine();  // sacamos \n del buffer de teclado
    return n;
  }

  public static boolean isDateOk(String date) {
    try {
      LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }

  public static boolean esPrimo(int x) {
    for (int i = 2; i < x; i++) {
      if ((x % i) == 0) {
        return false;
      }
    }
    return true;
  }

  public static void argumentoVacio(String[] args) {
    if(args.length == 0) {
      System.err.println("Error no tiene ningún argumento.");
      System.exit(1);
    }
  }



  public static String readStr(String prompt, String end) {
    String str = readStr(prompt);
    System.out.print(end);
    return str;
  }



  public static int readInt(String prompt, String end) {
    int n = readInt(prompt);
    System.out.print(end);
    return n;
  }

  public static double readDouble(String prompt) {
    System.out.print(prompt + ": ");
    double n = in.nextDouble();
    in.nextLine();  // sacamos \n del buffer de teclado
    return n;
  }

  public static double readDouble(String prompt, String end) {
    double n = readDouble(prompt);
    System.out.print(end);
    return n;
  }

  public static double[] readIntArrayNotas(String prompt) {
    List<Double> numeros = new ArrayList<>();

    //int numero =  Util.readInt("Introduce numeros hasta introducir -1 ");
    double numero =0;
    
    
    /*while(numero != -1) {
      numero = Util.readInt("Introduce numeros hasta introducir -1 ");
           
      if(numero >10) {
        System.out.println("El numero debe estar entre 0 y 10");
        numero = Util.readInt("Introduce numeros hasta introducir -1 ");
      } else {
        numeros.add(numero);
      }
      
    }*/
    
    do {
      if(numero >10 || numero < 0) {
        System.out.println("Las notas debe estar entre 0 y 10");
        //numero = Util.readInt("Introduce numeros hasta introducir -1 ");
      } else {
        numeros.add(numero);
      }
      numero = Util.readDouble("Introduce notas hasta introducir -1 ");
    }while(numero!= -1);
    
    double[] numerosArray = new double[numeros.size()-1];

    for(int i = 0 ; i < numeros.size()-1; i++) { 
      numerosArray[i] = numeros.get(i+1);
    }
    return numerosArray;
  }

  public static boolean confirm(String prompt) {
    String resp;
    for (;;) {
      resp = Util.readStr(prompt).toUpperCase();
      if (resp.equals("S") || resp.equals("N")) {
        break;
      }
      System.out.println("Respuesta incorrecta, pulse S o N y después Intro");
    }
    return resp.equals("S");
  }

  public static boolean confirm() {
    return confirm("¿Está seguro/a? (S/N)");
  }

  public static double read(String prompt, double defaultValue) {
    String returnValue = readStr(prompt + " [" + defaultValue + "]");
    return returnValue.isEmpty() ? defaultValue : Double.parseDouble(returnValue);
  }

  public static int read(String prompt, int defaultValue) {
    String returnValue = readStr(prompt + " [" + defaultValue + "]");
    return returnValue.isEmpty() ? defaultValue : Integer.parseInt(returnValue);
  }

  public static String read(String prompt, String defaultValue) {
    String returnValue = readStr(prompt + " [" + defaultValue + "]");
    return returnValue.isEmpty() ? defaultValue : returnValue;
  }

}
