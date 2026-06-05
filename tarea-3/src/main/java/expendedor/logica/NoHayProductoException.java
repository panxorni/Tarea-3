package expendedor.logica;

/**
 * Excepción que se lanza cuando se intenta comprar un producto y el depósito
 * correspondiente está vacío o el número de depósito es erróneo.
 */
public class NoHayProductoException extends Exception {

    /**
     * Constructor de la excepción NoHayProductoException.
     * @param mensaje El mensaje de error que detalla por qué no hay producto.
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}
