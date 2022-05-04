package gestisimal;

public class TestAlmacen {

  public static void main(String[] args) {

    Almacen almacen = new Almacen();
    try {
      almacen.add("pipas", "tijuana", 12, 15, 12,10, 20);
      almacen.add("Caracoles", "spress", 12, 15, 12,10, 20);
      almacen.xml();
    } catch (ExcepcionNumeroNegativo e) {

      e.printStackTrace();
    }
  }

}
