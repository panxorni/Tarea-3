package expendedor.logica;
/** Este es el encargado de representar un producto vendible por la maquina expendedora.
 * Esta sera la clase principal de las que derivan cada producto, ya que de esta heredaran tanto Bebida como Dulce
 * y de estas, sus subclases.*/
abstract public class Producto {
    protected TipoProducto tipo;
    public Producto (TipoProducto tipo){
        this.tipo=tipo;
    }
    abstract public String consumir();
}