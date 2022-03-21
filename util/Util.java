package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
}
