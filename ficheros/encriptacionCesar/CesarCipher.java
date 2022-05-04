package ficheros.encriptacionCesar;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CesarCipher {

  private static final String LETRAS = "ABCDFGHIJKLMÑOPQRSTUVWYZ";
  
  
  public static void encrypt(String ficheroParaCifrar, String ficheroCifrado, int key) throws IOException {
    List<String> lineasArchivo = Files.readAllLines(Paths.get(ficheroParaCifrar));
    PrintWriter file = new PrintWriter(ficheroCifrado);
    for (String linea: lineasArchivo) {
      file.println(encrypt(linea, key));
    }
    file.close();
  } 
  
  public static void decrypt(String ficheroParaCifrar, String ficheroCifrado, int key) throws IOException {
    encrypt(ficheroParaCifrar, ficheroCifrado, -key);
  }
  
  public static String encrypt(String str, int key) {
    String textoEncruptado = "";
    for (char ch: str.toCharArray()) {
      textoEncruptado += encrypt(ch, key);
    }
    return textoEncruptado;
  }
  
  public static String decrypt(String strToEncrypt, int key) {
    return encrypt(strToEncrypt, -key);
  }
  
  private static char encrypt(char ch, int key) {
    if(!LETRAS.contains(String.valueOf(ch).toUpperCase())) {
      return ch;
    }
    String letras = (Character.isUpperCase(ch)) ? LETRAS : LETRAS.toLowerCase();
    int indexChar = letras.indexOf(ch);
    int indexEncrypted = (indexChar + key) % letras.length();
    if(indexEncrypted < 0) {
      indexEncrypted = letras.length() + indexEncrypted;
    }
    return letras.charAt(indexEncrypted);
  }
}
