package expendedor.gui;
import expendedor.logica.Producto;

import java.awt.*;
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
    public Producto getProducto() {
        return producto;
    }
    public void setXY (int x, int y){
            this.x=x;
            this.y=y;
        }
        public void paintComponent (Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect(x,y,ancho,alto);

            g.setColor(Color.WHITE);
            g.drawRect(x,y,ancho,alto);

            g.drawString(producto.getTipo().getNombre(), x+5 , y+15);
            g.drawString("S:" + producto.getSerie(), x+5, y+25);
        }
}