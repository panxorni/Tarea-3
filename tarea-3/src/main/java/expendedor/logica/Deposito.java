package expendedor.logica;

import java.util.ArrayList;

/**
 * Clase genérica que representa un depósito dentro del expendedor.
 * Puede ser utilizada para almacenar cualquier tipo de objeto, como
 * Productos (Bebidas o Dulces) o Monedas.
 *
 * @param <T> El tipo de elemento que almacenará este depósito.
 */
public class Deposito<T> {

    /**
     * Estructura de datos utilizada para almacenar los elementos del depósito.
     */
    private ArrayList<T> almacen;

    /**
     * Constructor de la clase Deposito.
     * Inicializa el almacenamiento interno como un ArrayList vacío.
     */
    public Deposito() {
        almacen = new ArrayList<>();
    }

    /**
     * Añade un nuevo elemento al final del depósito.
     *
     * @param elemento El objeto de tipo T que se desea almacenar.
     */
    public void addElemento(T elemento) {
        almacen.add(elemento);
    }

    /**
     * Retira y entrega el primer elemento que fue ingresado al depósito
     * (simulando el comportamiento de un depósito físico donde el primero en entrar es el primero en salir).
     *
     * @return El objeto de tipo T retirado del depósito, o null si el depósito está vacío.
     */
    public T getElemento() {
        if (almacen.isEmpty()) {
            return null;
        }
        return almacen.remove(0);
    }
    /**
     * Indica si el depósito está vacío.
     *
     * @return true si no hay elementos almacenados, false en caso contrario
     */
    public boolean isEmpty() {
        return almacen.isEmpty();
    }

    /**
     * Entrega la lista interna de elementos para ser dibujados por la interfaz gráfica.
     * @return El ArrayList que contiene los elementos del depósito.
     */
    public ArrayList<T> getLista() {
        return this.almacen;
    }
}