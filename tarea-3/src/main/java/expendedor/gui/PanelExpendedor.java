package expendedor.gui;

import expendedor.logica.Expendedor;
import expendedor.logica.Producto;
import java.awt.Color;
import java.awt.Graphics;

// las dimensiones las cambiamos, no son las finales
/**
 * Representar la vista principal de la máquina expendedora.
 * Contener y gestionar el dibujo de la carcasa, el vidrio y todos los depósitos internos.
 */
public class PanelExpendedor {

    /** Modelo logico del expendedor*/
    private Expendedor expendedorLogico;

    /** Coordenada X relativa del panel en la ventana*/
    private int x;
    /** Coordenada Y relativa del panel en la ventana*/
    private int y;
    /** Ancho*/
    private int width;
    /** Alto */
    private int height;

    // Vistas internas de los depósitos
    private PanelDeposito<Producto> panelDepCocaCola;
    private PanelDeposito<Producto> panelDepSprite;
    private PanelDeposito<Producto> panelDepFanta;
    private PanelDeposito<Producto> panelDepSnickers;
    private PanelDeposito<Producto> panelDepSuper8;

    /**
     * Inicializar el panel del expendedor, crear su modelo lógico y posicionar los depósitos internos.
     */
    public PanelExpendedor() {
        this.x = ConstantesGUI.EXPENDEDOR_X;
        this.y = ConstantesGUI.EXPENDEDOR_Y;
        this.width = ConstantesGUI.EXPENDEDOR_ANCHO;
        this.height = ConstantesGUI.EXPENDEDOR_ALTO;

        // Fabricar el modelo lógico con 5 productos iniciales por depósito
        this.expendedorLogico = new Expendedor(5);

        // Calcular posiciones relativas para los depósitos dentro del vidrio
        int inicioX = this.x + 30;
        int inicioY = this.y + 30;
        int separacion = 60;
        this.panelDepCocaCola = new PanelDeposito<>(inicioX, inicioY, Color.RED, expendedorLogico.getDepositoCocaCola());
        this.panelDepSprite   = new PanelDeposito<>(inicioX + separacion, inicioY,  Color.GREEN, expendedorLogico.getDepositoSprite());
        this.panelDepFanta    = new PanelDeposito<>(inicioX + separacion * 2, inicioY, Color.ORANGE, expendedorLogico.getDepositoFanta());
        this.panelDepSnickers = new PanelDeposito<>(inicioX + separacion * 3, inicioY, Color.PINK, expendedorLogico.getDepositoSnickers());
        this.panelDepSuper8   = new PanelDeposito<>(inicioX + separacion * 4, inicioY,  Color.YELLOW, expendedorLogico.getDepositoSuper8());
    }

    /**
     * Dibujar la carcasa exterior, el vidrio y ejecutar el dibujo de los componentes internos.
     *
     * @param g Objeto Graphics proporcionado para pintar en pantalla.
     */
    public void paintComponent(Graphics g) {
        // dibuja carcasa exterior del expendedor
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(this.x, this.y, this.width, this.height);

        // dibujar borde para relieve
        g.setColor(Color.DARK_GRAY);
        g.drawRect(this.x, this.y, this.width, this.height);

        // dibujar vidrio principal donde se ven los depositos
        g.setColor(new Color(173, 216, 230, 100)); // Celeste translúcido
        g.fillRect(this.x + 20, this.y + 20, this.width - 40, this.height - 180);

        // ejecutaa el dibujado de los paneles de depósitos
        if (panelDepCocaCola != null) panelDepCocaCola.paintComponent(g);
        if (panelDepSprite != null) panelDepSprite.paintComponent(g);
        if (panelDepFanta != null) panelDepFanta.paintComponent(g);
        if (panelDepSnickers != null) panelDepSnickers.paintComponent(g);
        if (panelDepSuper8 != null) panelDepSuper8.paintComponent(g);

        // dibujar el compartimento de salida del producto (abajo)
        g.setColor(Color.BLACK);
        g.fillRect(this.x + 150, this.y + 460, 100, 80);

        // dibuja el producto comprado si existe uno listo para ser retirado
        Producto productoComprado = expendedorLogico.verProducto();
        if (productoComprado != null) {
            productoComprado.setXY(this.x + 160, this.y + 480);
            productoComprado.paintComponent(g);
        }
    }

    //se verifica el clic para despues rellenar el expendedor si fue dentro de los limites de la maquina
    /**
     * Verificar si un clic del mouse ocurrió dentro de los limites del expendedor
     *
     * @param clicX Coordenada X del clic
     * @param clicY Coordenada Y del clic
     * @return true si el clic interactuó con la máquina, false en caso contrario
     */
    public boolean contieneClic(int clicX, int clicY) {
        return (clicX >= this.x && clicX <= this.x + this.width &&
                clicY >= this.y && clicY <= this.y + this.height);
    }

    /**
     * Rellena los depósitos y fuerza la actualización visual de las coordenadas
     */
    public void recargarMaquina() {
        expendedorLogico.rellenarDepositosVacios(5);

        // Forzar el reposicionamiento para reflejar la recarga
        if (panelDepCocaCola != null) panelDepCocaCola.reposicionar();
        if (panelDepSprite != null) panelDepSprite.reposicionar();
        if (panelDepFanta != null) panelDepFanta.reposicionar();
        if (panelDepSnickers != null) panelDepSnickers.reposicionar();
        if (panelDepSuper8 != null) panelDepSuper8.reposicionar();

        System.out.println("makinola rellenada");
    }

    /**
     * Entrega el modelo lógico para uso del equipo
     * @return La instancia de Expendedor
     */
    public Expendedor getExpendedorLogico() {
        return this.expendedorLogico;
    }
}