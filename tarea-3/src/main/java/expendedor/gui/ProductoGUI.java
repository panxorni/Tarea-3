package expendedor.gui;
import expendedor.logica.Producto;

import java.awt.*;

/**
 * Clase que representa gráficamente un producto dentro de la interfaz.
 * Permite dibujar un producto lógico como un rectángulo, mostrando su nombre
 * y su número de serie.
 */

public class ProductoGUI {
        protected Producto producto;
        protected int x;
        protected int y;
        protected int ancho;
        protected int alto;

        public ProductoGUI (Producto producto){
            this.producto=producto;
            this.x=0;
            this.y=0;
            this.alto=ConstantesGUI.DEPOSITO_ANCHO-10;
            this.ancho=59;
        }

    /**
     * Entrega el producto lógico asociado a esta representación gráfica.
     *
     * @return El producto representado por esta vista.
     */

    public Producto getProducto() {
        return producto;
    }

    /**
     * Define la posición del producto dentro de la interfaz.
     *
     * @param x Coordenada X donde se dibujará el producto.
     * @param y Coordenada Y donde se dibujará el producto.
     */

    public void setXY (int x, int y){
            this.x=x;
            this.y=y;
        }

    /**
     * Dibuja el producto en la interfaz gráfica.
     * El producto se representa como un rectángulo negro con borde blanco,
     * mostrando el nombre del producto y su número de serie.
     *
     * @param g Objeto Graphics utilizado para dibujar el producto.
     */

        public void paintComponent (Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect(x,y,ancho,alto);

            g.setColor(Color.WHITE);
            g.drawRect(x,y,ancho,alto);

            g.drawString(producto.getTipo().getNombre(), x+5 , y+15);
            g.drawString("S:" + producto.getSerie(), x+5, y+25);
        }
}