package POO.primera_tanda;

public class PointTester {

  public static void main(String[] args) {
    Point point1 = new Point(5,2);
    Point point2 = new Point(6, 9);
    Point point3 = new Point();
    System.out.println(point1);
    System.out.println(point2);
    System.out.println(point3);
    
    
    point1.invertCoordinates();
    point2.invertCoordinates();
    System.out.println(point1);
    System.out.println(point2);
    
    System.out.println("Coordenada X de el objeto point1 " + point1.getX() );
    point1.setX(0);
    System.out.println(point1);
  }

}
