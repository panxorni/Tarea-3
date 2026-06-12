package expendedor.gui;


import expendedor.logica.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Esta clase representa gráficamente al comprador en la interfaz
 * Permite seleccionar productos, seleccionar monedas del monedero y
 * mostrar productos comprados
 */
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
    private ArrayList<Producto> productosComprados;
    private String mensaje;

    /**
     * Constructor de la clase PanelComprador
     * inicializa la posición, dimensiones, botones de productos,
     * monedero inicial y lista de productos comprados
     */

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

    /**
     * Procesa un click realizado dentro del panel del comprador
     * Permite seleccionar un producto o una moneda del monedero
     *
     * @param clickX Coordenada X del click
     * @param clickY Coordenada Y del click
     * @return El tipo de producto seleccionado, o null si no se seleccionó un producto
     */

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
    /**
     * Dibuja el panel del comprador, los botones de productos,
     * el monedero, la moneda seleccionada, el producto seleccionado,
     * los productos comprados y el mensaje actual.
     *
     * @param g Objeto Graphics utilizado para dibujar el panel
     */
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
        g.setColor(Color.WHITE);

        g.drawString("Productos comprados:", x + 200, y + 40);
        int productoY = y + 60;
        int productoX = x + 200;
        for(Producto p : productosComprados){
            ProductoGUI productoGUI = new ProductoGUI(p);

            productoGUI.setXY(productoX, productoY);

            productoGUI.paintComponent(g);
            //g.drawString(p.getClass().getSimpleName(), productoX + 20, productoY);
            productoY += 60;
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

    /**
     * Verifica si un clicdk ocurrió dentro del área del panel comprador
     *
     * @param clickX Coordenada X del click
     * @param clickY Coordenada Y del click
     * @return true si el click está dentro del panel, false en caso contrario
     */

    public boolean contiene(int clickX, int clickY){

        return clickX >= x && clickX <= x + anchoPanel && clickY >= y && clickY <= y + altoPanel;
    }

    private void generarMonedas(){

        monedero.add(new MonedaGUI(new Moneda1000()));

        monedero.add(new MonedaGUI(new Moneda1000()));

        monedero.add(new MonedaGUI(new Moneda500()));
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

    /**
     * Indica si el comprador tiene un producto y una moneda seleccionados.
     *
     * @return true si existe un producto y una moneda seleccionados, false en caso contrario
     */

    public boolean puedeComprar(){

        return productoSeleccionado != null && monedaSeleccionada != null;
    }

    /**
     * Entrega el producto seleccionado actualmente por el comprador.
     *
     * @return El tipo de producto seleccionado, o null si no hay selección
     */

    public TipoProducto getProductoSeleccionado(){
        return productoSeleccionado;
    }

    /**
     * Entrega la moneda seleccionada actualmente por el comprador.
     *
     * @return La moneda seleccionada, o null si no hay moneda seleccionada.
     */

    public Moneda getMonedaSeleccionada(){

        if(monedaSeleccionada == null){
            return null;
        }

        return monedaSeleccionada.getMoneda();
    }
    /**
     * ELimina la moneda seleccionada actualmente.
     * Luego actualiza la posición de las monedas restantes y limpia la selección
     */
    public void eliminarMonedaSeleccionada(){

        if(monedaSeleccionada != null){

            monedero.remove(monedaSeleccionada);
            monedaSeleccionada = null;
            posicionarMonedero();
            productoSeleccionado = null;
        }
    }

    /**
     * Agrega un producto a la lista de productos comprados.
     *
     * @param producto Producto comprado que será almacenado visualmente.
     */

    public void agregarProducto(Producto producto){

        productosComprados.add(producto);
    }

    /**
     * Agrega una moneda al monedero del comprador
     *
     * @param moneda Moneda lógica que será representada gráficamente en el monedero
     */

    public void agregarMoneda(Moneda moneda){

        monedero.add(new MonedaGUI(moneda));

        posicionarMonedero();
    }

    /**
     * Define el mensaje que se mostrará en la interfaz
     *
     * @param mensaje Texto que se desea mostrar
     */

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
}