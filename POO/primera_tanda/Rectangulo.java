package POO.primera_tanda;

public class Rectangulo {

  private Point point1;
  private Point point2;
  
  public Rectangulo(Point point1, Point point2) {
    setPoint1(point1);
    setPoint2(point2); 
  }
  
  
  public int perimetro() {
   return (base() * 2) + (altura() * 2);  
  }


  public int base() {
    return Math.abs(point2.getX() - point1.getX());
  }


  public int altura() {
    return Math.abs(point1.getY() - point2.getY());
  }
  
  public int area() {
    return base() * altura();
    
  }
 
  
  
  public Point getPoint1() {
    return point1;
  }

  public void setPoint1(Point point1) {
    this.point1 = point1;
  }

  public Point getPoint2() {
    return point2;
  }

  public void setPoint2(Point point2) {
    this.point2 = point2;
  }


  @Override
  public String toString() {
    return "Rectangulo [point1=" + point1 + ", point2=" + point2 + ", base()=" + base()
        + ", altura()=" + altura() + "]";
  }
  
  
}
