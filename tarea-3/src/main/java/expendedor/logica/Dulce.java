package expendedor.logica;
/** Esta clase es la que representa un tipo de producto que es comestible en la maquina expendedora.
 * Hereda directamente de producto los atributos de las opciones de compras comestibles.
 * Es la base para cada dulce.*/
abstract public class Dulce extends Producto{
    public Dulce (TipoProducto tipo){
        super (tipo);
    }
}