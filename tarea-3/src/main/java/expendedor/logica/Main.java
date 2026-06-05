package expendedor.logica;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase main de pruebas.
 *
 * Este main simula el uso del expendedor:
 * - Crea un expendedor y distintas monedas
 * - Realiza compras en distintas situaciones
 * - Prueba el manejo de excepciones
 * - Ordena monedas usando Comparable
 */
public class Main {
    /**
     * Ejecuta pruebas del sistema de expendedor.
     *
     * Se prueban los siguientes casos:
     * 1. Compra exitosa
     * 2. Compra con vuelto
     * 3. Pago insuficiente
     * 4. Moneda null
     * 5. Producto agotado
     * 6. Ordenamiento de monedas
     */
    public static void main(String[] args) {
        Expendedor exp= new Expendedor(3);
        Moneda m100=new Moneda100();
        Moneda m500=new Moneda500();
        Moneda m1000=new Moneda1000();
        Moneda m1500=new Moneda1500();
        Moneda mnull=null;

        System.out.println("Test 1: Compra exitosa");
        try{
            Comprador c_exitoso=new Comprador(m1000, TipoProducto.SPRITE, exp);
            System.out.println("Consumió "+c_exitoso.queConsumiste());
            System.out.println(("Vuelto: "+c_exitoso.cuantoVuelto()));
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nTest 2: Compra con vuelto");
        try{
            Comprador c_convuelto=new Comprador(m1500, TipoProducto.FANTA, exp);
            System.out.println("Consumió "+ c_convuelto.queConsumiste());
            System.out.println("Vuelto: "+c_convuelto.cuantoVuelto());
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nTest 3: Pago insuficiente");
        try{
            Comprador c_pagoinsuficiente=new Comprador(m100, TipoProducto.SNICKERS, exp);
            System.out.println("Consumió "+ c_pagoinsuficiente.queConsumiste());
            System.out.println("Vuelto: "+ c_pagoinsuficiente.cuantoVuelto());
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nTest 4: Moneda null");
        try{
            Comprador c_mnull=new Comprador(mnull, TipoProducto.SUPER8, exp);
            System.out.println("Consumió "+ c_mnull.queConsumiste());
            System.out.println(("Vuelto: "+ c_mnull.cuantoVuelto()));
        }catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nTest 5: Producto agotado");
        try{
            Comprador c_agotado=new Comprador(m1000, TipoProducto.COCACOLA, exp);
            c_agotado= new Comprador(m1000, TipoProducto.COCACOLA, exp);
            c_agotado= new Comprador(m1000, TipoProducto.COCACOLA, exp);
            c_agotado= new Comprador(m1000, TipoProducto.COCACOLA, exp);
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        //Ordenamiento de monedas con la implementación de comparable
        System.out.println("\nOrdenamiento de monedas:");
        ArrayList<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda1500());
        monedas.add(new Moneda100());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda500());
        System.out.println("\nMonedas desordenadas:");
        for (Moneda m : monedas){
            System.out.println(m.getValor());
        }
        Collections.sort(monedas);
        System.out.println("\nMonedas ordenadas:");
        for (Moneda m : monedas){
            System.out.println(m.getValor());
        }
    }
}