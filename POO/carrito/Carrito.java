package POO.carrito;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

  List<Elemento> carrito = new ArrayList<>();


  public void agrega(Elemento e) {
    if(carrito.contains(e)) {
      Elemento elemento = carrito.get(carrito.indexOf(e));
      elemento.setCantidad(elemento.getCantidad() + e.getCantidad());
    }else {
      carrito.add(e);
    }
  }

  public double importeTotal() {
    double t = 0;
    for(Elemento e : carrito) {
      t += e.precioTotal();
    }
    return t;
  }

  public int numeroElementos() {
    return carrito.size();
  }

  @Override
  public String toString() {
    String resultado = "Contenido del carrito\n=================\n";
    for(Elemento e : carrito) {
      resultado += e + "\n";
    }
    return resultado;
  }
}
