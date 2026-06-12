package expendedor.gui;


import expendedor.logica.TipoProducto;

import java.awt.*;
import java.util.ArrayList;

public class PanelComprador{

    private int x;
    private int y;
    private int anchoPanel;
    private int altoPanel;
    private ArrayList<BotonProducto> botones;

    public PanelComprador(){

        x=ConstantesGUI.COMPRADOR_X;
        y=ConstantesGUI.COMPRADOR_Y;
        anchoPanel=ConstantesGUI.COMPRADOR_ANCHO;
        altoPanel=ConstantesGUI.COMPRADOR_ALTO;

        botones=new ArrayList<>();
        generarBotones();
    }

    public void procesoClick(int clickX, int clickY){
        for(BotonProducto b : botones){
            if(b.esContenido(clickX,clickY)){
                System.out.println("producto seleccionado " + b.getProducto().getNombre());
            }
        }
    }
    public void paintComponent(Graphics g){

        g.setColor(Color.darkGray);
        g.fillRect(x, y, anchoPanel, altoPanel);

        for (BotonProducto b: botones){
            b.draw(g);
        }
    }

    private void generarBotones(){
        int botonY= y+ConstantesGUI.MARGEN;

        for (TipoProducto tipo : TipoProducto.values()){

            botones.add(new BotonProducto(x+ConstantesGUI.MARGEN, botonY, tipo));

            botonY+=ConstantesGUI.BOTON_ALTO+ConstantesGUI.ESPACIADO;
        }
    }
}