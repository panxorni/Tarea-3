package expendedor.logica;

/**
 * Clase abstracta que representa una moneda genérica utilizada para los pagos y vueltos.
 * Implementa la interfaz Comparable para permitir el ordenamiento de listas de monedas.
 */
public abstract class Moneda implements Comparable<Moneda> {

    /**
     * Constructor por defecto de la moneda.
     */
    public Moneda() {
    }

    /**
     * Obtiene el valor de la moneda.
     * Cada subclase debe definir este valor.
     *
     * @return El valor de la moneda como número entero.
     */
    public abstract int getValor();

    /**
     * Compara el valor de esta moneda con otra para establecer un orden.
     *
     * @param otra La moneda con la que se va a comparar.
     * @return Un valor negativo, cero o positivo si esta moneda es menor,
     * igual o mayor que la moneda especificada, respectivamente.
     */
    @Override
    public int compareTo(Moneda otra) {
        return Integer.compare(this.getValor(), otra.getValor());
    }

    /**
     * Genera una representación en texto de la moneda.
     * Utiliza la dirección de memoria (hashCode) como equivalente a su número de serie.
     *
     * @return Cadena de texto con el valor de la moneda y su número de serie.
     */
    @Override
    public String toString() {
        return "Moneda de $" + this.getValor() + " (Serie: " + this.hashCode() + ")";
    }
}