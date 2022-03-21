package POO.colecciones_diccionarios;

class Elemento {

  private String producto;
  private double precio = 0;
  private int cantidad =0;

  Elemento(String pro, double pre, int c){
    producto = pro;
    precio = pre;
    cantidad = c;
  }

  String getProducto() {
    return producto;
  }


  double getPrecio() {
    return precio;
  }


  int getCantidad() {
    return cantidad;
  }
  
  double precioTotal(){
    return getCantidad() * getPrecio();
  } 


  @Override
  public String toString() {
    return producto + "PVP: " + precio + "Unidades: " + cantidad + " Subtotal: " + String.format("%.2f", (precio * cantidad));
  }


}
