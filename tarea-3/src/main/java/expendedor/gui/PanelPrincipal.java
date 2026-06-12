package expendedor.gui;

import expendedor.logica.Expendedor;
import expendedor.logica.Moneda;
import expendedor.logica.Producto;
import expendedor.logica.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//se debe implementar metodos paintComponent() para PanelComprador y PanelExpendedor

public class PanelPrincipal extends JPanel {

    private PanelComprador comprador;
    private PanelExpendedor expendedor;


    public PanelPrincipal () {

        expendedor = new PanelExpendedor (ConstantesGUI.EXPENDEDOR_X,ConstantesGUI.EXPENDEDOR_Y);
        comprador = new PanelComprador();


        this.setBackground(Color.white);

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                TipoProducto producto = comprador.procesoClick(e.getX(), e.getY());

                if(producto != null){ //mensaje en consola para probar que esta funcionando la seleccion
                    System.out.println(
                            "Producto seleccionado: "
                                    + producto
                    );
                }

                if(comprador.puedeComprar()){

                    try{
                        expendedor.getExpendedorLogico().comprarProducto(comprador.getMonedaSeleccionada(), comprador.getProductoSeleccionado());

                        comprador.eliminarMonedaSeleccionada();
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
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
    @Override
    public void paintComponent (Graphics g) {  //todo se dibuja a partir de este método
        super.paintComponent(g); //llama al método paint al que hace override en la super clase
        //el de la super clase solo pinta el fondo (background)

        comprador.paintComponent(g); //llama al metodo paintComponent definido en el PanelComprador
        expendedor.paintComponent(g); //llama al metodo paintComponent definido en el PanelExpendedor
    }
}