package expendedor.gui;

import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal de la aplicación
 * Extiende JFrame y contiene el PanelPrincipal donde se dibuja
 * la interfaz gráfica de la máquina expendedora
 */

public class Ventana extends JFrame {

    /**
     * Constructor de la clase Ventana
     * Inicializa la ventana principal, define su tamaño,
     * configura su comportamiento de cierre y agrega el panel principal
     */

    public Ventana(){
        super("Expendedor");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(ConstantesGUI.VENTANA_ANCHO, ConstantesGUI.VENTANA_ALTO);
        this.setLocationRelativeTo(null);
        PanelPrincipal p= new PanelPrincipal();
        this.add(p);
        this.setVisible(true);
    }
}