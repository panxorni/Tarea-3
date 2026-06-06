package expendedor.gui;


import java.awt.*;

public class PanelComprador{

    private int x;
    private int y;
    private int anchoPanel;
    private int altoPanel;

    public PanelComprador(){

        x=ConstantesGUI.COMPRADOR_X;
        y=ConstantesGUI.COMPRADOR_Y;
        anchoPanel=ConstantesGUI.COMPRADOR_ANCHO;
        altoPanel=ConstantesGUI.COMPRADOR_ALTO;
    }

    public void paintComponent(Graphics g){

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, anchoPanel, altoPanel);

    }

}
