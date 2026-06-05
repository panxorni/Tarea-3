package expendedor.logica;
/**Esta clase es una de las que heredan de Bebida e implementa el comportamiento de consumo.
 * En esta se devolverá el nombre fanta cuando sea llamada.*/
public class Fanta extends Bebida{
    public Fanta (){
        super(TipoProducto.FANTA);
    }
    public String consumir(){
        return "fanta";
    }
}