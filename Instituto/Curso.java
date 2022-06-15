package Instituto;
/**
 * @author fmmoy
 * 
 * Tiene dos constructores:
◦ El primero sin parámetros, simplemente crea un curso vacío.
◦ El segundo recibe un fichero JSON con los datos de esta clase almacenados
  previamente. Lanza una excepción si hay problemas con el fichero.
• Alta de estudiante (recibe el DNI, nombre y notas). Añade un estudiante a la agenda.
• Baja de estudiante (por DNI). Lanza una excepción si el estudiante a borrar no existe.
• Busca un estudiante. Devuelve el estudiante (objeto) que coincida con el DNI buscado, en
  caso de no encontrar coincidencia se devuelve un valor nulo.
• Exporta a fichero JSON. Lanza una excepción si no podemos escribir en el fichero.
 * 
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;



public class Curso {

  private List<Estudiante> estudiantes = new ArrayList<>();

  Curso(){

  }

  Curso(String fichero) throws IOException{
    lecturaJson(fichero);
  }

  void alta(String dni,String nombre, double[] notas) {


    try {
      Estudiante estudiante = new Estudiante(dni,nombre,notas);
      if(estudiantes.contains(estudiante)) {
        throw new ExceptionAlumnoExiste("Este Alumno ya existe");
      }
      estudiantes.add(estudiante);
    } catch (ExceptionDniInvalido e) {
      System.err.println("El dni no es valido");
    }catch (ExceptionNombreInvalido e) {
      System.err.println("El nombre no es valido");

    } catch (ExceptionAlumnoExiste e) {
      System.err.println("El alumno ya existe");
      
    }


  }

  void baja(String dni) throws ExceptionAlumnoNoExiste {
    throwExceptionAlumnoNoExiste(dni);
    estudiantes.removeIf(estudiante -> dni.equals(estudiante.getDni()));

  }

  Estudiante get(String dni) {
    String dniMayuscula = dni.toUpperCase();
    for(Estudiante estudiante: estudiantes) {
      if(estudiante.getDni().equals(dniMayuscula)) {
        return estudiante;
      }
    }
    return null;
  }

  void exportar(String nombreFichero) throws IOException {

    
      String json = new Gson().toJson(estudiantes);

      BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero +".json"));
      fichero.write(json);
      fichero.close();

    }


  void lecturaJson(String fichero) throws IOException {
    
      String json = Files.readString(Paths.get(fichero + ".json"));

      Gson gson = new Gson();
      Type StudentListType = new TypeToken<ArrayList<Estudiante>>() {}.getType();
      List<Estudiante> estudiantes2 = gson.fromJson(json, StudentListType);

      for(Estudiante estudiante : estudiantes2) {
        estudiantes.add(estudiante);
      }

      System.out.println("Fichero recuperado");

  }

  @Override
  public String toString() {
    String str = "----Curso----\n";
    for(Estudiante estudiante: estudiantes) {
      str += estudiante;
    }
    return str;
  }

  public void throwExceptionAlumnoNoExiste(String dni) throws ExceptionAlumnoNoExiste {
    if(!estudiantes.contains(get(dni))) {
      throw new ExceptionAlumnoNoExiste("No existe ningún alumno con el DNI " + dni);
    }
  }

}
