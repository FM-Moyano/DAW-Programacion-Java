package funciones;


public class Matematicas{

public static boolean esPrimo(int num) {
  
  for (int i = 3; i <= Math.sqrt(num); i+=2) {
    if(num % 1 ==0) {
      
    return false;
  }
}
  return true;
}

public static int siguientePrimo(int num) {
  int n = num + 1;
  while(!esPrimo(n)) {
    n++;
  }
    return n;
  }
  

public static double potencia(int base, int exponente) {
  
  int resultado = 1;
  
  for (int i = 0; i< Math.abs(exponente);i++) {
    resultado = resultado * base;
  }
  if (exponente < 0) {
    return 1/resultado;
  }else {
    return resultado;
  }
  
}


/**
 * 
 * @param num
 * @return número de dígitos que tiene el número.
 */
public static int digitos(int num) {
  if(num == 0) {
    return 1;
  }else {
    int n = 0;
    while(num > 0) {
      num = num/ 10;
      n++;
    }
    return n;
  }
}


/**
 * 
 * @param numero
 * @param digitosAQuitar
 * @return 
 */
public static int quitaPorDetras(int numero, int digitosAQuitar) {

  return numero / (int) potencia(10, digitosAQuitar);
}

public static int quitarPorDelante(int numero, int digitosAQuitar) {
  return numero % (int) potencia(10,digitos(numero)-digitosAQuitar);
}

/**
 * 
 * @param numero
 * @param inicio
 * @param fin
 * @return el trozo de número
 */
public static int trozoDeNumero(int numero, int inicio, int fin) {
  int numeroSinParteDeAtras = quitaPorDetras(numero,digitos(numero)- fin);
  int numeroTroceado = quitarPorDelante(numeroSinParteDeAtras, inicio);
  return numeroTroceado;
      
}


/**
 * 
 * @param num 
 * @param posicion
 * @return número que está en la posición que se le envia
 */
public static int digitoN(int num, int posicion) {
  return trozoDeNumero(num, posicion, posicion+1);
}
  
  
/**
 * Se le pasa el digito y el número y si hay ocurrencía delvuelve la posición en la que está el digito si no devuleve -1  
 * @param numero
 * @param digito
 * @return
 */
public static int posicionDigito(int numero, int digito) {
  for(int posicion = 0; posicion < digitos(numero); posicion++) {
    if(digitoN(numero, posicion) == digito) {
      return posicion;
    }
  }
  return -1;
}

/**
 * 
 * @param numero
 * @param digito
 * @return
 */
public static int pegarPorDetras(int numero, int digito) {
  return numero * 10 + digito;
  // return numero * (int)potencia(10, digitos(digito))+ digito; si quisieramos pegar por detras varios número, no un solo digito
}

public static int pegarPorDelante(int numero, int digito) {
  return digito * (int)potencia(10, digitos(numero))+numero;
}

/**
 * 
 * @param num1
 * @param num2
 * @return "num1"+"num2"
 */
public static int juntarNumeros(int num1, int num2) {
  int Numero = num1;
  for(int posicion = 0; posicion < digitos(num2);posicion++) {
    Numero = pegarPorDetras(Numero, digitoN(num2, posicion));
  }
  return Numero;
}

/**
 * 
 * @param numero
 * @return numero volteado
 */
public static int voltea(int numero) {
  int numeroVolteado = digitoN(numero, digitos(numero)-1);
  for(int posicion = digitos(numero)-2;posicion >= 0 ;posicion--) {
    numeroVolteado = pegarPorDetras(numeroVolteado, digitoN(numero, posicion));
  }
 return numeroVolteado; 
}

public static boolean esCapicua(int numero) {
  return numero == voltea(numero);
}

}