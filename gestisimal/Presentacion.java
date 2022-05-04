package gestisimal;

import util.Menu;
import util.Util;

/**
 * Programa para probar la clase Warehouse.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Presentacion {

  private static Almacen warehouse = new Almacen();

  public static void main(String[] args) {
    Menu menu = createMenu();    
    //fillWarehouse();  // valores de prueba

    int option;
    do {
      option = menu.choose();
      switch (option) {
        case 1 -> showWarehouse();
        case 2 -> addArticle();
        case 3 -> removeArticle();
        case 4 -> modifyArticle();
        case 5 -> increaseStock();
        case 6 -> decreaseStock();
        case 7 -> save();
        case 8 -> importFileXML();
        case 9 -> importFileJson();
      }
    } while (option != menu.lastOption());

    System.out.println("¡Hasta la próxima! ;-)");
  }



  private static Menu createMenu() {
    return new Menu("\nMenú de opciones",
        "Listado", "Alta de artículo", "Baja de artículo", "Modificación de artículo",
        "Entrada de mercancía", "Salida de mercancía", "Guardar","Importar fichero XML", "Importar desde Json", "Terminar");
  }

  /*private static void fillWarehouse() {
    for (int i = 1; i <= 5; i++) {
      try {
        warehouse.add("Artículo" + i, "Marca" + i, Util.randomInt(1, 100), 
            Util.randomInt(10, 100), Util.randomInt(50, 500));
      } 
      catch (ExcepcionNumeroNegativo e) {
        e.printStackTrace();
      }
    }
  }*/

  private static void showWarehouse() {
    System.out.println(warehouse);
  }

  private static void addArticle() {
    try {
      warehouse.add(Util.readStr("Nombre de artículo a dar de alta"), Util.readStr("Marca"), 
          Util.readDouble("Precio compra"), Util.readDouble("Precio venta"), Util.readInt("Unidades"), 
          Util.readInt("Stock de seguridad"), Util.readInt("Stock máximo"));
    } 
    catch (ExcepcionNumeroNegativo e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void removeArticle() {
    warehouse.remove(Util.readInt("Código de artículo a dar de baja")); 
  }

  private static void modifyArticle() {
    try {
      Articulo article = warehouse.get(Util.readInt("Código de artículo a modificar"));
      warehouse.modify(article.getCodigo(), Util.read("Nombre", article.getNombre()), 
          Util.read("Marca", article.getMarca()), Util.read("Unidades", article.getNumeroDeUnidades()),
          Util.read("Precio compra", article.getPrecioDeCompra()), 
          Util.read("Precio venta", article.getPrecioDeVenta()), 
          Util.read("Stock de seguridad", article.getStockDeSeguridad()), 
          Util.read("Stock máximo", article.getStockMaximo())); 
    } 
    catch (NumberFormatException e) {
      System.err.println("El formato numérico introducido es incorrecto");
    } catch (WarehouseArticleNotExistsException e) {
      // TODO Auto-generated catch block
      printCodeError();

    } catch (ExcepcionNumeroNegativo e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void increaseStock() {
    warehouse.increaseStock(Util.readInt("Código del artículo del que entra mercancía"), 
        Util.readInt("Unidades"));
  }

  private static void decreaseStock() {
    warehouse.decreaseStock(Util.readInt("Código del artículo del que sale mercancía"), 
        Util.readInt("Unidades"));
  }

  private static void save() {
    warehouse.xml();
    warehouse.json();

  }

  private static void importFileXML() {
    warehouse.leerXML();
  }

  private static void importFileJson() {
    warehouse.leerJson();
  }

  private static void printCodeError() {
    System.err.println("ERROR: Ese código no corresponde a ningún artículo.");
  }

}
