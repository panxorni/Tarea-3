package expendedor.gui;

import expendedor.logica.Expendedor;
import expendedor.logica.Moneda;
import expendedor.logica.Producto;
import expendedor.logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 * Clase que representa el panel principal de la interfaz gráfica.
 * Contiene al PanelExpendedor y al PanelComprador, coordina el dibujo
 * de ambos componentes y administra los eventos de clic del mouse.
 */

public class PanelPrincipal extends JPanel {

    private PanelComprador comprador;
    private PanelExpendedor expendedor;

    /**
     * Constructor de la clase PanelPrincipal.
     * Inicializa el panel del expendedor, el panel del comprador,
     * define el color de fondo y configura el listener de eventos del mouse.
     */


    public PanelPrincipal () {

        expendedor = new PanelExpendedor (ConstantesGUI.EXPENDEDOR_X,ConstantesGUI.EXPENDEDOR_Y);
        comprador = new PanelComprador();


        this.setBackground(Color.white);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                TipoProducto producto = comprador.procesoClick(e.getX(), e.getY());


                if(comprador.puedeComprar()){

                    try{
                        expendedor.getExpendedorLogico().comprarProducto(comprador.getMonedaSeleccionada(), comprador.getProductoSeleccionado());

                    }
                    catch(Exception ex){
                        comprador.setMensaje(ex.getMessage()
                        );
                    }
                    comprador.eliminarMonedaSeleccionada();
                }

                Producto producto_seleccionado = expendedor.procesoClick(e.getX(), e.getY());
                if(producto_seleccionado != null){

                    comprador.agregarProducto(producto_seleccionado);
                }

                Moneda vuelto = expendedor.retirarVuelto(e.getX(), e.getY());

                if(vuelto != null){

                    comprador.agregarMoneda(vuelto);
                }
                repaint();
            }
        });
    }

    /**
     * Dibuja el panel principal y delega el dibujo de sus componentes internos.
     * Primero se dibuja el fondo del JPanel mediante super.paintComponent(g),
     * luego se dibuja el comprador y finalmente el expendedor.
     *
     * @param g Objeto Graphics utilizado para dibujar los componentes.
     */

    @Override
    public void paintComponent (Graphics g) {  //todo se dibuja a partir de este método
        super.paintComponent(g); //llama al método paint al que hace override en la super clase
        //el de la super clase solo pinta el fondo (background)

        comprador.paintComponent(g); //llama al metodo paintComponent definido en el PanelComprador
        expendedor.paintComponent(g); //llama al metodo paintComponent definido en el PanelExpendedor
    }
}