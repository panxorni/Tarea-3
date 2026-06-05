package expendedor.logica;

/**
 * Representa una moneda con un valor de 1000.
 */
public class Moneda1000 extends Moneda {

    /**
     * Constructor de la moneda de 1000.
     */
    public Moneda1000() {
        super();
    }

    /**
     * Retorna el valor específico de esta moneda.
     *
     * @return 1000.
     */
    @Override
    public int getValor() {
        return 1000;
    }
}
