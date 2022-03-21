package POO.primera_tanda;

public class TesterRectangulo {

  public static void main(String[] args) {
    Point point1 = new Point(-1,4);
    Point point2 = new Point(5,2);

    Rectangulo rectangulo1 = new Rectangulo(point1, point2);
    System.out.println(rectangulo1);
    System.out.println("Rectangulo 1, tiene los puntos: " + point1 + ", " + point2);
    System.out.println("Perimetro " + rectangulo1.perimetro());
    System.out.println("Área: " + rectangulo1.area());
    
    
  }

}
