package expendedor.logica;

/**
 * Representa una moneda con un valor de 500.
 */
public class Moneda500 extends Moneda {

    /**
     * Constructor de la moneda de 500.
     */
    public Moneda500() {
        super();
    }

    /**
     * Retorna el valor específico de esta moneda.
     *
     * @return 500.
     */
    @Override
    public int getValor() {
        return 500;
    }
}