package expendedor.gui;


import expendedor.logica.Moneda;
import expendedor.logica.Moneda1000;
import expendedor.logica.Moneda500;
import expendedor.logica.TipoProducto;

import java.awt.*;
import java.util.ArrayList;

public class PanelComprador{

    private int x;
    private int y;
    private int anchoPanel;
    private int altoPanel;
    private ArrayList<BotonProducto> botones;
    private TipoProducto productoSeleccionado;
    private ArrayList<MonedaGUI> botonesMonedas;
    private ArrayList<MonedaGUI> monedero;
    private MonedaGUI monedaSeleccionada;
    public PanelComprador(){

        x=ConstantesGUI.COMPRADOR_X;
        y=ConstantesGUI.COMPRADOR_Y;
        anchoPanel=ConstantesGUI.COMPRADOR_ANCHO;
        altoPanel=ConstantesGUI.COMPRADOR_ALTO;

        botones=new ArrayList<>();
        generarBotones();
        monedero=new ArrayList<>();
        generarMonedas();
        posicionarMonedero();
    }

    public TipoProducto procesoClick(int clickX, int clickY){

        if(!contiene(clickX, clickY)){ //si el click no esta en panel comprador no se procesa
            return null;
        }
        for(BotonProducto b : botones){

            if(b.esContenido(clickX, clickY)){
                productoSeleccionado = b.getProducto();
                return productoSeleccionado;
            }
        }

        for(MonedaGUI moneda : monedero){

            if(moneda.esContenido(
                    clickX,
                    clickY
            )){

                if(monedaSeleccionada != null){
                    monedaSeleccionada.monedaSeleccionada(false);
                }

                monedaSeleccionada = moneda;

                monedaSeleccionada.monedaSeleccionada(true);

                return null;
            }
        }
        return null;
    }
    public void paintComponent(Graphics g){

        g.setColor(Color.darkGray);
        g.fillRect(x, y, anchoPanel, altoPanel);

        for (BotonProducto b: botones){
            b.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Producto seleccionado: " + (productoSeleccionado == null ? "Ninguno" : productoSeleccionado.name()), x + 20, y + altoPanel - 20);

        for(MonedaGUI moneda : monedero){
            moneda.paintComponent(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Monedero", x + 20, y + 280);
        g.drawString("Moneda: " + (monedaSeleccionada == null ? "Ninguna" : "$" + monedaSeleccionada.getMoneda().getValor()), x + 20, y + altoPanel - 40);
    }

    private void generarBotones(){
        int botonY= y+ConstantesGUI.MARGEN;

        for (TipoProducto tipo : TipoProducto.values()){

            botones.add(new BotonProducto(x+ConstantesGUI.MARGEN, botonY, tipo));

            botonY+=ConstantesGUI.BOTON_ALTO+ConstantesGUI.ESPACIADO;
        }
    }

    public boolean contiene(int clickX, int clickY){

        return clickX >= x && clickX <= x + anchoPanel && clickY >= y && clickY <= y + altoPanel;
    }

    private void generarMonedas(){

        monedero.add(
                new MonedaGUI(
                        new Moneda1000()
                )
        );

        monedero.add(
                new MonedaGUI(
                        new Moneda1000()
                )
        );

        monedero.add(
                new MonedaGUI(
                        new Moneda500()
                )
        );
    }
    private void posicionarMonedero(){

        int monedaX = x + 20;
        int monedaY = y + 300;

        for(MonedaGUI moneda : monedero){

            moneda.setXY(
                    monedaX,
                    monedaY
            );

            monedaX += 60;
        }
    }
    public boolean puedeComprar(){

        return productoSeleccionado != null && monedaSeleccionada != null;
    }
    public TipoProducto getProductoSeleccionado(){
        return productoSeleccionado;
    }
    public Moneda getMonedaSeleccionada(){

        if(monedaSeleccionada == null){
            return null;
        }

        return monedaSeleccionada.getMoneda();
    }
}