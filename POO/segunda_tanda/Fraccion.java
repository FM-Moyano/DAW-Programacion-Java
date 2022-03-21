package POO.segunda_tanda;

public class Fraccion {

  private int numerador;
  private int denominador;

  public Fraccion(int numerador, int denominador) {
    this.numerador = numerador;
    this.setDenominador(denominador);
    simplificar();
  }

  
  public float resultado() {
    return numerador/denominador;
  }
  
  
  public Fraccion multiplicar(int num) {
    //numerador = numerador * num;
    //denominador = denominador * num;
    return new Fraccion(numerador * num, denominador);
  }
  
  
  public Fraccion multiplicarFracciones(Fraccion fraccion1){
    //numerador = numerador * fraccion1.getNumerador();
    //denominador = denominador * fraccion1.getDenominador(); cuando es void
    return new Fraccion(numerador*fraccion1.getNumerador() , denominador * fraccion1.getDenominador());
    
  }
  
  
  public Fraccion dividirFracciones(Fraccion f){
    //numerador = numerador * fraccion1.getDenominador();
    //denominador = denominador * fraccion1.getNumerador();
    
    return new Fraccion(numerador * f.getDenominador(), denominador * f.getNumerador() );
  }
  
  
  public Fraccion sumar(Fraccion f) {
    return new Fraccion(this.numerador*f.getDenominador() + f.getNumerador()*this.denominador,
                        this.denominador*f.getDenominador());
  }
  
  
  public Fraccion restar(Fraccion f) {
    return sumar(f.multiplicar(-1));
  }
  
  
  public static int maximoComunDivisor(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    
    while (b > 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }
  
  public void simplificar() {
    int mcd = Fraccion.maximoComunDivisor(numerador, denominador);
    
    numerador /= mcd;
    denominador /= mcd;
  }
  
  //////////////////////////////////////
  
  @Override
  public String toString() {
    return this.numerador + "/" + this.denominador;
  }
  
  //@Override
  public int compareTo(Fraccion o) {
    return this.numerador*o.denominador - o.numerador*this.denominador;
  }
  
  @Override
  public Fraccion clone() {
    return new Fraccion(this.numerador,this.denominador);
  }
  
  
  
  
  
  ///////////////////////////////
  public int getNumerador() {
    return numerador;
  }


  public int getDenominador() {
    return denominador;
  }

  public void setNumerador(int numerador) {
    this.numerador = numerador;
  }


  public void setDenominador(int denominador) {
    this.denominador = denominador;
    
    if(denominador == 0) {
      System.err.println("El estado del objeto es incorrecto al ser el denominador 0.");
    }
  }

  
}
