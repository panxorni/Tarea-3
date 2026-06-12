package expendedor.gui;


import expendedor.logica.*;

import java.awt.*;
import java.util.ArrayList;

public class PanelComprador{

    private int x;
    private int y;
    private int anchoPanel;
    private int altoPanel;
    private ArrayList<BotonProducto> botones;
    private TipoProducto productoSeleccionado;
    private ArrayList<MonedaGUI> monedero;
    private MonedaGUI monedaSeleccionada;
    private ArrayList<Producto> productosComprados;
    private String mensaje;

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
        productosComprados = new ArrayList<>();
        mensaje = "";
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
        g.drawString("Producto seleccionado: ", x + 20,y + 280);
        g.drawString( (productoSeleccionado == null ? "Ninguno" : productoSeleccionado.name()), x + 20, y + 290);

        for(MonedaGUI moneda : monedero){
            moneda.paintComponent(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Monedero", x + 20, y + altoPanel-120);

        g.setColor(Color.lightGray);
        g.fillRect(x+200, y+20, 160, 290);
        g.setColor(Color.BLACK);
        g.drawString("Productos comprados:", x + 220, y + 40);
        int productoY = y + 60;
        int productoX = x + 215;
        for(Producto p : productosComprados){
            ProductoGUI productoGUI = new ProductoGUI(p);

            productoGUI.setXY(productoX, productoY);

            productoGUI.paintComponent(g);

            productoY += 60;

            if(productoY > y + 280){
                productoX += 75;
                productoY = y+60;
            }
        }

        g.setColor(Color.RED);
        g.drawString(mensaje, 40, 15);
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

        monedero.add(new MonedaGUI(new Moneda1500()));

        monedero.add(new MonedaGUI(new Moneda1000()));

        monedero.add(new MonedaGUI(new Moneda500()));
    }
    private void posicionarMonedero(){

        int monedaX = x + 20;
        int monedaY = y + altoPanel-110;

        for(MonedaGUI moneda : monedero){

            moneda.setXY(monedaX, monedaY);

            monedaX += 60;
            if(monedaX>=x+anchoPanel-10){
                monedaX=x+20;
                monedaY+=50;
            }
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
    public Moneda eliminarMonedaSeleccionada(){

        if(monedaSeleccionada != null){

            monedero.remove(monedaSeleccionada);
            monedaSeleccionada = null;
            posicionarMonedero();
            productoSeleccionado = null;
        }
        return null;
    }
    public void agregarProducto(Producto producto){

        productosComprados.add(producto);
    }
    public void agregarMoneda(Moneda moneda){

        monedero.add(new MonedaGUI(moneda));

        posicionarMonedero();
    }
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
}