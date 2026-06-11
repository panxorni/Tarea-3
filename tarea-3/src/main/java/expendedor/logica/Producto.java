package expendedor.logica;

import java.awt.*;

/** Este es el encargado de representar un producto vendible por la maquina expendedora.
 * Esta sera la clase principal de las que derivan cada producto, ya que de esta heredaran tanto Bebida como Dulce
 * y de estas, sus subclases.*/

abstract public class Producto {
    protected TipoProducto tipo;
    protected static int contadorSerie=0;
    protected int serie;

    public Producto (TipoProducto tipo){
        contadorSerie++;
        this.serie=contadorSerie;
        this.tipo=tipo;
    }
    public int getSerie(){
        return serie;
    }
    public TipoProducto getTipo(){
        return tipo;
    }
    abstract public String consumir();
}