package expendedor.logica;

/**
 * Excepción que se lanza cuando se intenta realizar una compra ingresando
 * una moneda nula (null).
 */
public class PagoIncorrectoException extends Exception {

    /**
     * Constructor de la excepción PagoIncorrectoException.
     * @param mensaje El mensaje de error que indica que el pago es inválido.
     */
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}