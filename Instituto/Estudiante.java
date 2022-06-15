package Instituto;
/**
 * Clase Instituto 
 * @author fmmoy
 * 
 * Tiene un constructor que recibe:
◦ Un DNI válido (tiene 8 dígitos y una letra resultado de aplicar un algoritmo).
◦ Un nombre no vacío.
◦ Una sucesión de notas (números reales) entre 0 y 10.
◦ Si algún es inválido lanzamos una excepción.
• Tiene getters para obtener el DNI, nombre y notas.

 */
import java.util.Arrays;
import java.util.Objects;


public class Estudiante {



  private String dni;
  private String nombre;
  private double[] notas;

  Estudiante(String dni, String nombre, double[] notas) throws ExceptionDniInvalido, ExceptionNombreInvalido{
    if(!validaDNI(dni.toUpperCase())) {
      throw new ExceptionDniInvalido("El DNI no es valido");
    }
    if(nombre.equals("")) {
      throw new ExceptionNombreInvalido("El nombre está vacio");
    }
    this.dni = dni.toUpperCase();
    this.nombre = nombre;
    this.notas = notas;
  }

  public String getDni() {
    return dni;
  }

  public String getNombre() {
    return nombre;
  }

  public double[] getNotas() {
    return notas;
  }

  @Override
  public String toString() {
    return "\n------------- \nDNI: " + dni + "\nNombre: " + nombre + "\nNotas: " + Arrays.toString(notas) + "\n"
    ;
  }
  
  public String toStringMedia() {
    return "\n------------- \nDNI: " + dni + "\nNombre: " + nombre + "\nNotas: " + Arrays.toString(notas) + "\nMedia: "
        + Math.round(media(notas)) +"\n"
        ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dni);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Estudiante other = (Estudiante) obj;
    return Objects.equals(dni, other.dni);
  }

  String letraDNI(int dni) {
    String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
  }

  boolean validaDNI(String dni) {
    int numerosDNI = Integer.parseInt(dni.substring(0,8));
    if(dni.equals(letraDNI(numerosDNI))) {
      return true;
    }
    return false; 
  }
  
  double media(double[] notas) {
    double media = 0;
    for(int i = 0; i <= notas.length-1; i++) {
      media += notas[i];
    }
    return media/notas.length;
  }
}