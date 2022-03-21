package POO.colecciones_diccionarios;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

  List<Elemento> c = new ArrayList<>();


  public void agrega(Elemento e) {
    c.add(e); 
  }

  public double importeTotal() {
    double t = 0;
    for(Elemento e : c) {
      t += e.precioTotal();
    }
    return t;
  }

  public int numeroElementos() {
    return c.size();
  }

  @Override
  public String toString() {
    String resultado = "Contenido del carrito\n=================\n";
    for(Elemento e : c) {
      resultado += e + "\n";
    }
    return resultado;
  }


}
