package expendedor.logica;

import java.awt.*;

/** Este es el encargado de representar un producto vendible por la maquina expendedora.
 * Esta sera la clase principal de las que derivan cada producto, ya que de esta heredaran tanto Bebida como Dulce
 * y de estas, sus subclases.*/

abstract public class Producto {
    protected TipoProducto tipo;
    protected int x;
    protected int y;
    protected int ancho;
    protected int alto;
    protected static int contadorSerie=0;
    protected int serie;

    public Producto (TipoProducto tipo){
        this.x=0;
        this.y=0;
        this.alto=40;
        this.ancho=80;
        contadorSerie++;
        this.serie=contadorSerie;
        this.tipo=tipo;
    }
    public void setXY (int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getSerie(){
        return serie;
    }
    public TipoProducto getTipo(){
        return tipo;
    }
    public void paintComponent (Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x,y,ancho,alto);
        g.setColor(Color.WHITE);
        g.drawRect(x,y,ancho,alto);
        g.drawString(tipo.getNombre(),x+5,y+15);
        g.drawString("S:" + serie, x+5, y+30);
    }
    abstract public String consumir();
}