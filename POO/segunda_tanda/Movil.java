package POO.segunda_tanda;

public class Movil extends Terminal {

  private double totalTarificados = 0.0;
  private String tarifa;
  //private Tarifa tarifa;
  
  public Movil(String n, String t) {
    super(n);
    tarifa = t;
    totalTarificados = 0.0;
  }
  
  @Override
  public void llama(Terminal t, int s) {
    super.llama(t, s);
    
    double min = (double) (s/60);
    if(tarifa == "rata") {
      totalTarificados += min * 0.06;
    }else if(tarifa == "mono") {
      totalTarificados += min * 0.12;
    }else {
      totalTarificados += min * 0.3;
    }
  }
  
  @Override
  public String toString() {
    return super.toString() + " - tarificados " + totalTarificados + " euros"  ;  
    }

}
