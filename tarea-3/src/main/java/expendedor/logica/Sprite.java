package expendedor.logica;
/**Esta clase es una de las que heredan de Bebida e implementa el comportamiento de consumo.
 * En esta se devolverá el nombre sprite cuando sea llamada.*/
public class Sprite extends Bebida{
    public Sprite(){
        super(TipoProducto.SPRITE);
    }
    public String consumir() {
        return "sprite";
    }
}
