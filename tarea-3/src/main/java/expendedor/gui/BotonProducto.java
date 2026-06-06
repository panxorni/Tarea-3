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
        g.fillRect(x, y, botonAncho, botonAlto);
        g.drawString(producto.name(), x+0, y+0); //cambiar los ceros cuando se tengan los margenes definidos
    }

    public boolean esContenido(int clickX, int clickY){
        return clickX >= x && clickX <= x+botonAncho && clickY >= y && clickY <= y+botonAlto;
    }

    public TipoProducto getProducto(){
        return producto;
    }
}
