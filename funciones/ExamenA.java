package funciones;

import java.util.Scanner;

public class ExamenA {
  public static Scanner s = new Scanner(System.in);
  public static String tiempo ="";

  public static void main(String[] args) {

    Boolean menuActivo = true;
    
    while(menuActivo) {
      int option = menu();
      
      if(option > 1 && option < 10 && tiempo == "") {
        System.out.println("Tienes que introducir antes un tiempo");
        System.out.println();
        continue;
      }
      
      switch (option) {
        case 1 -> introducir();
        case 2 -> sumarSegundosMenu();
        case 3 -> restarSegundosMenu();
        case 4 -> sumarMinutosMenu();
        case 5 -> restarMinutosMenu();
        case 6 -> sumarHorasMenu();
        case 7 -> restarHorasMenu();
        case 8 -> compararMenu();
        case 9 -> System.out.println(tiempo);
        case 10 -> menuActivo = false;
        
        
        default -> System.out.println("No has introducido una opción correcta.");
      }
    }
    
    System.out.println("Adios!!!");
  }
 
  
  
  
  




  //////////////MENú/////////////////
  public static int menu() {
    System.out.println();
    System.out.println("      Menú de opciones\n"
        +"---------------------------------\n"
        +"1. Introducir valor del tiempo.\n"
        +"2. Sumar segundos.\n"
        +"3. Restar segundos.\n"
        +"4. Sumar minutos.\n"
        +"5. Restar minutos.\n"
        +"6. Sumar horas\n"
        +"7. Restar horas\n"
        +"8. Comparar tiempos.\n"
        +"9. Mostrar tiempo. \n"
        +"10. Terminar\n");
    System.out.println("Introduce una opción: ");
    int option = s.nextInt();

    // acabo
    s.nextLine();   // vacío buffer de teclado
    System.out.println();
    return option;
    
  }
  
  
  //////Metodos menú////////////
  
  public static void introducir() {
    System.out.println("Introduce un tiempo en formato hh:mm:ss: ");
    String tiempoNuevo = s.nextLine();
    if(isOkeyTiempo(tiempoNuevo)) {
      tiempo = tiempoNuevo;
    }else {
      System.out.println("El tiempo intoducido no es valido");
    }
  }
  
  public static void sumarSegundosMenu() {
    System.out.println("Introduce el número de segundos que quieres sumar: ");
    int num = s.nextInt();
    tiempo = sumarSegundos(tiempo, num);
  }

  public static void restarSegundosMenu() {
    System.out.println("Introduce el número de segundos que quieres restar: ");
    int num = s.nextInt();
    tiempo = restarSegundos(tiempo, num);
  }
  
  public static void sumarMinutosMenu() {
    System.out.println("Introduce el número de minutos que quieres sumar: ");
    int num = s.nextInt() * 60;
    tiempo = sumarSegundos(tiempo, num);
  }
  
  public static void restarMinutosMenu() {
    System.out.println("Introduce el número de minutos que quieres restar: ");
    int num = s.nextInt()*60;
    tiempo = restarSegundos(tiempo, num);
  }
  
  public static void sumarHorasMenu() {
    System.out.println("Introduce el número de horas que quieres sumar: ");
    int num = s.nextInt() * 3600;
    tiempo = sumarSegundos(tiempo, num);
    
  }
  
  public static void restarHorasMenu() {
    System.out.println("Introduce el número de Horas que quieres restar: ");
    int num = s.nextInt()*3600;
    tiempo = restarSegundos(tiempo, num);
  }

  public static void compararMenu() {
    System.out.println("Introduce un tiempo en formato hh:mm:ss para comparar con " + tiempo);
    String tiempoNuevo = s.nextLine();
    if(isOkeyTiempo(tiempoNuevo)) {
      if(comparar(tiempoNuevo) == -1) {
        System.out.println("Anterior");
        System.out.println();
      }else if(comparar(tiempoNuevo)==0) {
        System.out.println("Iguales");
        System.out.println();
      }else {
        System.out.println("Posterior");
        System.out.println();
      }
    }else {
      System.out.println("El tiempo introducida es incorrecta");
    }
    
    
  }


 









  private static boolean isOkeyTiempo(String tiempoNuevo) {
    
    if(tiempoNuevo.length() != 8) {
      return false;
    }
    if(tiempoNuevo.charAt(2) != ':' || tiempoNuevo.charAt(5) != ':') {
      return false;
    }
    
    String horasStr = tiempoNuevo.substring(0,2);
    String minutosStr = tiempoNuevo.substring(3,5);
    String segundosStr = tiempoNuevo.substring(6);
    
    if(!esNumero(horasStr) || !esNumero(minutosStr) || !esNumero(segundosStr)) {
      return false;
    }
    
    if(pasarAHoras(tiempoNuevo) > 23 || pasarAHoras(tiempoNuevo) < 0) {
      return false;
    }
    if(pasarAMinutos(tiempoNuevo) > 59 || pasarAMinutos(tiempoNuevo) < 0 || pasarASegundos(tiempoNuevo) > 59 || pasarASegundos(tiempoNuevo) < 0) {
      return false;
    }
    
    return true;
  }



  private static boolean esNumero(String str) {
    for(char ch : str.toCharArray() ) {
      if(!Character.isDigit(ch)) {
        return false;
      }
    }
    return true;
  }
  
  private static int pasarAHoras(String tiempoNuevo) {
    int horas = Integer.parseInt(tiempoNuevo.substring(0,2));
    return horas;
  }
  
  private static int pasarAMinutos(String tiempoNuevo) {
    int minutos = Integer.parseInt(tiempoNuevo.substring(3,5));
    return minutos;
  }

  private static int pasarASegundos(String tiempoNuevo) {
    int segundos = Integer.parseInt(tiempoNuevo.substring(6));
    return segundos;
  }
  
  private static String sumarSegundos(String tiempo, int num) {
    String tiempoNuevo = tiempo;
    for(int n = 1; n <= num ; n++) {
      tiempoNuevo = sumar1Segundo(tiempoNuevo);
    }
    return tiempoNuevo;
  }



  private static String sumar1Segundo(String tiempo) {
    int horas = pasarAHoras(tiempo);
    int minutos = pasarAMinutos(tiempo);
    int segundos = pasarASegundos(tiempo)+1;
    
    if(segundos > 59) {
      segundos = 0;
      minutos++;
      if(minutos > 59) {
        minutos = 0;
        horas++;
        if(horas > 23) {
          //segundos = 0;
          //minutos = 0;
          horas = 0;
        }
      }
    }
    
    String tiempoNuevo = formatearTiempo(horas, minutos, segundos);
    return tiempoNuevo;
  }


private static String restarSegundos(String tiempo, int num) {
  String tiempoNuevo = tiempo;
  for(int n = 1; n <= num; n++) {
    tiempoNuevo =  restar1Segundo(tiempoNuevo);
  }
  return tiempoNuevo;
}

private static String restar1Segundo(String tiempo) {
  int horas = pasarAHoras(tiempo);
  int minutos = pasarAMinutos(tiempo);
  int segundos = pasarASegundos(tiempo)-1;
  
  if(segundos < 0) {
    segundos = 59;
    minutos--;
    if(minutos < 0) {
      minutos = 59;
      horas--;
      if(horas < 0) {
        horas = 23;
      }
    }
  }
  String tiempoNuevo = formatearTiempo(horas, minutos, segundos);
  return tiempoNuevo;
}


  private static String formatearTiempo(int horas, int minutos, int segundos) {
    
    return String.format("%02d:%02d:%02d", horas, minutos, segundos);
  }
  
  private static int comparar(String tiempoNuevo) {
    return tiempoNuevo.compareTo(tiempo);
  }
}
