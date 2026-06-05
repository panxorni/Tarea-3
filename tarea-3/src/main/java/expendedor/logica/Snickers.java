package expendedor.logica;
/**Esta clase es una de las que heredan de Dulce e implementa el comportamiento de consumo.
 * En esta se devolverá el nombre snickers cuando sea llamada.*/
public class Snickers extends Dulce{
    public Snickers(){
        super(TipoProducto.SNICKERS);
    }
    public String consumir(){
        return "snickers";
    }
}
