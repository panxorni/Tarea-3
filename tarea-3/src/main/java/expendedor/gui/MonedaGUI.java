package expendedor.gui;

import java.awt.*;
import expendedor.logica.Moneda;

/**
 * Clase que representa gráficamente una moneda dentro de la interfaz
 * Permite dibujar la moneda como un círculo, diferenciarla por color según su valor
 * y detectar si un clic del mouse ocurrió dentro de sus límites
 */

public class MonedaGUI {
    protected Moneda moneda;
    protected int x;
    protected int y;
    protected int diametro;
    private boolean seleccionada;

    /**
     * Constructor de la clase MonedaGUI
     * Inicializa la moneda lógica asociada y define sus valores gráficos iniciales
     *
     * @param moneda Moneda lógica que será representada gráficamente
     */

    public MonedaGUI(Moneda moneda){
        this.moneda=moneda;
        this.x= 0;
        this.y= 0;
        this.diametro= 45;
    }

    /**
     * Entrega la moneda lógica asociada a esta representación gráfica
     *
     * @return La moneda representada por esta vista
     */

    public Moneda getMoneda(){
        return moneda;
    }
    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void monedaSeleccionada(boolean seleccionada){
        this.seleccionada = seleccionada;
    }
    public void paintComponent(Graphics g){
        g.setColor(colorMonedas());
        g.fillOval(x,y,diametro,diametro);
        g.setColor(Color.BLACK);
        g.drawOval(x,y,diametro,diametro);

        g.drawString("$" + moneda.getValor(), x+5, y+15);
        g.drawString("S: " + moneda.hashCode(), x+5, y+35);
        if(seleccionada){
            g.setColor(Color.RED);
            g.drawOval(
                    x - 3,
                    y - 3,
                    diametro + 6,
                    diametro + 6
            );
        }
    }
    private Color colorMonedas(){
        if(moneda.getValor()==100){
            return Color.lightGray;
        }
        else if(moneda.getValor()==500){
            return Color.darkGray;
        }
        else if(moneda.getValor()==1000){
            return Color.green;
        }
        else if (moneda.getValor()==1500){
            return Color.pink;
        }
        else{
            return Color.white;
        }
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public int getDiametro(){
        return diametro;
    }

    public boolean esContenido(int clickX, int clickY){

        return clickX >= x && clickX <= x + diametro && clickY >= y && clickY <= y + diametro;
    }
}
