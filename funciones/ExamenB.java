package funciones;

import java.util.Scanner;

public class ExamenB {
  public static Scanner s = new Scanner(System.in);
  public static String fecha = "";
  public static void main(String[] args) {

    //Menú 
    Boolean menuActivado = true;

    while (menuActivado) {
      int option = menu();

      if (option > 1 && option < 7 && fecha == "") {
        System.out.println("Primero debes introducir una fecha");
        continue;
      }

      switch (option) {
        case 1 -> leerFecha();
        case 2 -> sumarDiasMenu();
        case 3 -> restarDiasMenu();
        case 4 -> comprobarFechasMenu();
        case 5 -> mostrarDiaSemanaMenu();
        case 6 -> System.out.println("La fecha es: " + fecha);
        case 7 -> menuActivado = false;
        default -> System.out.println("Opción incorrecta");
      }

    }

    s.close();
    System.out.println("Adios");

  }









  public static int menu() {
    System.out.println("\nMenú de opciones");
    System.out.println("----------------");
    System.out.println("1. Introducir una fecha entre el 01/01/2000 y el 31/12/2099.\n"
        + "2. Sumar días a la fecha.\n"
        + "3. Restar días a la fecha.\n"
        + "4. Comparar la fecha con otra.\n"
        + "5. Decir el día de la semana de la fecha.\n"
        + "6. Mostrar la fecha.\n"
        + "7. Finalizar.");

    // leo la opción
    System.out.print("\nIntroduce una opción: ");
    int option = s.nextInt();

    // acabo
    s.nextLine();   // vacío buffer de teclado
    System.out.println();
    return option;
  }





  ///////////////////////Metodos//////////////////////////////

  public static void leerFecha() {

    System.out.println("Introduce unba fecha en formato dd/mm/aaaa: ");
    String fechaNueva = s.nextLine();
    if(fechaIsOkey(fechaNueva)){
      fecha = fechaNueva;
    }else {
      System.out.println("La fecha introducida no es correcta");
    }  

  }

  public static void sumarDiasMenu() {
    System.out.println("Introduce un número de días a sumar a la fecha: " + fecha);
    int num = s.nextInt();
    fecha = sumarDias(fecha, num);
  }

  public static void restarDiasMenu() {
    System.out.println("Introduce un número de días a restar a la fecha: " + fecha);
    int num = s.nextInt();
    fecha = restarDias(fecha, num);
  }

  private static void comprobarFechasMenu() {
    System.out.println("Introduce una fecha en formato dd/mm/aaaa para comparar: ");
    String fechaNueva =  s.nextLine();
    if(fechaIsOkey(fechaNueva)){
      if(comprobarFechas(fechaNueva) == 0) {
        System.out.println("IGUALES");
      }else if(comprobarFechas(fechaNueva) == -1) {
        System.out.println("ANTERIOR");
      }else {
        System.out.println("POSTERIOR");
      }

    }else {
      System.out.println("La fecha introducida no es correcta");
    } 
  }

  private static void mostrarDiaSemanaMenu() {
    String[] dia= {"viernes", "sabado", "domingo", "lunes","martes", "miercoles", "jueves"};
    System.out.println(dia[mostrarDiaSemana(fecha)]);
  }

  ////////////////////////////////////////////////////////////////


  public static int pasarADias(String fecha) {
    int dia = Integer.parseInt(fecha.substring(0,2));
    return dia;
  }

  public static int pasarAMes(String fecha) {
    int mes = Integer.parseInt(fecha.substring(3,5));
    return mes;
  }

  public static int pasarAyo(String fecha) {
    int ayo = Integer.parseInt(fecha.substring(6));
    return ayo;
  }



  public static boolean fechaIsOkey(String fecha) {

    if(fecha.length() != 10) {
      return false;

    }
    if(fecha.charAt(2) != '/' || fecha.charAt(5) != '/') {
      return false;
    }

    String diaStr = fecha.substring(0,2);
    String mesStr = fecha.substring(3,5);
    String ayoStr = fecha.substring(6);
    if(!isNumber(ayoStr) || !isNumber(mesStr) || !isNumber(diaStr)) {
      return false;
    }

    if(pasarAyo(fecha) < 2000 || pasarAyo(fecha) > 2099 ) {
      return false;
    }

    if(pasarAMes(fecha) < 1 || pasarAMes(fecha) > 12) {
      return false;
    }

    if(pasarADias(fecha) < 1 || pasarADias(fecha) > numeroDias(pasarAMes(fecha), pasarAyo(fecha))) {
      return false;
    }


    return true;
  }

  private static boolean isNumber(String str) {
    for (char ch: str.toCharArray()) {
      if (!Character.isDigit(ch)) {
        return false;
      }
    }
    return true;
  }

  public static int numeroDias(int mes, int ayo) {
    int diasMeses = 31; // meses por defecto
    if(mes == 4 || mes == 6 || mes == 9 || mes == 11) { // los meses que tiene 30 días
      return diasMeses = 30; 
    }else if(mes == 2) {
      if( ayo % 4 == 0 && (ayo % 100 != 0 || ayo % 400 == 0)) { // si es bisiesto
        return diasMeses = 29;
      }else {
        return diasMeses = 28;
      }
    }
    return diasMeses;
  }



  public static String sumarDias(String fecha, int num) {
    String  fechaNueva = fecha;

    for(int n= 1; n <= num; n++ ) {
      fechaNueva = sumar1Dia(fechaNueva);
    }
    return fechaNueva;
  }

  public static String sumar1Dia(String fecha) {
    int dia = pasarADias(fecha) +1;
    int mes = pasarAMes(fecha);
    int ayo = pasarAyo(fecha);

    if(dia > numeroDias(mes, ayo)) {
      dia = 1;
      mes++;
      if(mes > 12) {
        mes = 1;
        ayo++;
      }
    }

    String fechaNueva = formatearFecha(dia, mes, ayo);
    return fechaNueva;
  }


  public static String formatearFecha(int day, int month, int year) {
    return String.format("%02d/%02d/%04d", day, month, year);
  }



  public static String restarDias(String fecha, int num) {
    String fechaNueva = fecha;
    for(int n = 1; n <= num; n++) {
      fechaNueva = restar1Dia(fechaNueva);
    }
    return fechaNueva;
  }

  public static String restar1Dia(String fecha) {
    int dia = pasarADias(fecha) -1;
    int mes = pasarAMes(fecha);
    int ayo = pasarAyo(fecha);

    if( dia == 0) {
      mes--;
      if(mes == 0) {
        mes = 12;
        ayo--;
      }
      dia = numeroDias(mes, ayo);
    }

    String fechaNueva = formatearFecha(dia, mes, ayo);
    return fechaNueva;
  }

  private static int comprobarFechas(String fechaNueva) {
    return fecha.compareTo(fechaNueva);

  }

  private static int mostrarDiaSemana(String fecha) {

    String viernes = "31/12/1999";
    int diasPasados = 0;
    while(!viernes.equals(fecha)) {
      viernes = sumar1Dia(viernes);
      diasPasados++;
    }

    return diasPasados % 7;
  }

}
