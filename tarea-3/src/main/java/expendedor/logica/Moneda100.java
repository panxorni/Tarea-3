package expendedor.logica;

/**
 * Representa una moneda con un valor de 100.
 */
public class Moneda100 extends Moneda {

    /**
     * Constructor de la moneda de 100.
     */
    public Moneda100() {
        super();
    }

    /**
     * Retorna el valor específico de esta moneda.
     *
     * @return 100.
     */
    @Override
    public int getValor() {
        return 100;
    }
}