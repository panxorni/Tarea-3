package expendedor.gui;

import expendedor.logica.Deposito;
import expendedor.logica.Producto;
import expendedor.logica.Moneda;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Representar la vista gráfica de un compartimento dentro de la máquina.
 * Utilizar genéricos <T> para poder almacenar y dibujar tanto instancias de Producto como de Moneda.
 *
 * @param <T> El tipo de elemento lógico que contendrá este depósito.
 */
public class PanelDeposito<T> {


    private int x;
    private int y;
    private int width;
    private int height;
    private Color colorFondo;

    private Deposito<T> depositoLogico;

    /**
     * Inicializa el PanelDeposito y lo enlazacon su modelo lógico
     * Recibir sus coordenadas relativas desde el PanelExpendedor para establecer su posición
     * @param colorFondo     Color de fondo para dibujar el compartimento
     * @param depositoLogico Objeto con la logica de Deposito
     */
    public PanelDeposito(int x, int y, Color colorFondo, Deposito<T> depositoLogico) {
        this.x = x;
        this.y = y;
        this.width = ConstantesGUI.DEPOSITO_ANCHO;
        this.height = ConstantesGUI.DEPOSITO_ALTO;
        this.colorFondo = colorFondo;
        this.depositoLogico = depositoLogico;

        // Ejecuta el reposicionamiento para iniciar con los elementos ordenados
        reposicionar();
    }

    /**
     * Recalcular las posiciones relativas (0, 1, n-1) de los elementos internos.
     * Llamar a este método cada vez que se agregue o retire un elemento del depósito.
     */
    public void reposicionar() {
        if (depositoLogico != null) {
            int separacionY = 30; // Definir el espacio vertical entre cada elemento
            int itemX = this.x + 5; // Definir el margen izquierdo interno

            for (int i = 0; i < depositoLogico.getLista().size(); i++) {
                T elemento = depositoLogico.getLista().get(i);

                // Apilar los objetos de abajo hacia arriba en forma de columna
                int itemY = this.y + this.height - 40 - (i * separacionY);

                // Evaluar el tipo de elemento para establecer sus nuevas coordenadas
                if (elemento instanceof Moneda) {
                    ((Moneda) elemento).setXY(itemX, itemY);
                }
            }
        }
    }

    /**
     * Dibuja visualmente el compartimento del depósito y sus elementos internos.
     *
     * @param g Objeto Graphics para pintar en pantalla.
     */
    public void paintComponent(Graphics g) {
        // Dibujar el fondo del depósito
        g.setColor(this.colorFondo);
        g.fillRect(this.x, this.y, this.width, this.height);

        //Dibuja un borde negro para delimitar el panel
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, this.width, this.height);

        //Verifica si el depósito lógico existe antes de intentar dibujar sus elementos
        if (depositoLogico != null) {

            //Reposiciona para reflejar cualquier cambio lógico
            reposicionar();

            for (int i = 0; i < depositoLogico.getLista().size(); i++) {
                T elemento = depositoLogico.getLista().get(i);

                //Ejecuta los métodos de dibujo correspondientes a cada tipo de objeto
                if (elemento instanceof Producto) {
                    ProductoGUI productoGUI = new ProductoGUI((Producto) elemento);
                    productoGUI.setXY(itemX, itemY);
                    productoGUI.paintComponent(g);
                }
                else if (elemento instanceof Moneda) {
                    ((Moneda) elemento).paintComponent(g);
                }
            }
        }
    }
}