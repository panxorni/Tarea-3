package expendedor.logica;

import java.util.Scanner;

/**
 * Clase main interactivo.
 *
 * Permite al usuario seleccionar un producto y pagar con una moneda,
 * simulando el funcionamiento de la máquina expendedora en consola.
 *
 * El programa se ejecuta hasta que el usuario decide salir.
 */
public class MainInteractivo {
    /**
     * El usuario puede:
     * - Elegir un producto
     * - Ingresar una moneda
     * - Recibir el producto y el vuelto
     * - Detener la ejecución
     *
     * También se manejan errores como:
     * - Producto invalido
     * - Pago insuficiente
     * - Moneda inválida o null
     * - Producto agotado
     */
    public static void main(String[] args) {
        //Scanner para leer datos de la consola
        Scanner escaner= new Scanner(System.in);
        Expendedor exp=new Expendedor(3);

        boolean corriendo=true;
        while(corriendo){
            System.out.println("||>=====================<||");
            System.out.println("||  Maquina expendedora  ||");
            System.out.println("||>=====================<||");
            System.out.println("|| 1. CocaCola     $1000 ||");
            System.out.println("|| 2. Fanta        $1000 ||");
            System.out.println("|| 3. Sprite       $1000 ||");
            System.out.println("|| 4. Super8        $300 ||");
            System.out.println("|| 5. Snickers      $400 ||");
            System.out.println("|| 0. Salir              ||");
            System.out.println("||>=====================<||");
            System.out.println("\nSeleccione el producto");
            int eleccion= escaner.nextInt();

            if(eleccion==0){
                corriendo=false;
                break;
            }
            //Se convierte el valor ingresado int a TipoProducto
            TipoProducto tipo=null;
            switch (eleccion){
                case 1:
                    tipo= TipoProducto.COCACOLA;
                    break;
                case 2:
                    tipo= TipoProducto.FANTA;
                    break;
                case 3:
                    tipo= TipoProducto.SPRITE;
                    break;
                case 4:
                    tipo= TipoProducto.SUPER8;
                    break;
                case 5:
                    tipo= TipoProducto.SNICKERS;
                    break;
                default:
                    System.out.println("Producto invalido");
                    continue;
            }
            System.out.println("||>=====================<||");
            System.out.println("||  Maquina expendedora  ||");
            System.out.println("||>=====================<||");
            System.out.println("||    Ingrese el pago    ||");
            System.out.println("||>=====================<||");
            System.out.println("||    Solo se aceptan    ||");
            System.out.println("||    las monedas de:    ||");
            System.out.println("||                       ||");
            System.out.println("||   $100        $500    ||");
            System.out.println("||   $1000       $1500   ||");
            System.out.println("||>=====================<||");

            int valor= escaner.nextInt();

            //Se convierte el número ingresado a una moneda de ese valor
            Moneda m=null;
            switch (valor){
                case 100:
                    m=new Moneda100();
                    break;
                case 500:
                    m=new Moneda500();
                    break;
                case 1000:
                    m=new Moneda1000();
                    break;
                case 1500:
                    m=new Moneda1500();
                    break;
                default:
                    System.out.println("Metodo de pago invalido");
            }
            //Intento de compra + maneja de excepciones
            try{
                Comprador c=new Comprador(m, tipo, exp);
                System.out.println("Compro: "+c.queConsumiste());
                System.out.println("Vuelto: "+c.cuantoVuelto());
            }catch(PagoIncorrectoException |PagoInsuficienteException | NoHayProductoException e){
                System.out.println(e.getMessage());
            }
            System.out.println("");
        }
        escaner.close();
    }
}
