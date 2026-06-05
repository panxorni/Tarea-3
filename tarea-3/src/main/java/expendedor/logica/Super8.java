package expendedor.logica;
/**Esta clase es una de las que heredan de Dulce e implementa el comportamiento de consumo.
 * En esta se devolverá el nombre super8 cuando sea llamada.*/
public class Super8 extends Dulce{
    public Super8(){
        super(TipoProducto.SUPER8);
    }
    public String consumir(){
        return "super8";
    }
}
