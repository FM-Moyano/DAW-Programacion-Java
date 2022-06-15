package Instituto;

/**
 * @author fmmoy
 * 
 *  1. Crear curso desde fichero (JSON).
    2. Listar curso.
    3. Añadir estudiante (pide DNI, nombre y notas).
    4. Mostrar estudiante (pide DNI y muestra el nombre, notas y media de las mismas).
    5. Borrar estudiante (pide DNI y si existe lo borra, si no es así lo indica).
    6. Exportar curso a fichero (JSON).
    7. Terminar.
 * 
 */

import util.Util;
import java.io.IOException;
import util.Menu;

public class Notas {

  private static Curso curso =  new Curso();

  public static void main(String[] args) {


    Menu menu = createMenu();    

    int option;
    do {
      option = menu.choose();
      switch (option) {
        case 1 -> crearDesdeFichero();
        case 2 -> listar();
        case 3 -> addEstudiante();
        case 4 -> mostrarEstudiante();
        case 5 -> borrarEstudiante();
        case 6 -> exportarFichero();

      }
    } while (option != menu.lastOption());

    System.out.println("¡Hasta la próxima! ;-)");
  }


  private static Menu createMenu() {
    return new Menu("\nMenú de opciones",
        "Crear curso desde fichero", "Listar", "Añadir estudiante", "Mostrar estudiante",
        "Borrar estudiante", "Exportar curso a fichero", "Terminar");
  }

  static void crearDesdeFichero() {
    try {
      curso.lecturaJson(Util.readStr("Escribe el nombre del fichero: "));
    } catch (IOException e) {
      System.err.println("Error de lectura");
    }
  }

  static void listar() {
    System.out.println(curso);
  }

  static void addEstudiante() {
    try {
      curso.alta(Util.readStr("DNI del alumno"), Util.readStr("Nombre del alumno"), 
          Util.readIntArrayNotas("Inserte las notas"));
    }catch (StringIndexOutOfBoundsException e) {
      System.err.println("DNI incorrecto");
    }catch (NumberFormatException e) {
      System.err.println("DNI incorrecto");
    }

  }  

  static void mostrarEstudiante() {
    System.out.println(curso.get(Util.readStr("Introduce el DNI del Alumno: ")).toStringMedia());
  }

  static void borrarEstudiante() {
    try {
      curso.baja(Util.readStr("Introduce el DNI del alumno a borrar"));
      System.out.println("Alumno borrado");
    } catch (ExceptionAlumnoNoExiste e) {
      System.err.println(e.getMessage());
    }
  }

  static void exportarFichero() {
    try {
      curso.exportar(Util.readStr("Introduce el nombre del archivo a exportar(sin añadirle extension)"));
    } catch (IOException e) {
      System.err.println("Error al crear el archivo");
    }
  }

}
