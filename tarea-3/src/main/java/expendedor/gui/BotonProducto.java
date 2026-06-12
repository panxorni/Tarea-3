package expendedor.gui;

import expendedor.logica.TipoProducto;

import java.awt.*;

/**
 * Esta clase representa un botón asociado a un tipo de producto
 * Dibuja zonas rectangulares en la interfaz y detecta si hay un click
 * del mouse dentro
 */

public class BotonProducto {
    private int x;
    private int y;
    private int botonAncho;
    private int botonAlto;
    private TipoProducto producto;

    /**
     * Constructor de la clase BotonProducto
     * Inicializa la posición del botón y el tipo de producto que representa
     *
     * @param x Coordenada X inicial del botón
     * @param y Coordenada Y inicial del botón
     * @param producto Tipo de producto asociado al botón
     */

    public BotonProducto(int x, int y, TipoProducto producto){
        this.producto=producto;

        this.x=x;
        this.y=y;
        botonAncho=ConstantesGUI.BOTON_ANCHO;
        botonAlto=ConstantesGUI.BOTON_ALTO;
    }

    /**
     * Dibuja el botón en la interfaz gráfica
     * El botón se representa mediante un rectángulo
     * y el nombre del producto en su interior
     *
     * @param g Objeto Graphics utilizado para dibujar el botón
     */

    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, botonAncho, botonAlto);
        g.setColor(Color.BLACK);
        Font fuenteOriginal = g.getFont();
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(producto.name(), x+15, y+25);
        g.setFont(fuenteOriginal);
    }

    /**
     * Verifica si un click del mouse ocurrió dentro del área del botón
     *
     * @param clickX Coordenada X del clic
     * @param clickY Coordenada Y del clic
     * @return true si el clic está dentro del botón, false en caso que no
     */

    public boolean esContenido(int clickX, int clickY){
        return clickX >= x && clickX <= x+botonAncho && clickY >= y && clickY <= y+botonAlto;
    }

    /**
     * Entrega el tipo de producto asociado al botón
     * @return El tipo de producto representado por este botón
     */

    public TipoProducto getProducto(){
        return producto;
    }
}