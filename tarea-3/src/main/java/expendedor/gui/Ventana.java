package expendedor.gui;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    public Ventana(){
        super("Expendedor");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        PanelPrincipal p= new PanelPrincipal();
        this.add(p);
        this.setVisible(true);
    }
}