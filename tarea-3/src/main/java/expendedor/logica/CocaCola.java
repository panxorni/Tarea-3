package expendedor.logica;
/**Esta clase es una de las que heredan de Bebida e implementa el comportamiento de consumo. *
 * En esta se devolverá el nombre cocacola cuando sea llamada.*/
public class CocaCola extends Bebida{
    public CocaCola (){
        super (TipoProducto.COCACOLA);
    }
    public String consumir(){
        return "cocacola";
    }
}