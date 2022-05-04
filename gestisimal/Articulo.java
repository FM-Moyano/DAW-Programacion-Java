package gestisimal;

import java.util.Objects;

public class Articulo {

  private static int codigoAnterior = 0;

  private int codigo;
  private String nombre;
  private String marca;
  private double precioDeCompra;
  private double precioDeVenta;
  private int numeroDeUnidades;
  private int stockDeSeguridad;
  private int stockMaximo;

  Articulo(String nombre, String marca, double precioCompra, double precioVenta, int unidades, 
      int stockSeguridad, int stockMaximo) throws ExcepcionNumeroNegativo {
    codigo = ++codigoAnterior;
    codigoAnterior = codigo; 
    setNombre(nombre);
    setMarca(marca);
    setNumeroDeUnidades(unidades);
    setPrecioDeCompra(precioCompra);
    setPrecioDeVenta(precioVenta);
    setStockDeSeguridad(stockSeguridad);
    setStockMaximo(stockMaximo);

  }

  Articulo(String nombre, String marca, double precioCompra, double precioVenta, int unidades) throws ExcepcionNumeroNegativo {
    this(nombre, marca, precioCompra, precioVenta, unidades, 0, 0);
  }

  Articulo(String nombre, String marca, double precioCompra, double precioVenta, int unidades, int stockSeguridad) throws ExcepcionNumeroNegativo {
    this(nombre, marca, precioCompra, precioVenta, unidades, stockSeguridad, 0);
  }

  Articulo(int codigo){

  }
  public String getNombre() {
    return nombre;
  }

  void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMarca() {
    return marca;
  }

  void setMarca(String marca) {
    this.marca = marca;
  }

  public double getPrecioDeCompra() {
    return precioDeCompra;
  }

  void setPrecioDeCompra(double precioDeCompra) {
    this.precioDeCompra = precioDeCompra;
  }

  public double getPrecioDeVenta() {
    return precioDeVenta;
  }

  void setPrecioDeVenta(double precioDeVenta) {
    this.precioDeVenta = precioDeVenta;
  }

  public int getNumeroDeUnidades() {
    return numeroDeUnidades;
  }

  void setNumeroDeUnidades(int numeroDeUnidades) throws ExcepcionNumeroNegativo {
    if(numeroDeUnidades < 0) {
      throw new ExcepcionNumeroNegativo();
    }else {
      this.numeroDeUnidades = numeroDeUnidades;
    }
  }

  public int getStockDeSeguridad() {
    return stockDeSeguridad;
  }

  void setStockDeSeguridad(int stockDeSeguridad) {
    this.stockDeSeguridad = stockDeSeguridad;
  }

  public int getStockMaximo() {
    return stockMaximo;
  }

  void setStockMaximo(int stockMaximo) {
    this.stockMaximo = stockMaximo;
  }

  public int getCodigo() {
    return codigo;
  }
  
  
  void incrementar(int unidades) {
    numeroDeUnidades += unidades;
  }
  
  void decrementar(int unidades) throws ArticleIllegalErrorArgumentException {
    if((numeroDeUnidades - unidades ) < 0) {
      throw new ArticleIllegalErrorArgumentException();
    }else {
      numeroDeUnidades -= unidades;
    }
  }

  @Override
  public String toString() {
    return "Articulo [codigo=" + codigo + ", nombre="
        + nombre + ", marca=" + marca + ", precioDeCompra=" + precioDeCompra + ", precioDeVenta="
        + precioDeVenta + ", numeroDeUnidades=" + numeroDeUnidades + ", stockDeSeguridad="
        + stockDeSeguridad + ", stockMaximo=" + stockMaximo + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(marca, nombre);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    return Objects.equals(marca, other.marca) && Objects.equals(nombre, other.nombre);
  }
}


