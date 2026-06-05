package expendedor.logica;

/**
 * Excepción que se lanza cuando la moneda ingresada tiene un valor menor
 * al precio del producto que se intenta comprar.
 */
public class PagoInsuficienteException extends Exception {

    /**
     * Constructor de la excepción PagoInsuficienteException.
     * @param mensaje El mensaje de error que advierte sobre el pago insuficiente.
     */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}