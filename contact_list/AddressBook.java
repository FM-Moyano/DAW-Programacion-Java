 package contact_list;

 /**
  * 
  * Autor: @author fmmoy
  * 
  * Test de las clase agenda
  * 
  * 
  * 
  */
 
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import util.Menu;
import util.Util;

public class AddressBook {

  private static Agenda agenda =  new Agenda();

  public static void main(String[] args) {
    
    Menu menu = createMenu();    

    int option;
    do {
      option = menu.choose();
      switch (option) {
        case 1 -> XMlReading();
        case 2 -> list();
        case 3 -> addContact();
        case 4 -> show();
        case 5 -> delete();
        case 6 -> exportXML();

      }
    } while (option != menu.lastOption());

    System.out.println("¡Hasta la próxima! ;-)");
  }


  private static Menu createMenu() {
    return new Menu("\nMenú de opciones",
        "Crear agenda desde fichero", "Listar", "Añadir contacto", "Mostrar contacto",
        "Borrar contacto", "Exportar agenda a fichero", "Terminar");
  }

  static void XMlReading() {
      try {
        agenda.XMlReading(Util.readStr("Escribe el nombre del fichero: "));
      } catch (SAXException e) {
        System.err.println("Error de lectura");

      } catch (IOException e) {
        System.err.println("Error de lectura");

      } catch (ParserConfigurationException e) {
        System.err.println("Error de lectura");

      } catch (InvalidAddressException e) {
        System.err.println("Error de lectura");

      } catch (InvalidPhoneException e) {
        System.err.println("Error de lectura");

      } catch (InvalidMailException e) {
        System.err.println("Error de lectura");

      }
    
  }
  
  static void list() {
    System.out.println(agenda);
  }
  
  static void addContact() {
    try {
      agenda.add(Util.readStr("Inserte el nombre: "), Util.readStr("Inserte el teléfono"), 
          Util.readStr("Inserte el correo"), Util.readStr("Inserte la direccion"));
    } catch (InvalidAddressException e) {
      System.err.println(e.getMessage());
    } catch (InvalidPhoneException e) {
      System.err.println(e.getMessage());
    } catch (InvalidMailException e) {
      System.err.println(e.getMessage());
    } catch (ExceptionAgendaSize e) {
      System.err.println(e.getMessage());
    }
    System.out.println("Contacto añadido");
  }
  
  
  static void show() {
    System.out.println(agenda.get(Util.readStr("Introduce el nombre")));
  }
  
  static void delete() {
    try {
      agenda.remove(Util.readStr("Introduce el nombre"));
    } catch (ExceptionContacNotExist e) {
      System.err.println(e.getMessage());
    }
    System.out.println("Contacto borrado");
  }
  
  static void exportXML() {
    try {
      agenda.exportXML(Util.readStr("Introduce el nombre del archivo a exportar(sin añadirle extension)"));
    } catch (TransformerException e) {
      System.err.println("ERROR de escritura");
    } catch (ParserConfigurationException e) {
      System.err.println("ERROR de escritura");
    } catch (IOException e) {
      System.err.println("ERROR de escritura");
    }
    
  }

}
