package POO.carrito;

import java.util.Objects;

public class Elemento {
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

  void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  double precioTotal(){
    return getCantidad() * getPrecio();
  }


  @Override
  public String toString() {
    return producto + "PVP: " + precio + "Unidades: " + cantidad + " Subtotal: " + String.format("%.2f", (precio * cantidad));
  }

  @Override
  public int hashCode() {
    return Objects.hash(cantidad, precio, producto);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Elemento other = (Elemento) obj;
    return Objects.equals(producto, other.producto);
  }

  



}
