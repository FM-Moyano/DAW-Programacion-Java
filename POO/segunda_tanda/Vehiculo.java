package POO.segunda_tanda;

public class Vehiculo {

  private static int kilometrosTotales;
  
  private static int vehiculosCreados = 0;
  
  private int kilometrosRecorridos;
  
  
  public Vehiculo() {
    kilometrosRecorridos = 0;
    vehiculosCreados++;
  }
  
  

  public int getKilometrosRecorridos() {
    return kilometrosRecorridos;
  }


  public int getKilometrosTotales() {
    return kilometrosTotales;
  }
  
  
  public void recorre(int km) {
    if(km < 0) {
      throw new IllegalArgumentException("Los km no puede ser negativos");
    }
    kilometrosRecorridos += km;
    Vehiculo.kilometrosTotales += km;
  }
  
  @Override
  public String toString() {
    return "Vehiculo [kilometrosRecorridos=" + kilometrosRecorridos + "]";
  }



  public static int getVehiculosCreados() {
    return vehiculosCreados;
  }
}
