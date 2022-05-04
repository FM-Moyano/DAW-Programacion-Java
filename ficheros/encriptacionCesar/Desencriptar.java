package ficheros.encriptacionCesar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Desencriptar {

  public static void main(String[] args) {
    MetdosComunes.exitIfWrongArguments(args);

    String nombreFicheroParaEncriptar = args[0];
    String nombreArchivoCifrado = MetdosComunes.getNameTargetFile(args);
    int key = MetdosComunes.readKey();

    try {
      CesarCipher.decrypt(nombreFicheroParaEncriptar, nombreArchivoCifrado, key); 
      System.out.println("Creado " + nombreArchivoCifrado);
    }
    catch (NoSuchFileException e) {
      MetdosComunes.exitWithError("No puedo abrir " + nombreFicheroParaEncriptar, MetdosComunes.READING_ERROR);
    } 
    catch (FileNotFoundException e) {
      MetdosComunes.exitWithError("Error al escribir en " + nombreArchivoCifrado, MetdosComunes.WRITING_ERROR);
    } 
    catch (IOException e) {
      MetdosComunes.exitWithError("Error de E/S -> " + e.getMessage(), MetdosComunes.IO_ERROR);
    }
  }

}
