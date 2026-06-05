package expendedor.logica;
/** El enum para los datos constantes que representan los
 * tipos de productos disponibles en la máquina expendedora.*/
public enum TipoProducto {
    COCACOLA ("CocaCola", 1000),
    FANTA ("Fanta", 1000),
    SPRITE ("Sprite", 1000),
    SUPER8 ("Super8", 300),
    SNICKERS ("Snickers", 400);
    /** Agregué nombres de los productos y su precio asociado al producto*/
    private final String nombre;
    private final int precio;
    /** El constructor crea tipos de productos con nombres y precios*/
    TipoProducto(String nombre, int precio){
        this.nombre=nombre;
        this.precio=precio;
    }
    /**Te da el nombre del producto*/
    public String getNombre(){
        return nombre;
    }
    public int getPrecio(){
        return precio;
    }
}