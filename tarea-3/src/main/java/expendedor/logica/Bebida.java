package expendedor.logica;
/** Esta clase es la que representa un tipo de producto que es bebida en la maquina expendedora.
 *  Hereda directamente de producto los atributos de las opciones de compras bebestibles.
 * Es la base para cada bebida.*/
   abstract public class Bebida extends Producto{
       public Bebida(TipoProducto tipo){
           super(tipo);
       }
}