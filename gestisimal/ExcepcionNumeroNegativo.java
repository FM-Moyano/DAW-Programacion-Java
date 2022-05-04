package gestisimal;

import java.lang.Exception;

@SuppressWarnings("serial")
public class ExcepcionNumeroNegativo extends Exception {

    public ExcepcionNumeroNegativo() {
        super("No se permiten numeros negativos.");
    }

}


