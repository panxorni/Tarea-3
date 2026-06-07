package expendedor.gui;

import expendedor.logica.TipoProducto;

import java.awt.*;

public class BotonProducto {
    private int x;
    private int y;
    private int botonAncho;
    private int botonAlto;
    private TipoProducto producto;

    public BotonProducto(int x, int y, TipoProducto producto){
        this.producto=producto;

        this.x=x;
        this.y=y;
        botonAncho=ConstantesGUI.BOTON_ANCHO;
        botonAlto=ConstantesGUI.BOTON_ALTO;
    }

    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, botonAncho, botonAlto);
        g.setColor(Color.BLACK);
        g.drawString(producto.name(), x+15, y+25);
    }

    public boolean esContenido(int clickX, int clickY){
        return clickX >= x && clickX <= x+botonAncho && clickY >= y && clickY <= y+botonAlto;
    }

    public TipoProducto getProducto(){
        return producto;
    }
}
