package expendedor.logica;
/**
 * Representa un comprador que compra un producto del expendedor,
 * lo consume y recoge el vuelto
 */
public class Comprador {
    private String consumido;
    private int vuelto;

    /**
     * Crea un comprador que realiza una compra en el expendedor y recoge el vuelto.
     *
     * @param m moneda utilizada para pagar
     * @param tipo tipo de producto que se desea comprar
     * @param exp expendedor donde se realiza la compra
     * @throws PagoIncorrectoException si la moneda es null
     * @throws PagoInsuficienteException si el dinero no alcanza
     * @throws NoHayProductoException si no hay producto disponible
     */
    public Comprador(Moneda m,TipoProducto tipo,Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        Producto p= exp.comprarProducto(m, tipo);

        consumido=p.consumir();

        Moneda m_vuelto= exp.getVuelto();
        while (m_vuelto!=null){
            vuelto+=m_vuelto.getValor();
            m_vuelto= exp.getVuelto();
        }
    }
    /**
     * @return cantidad de vuelto acumulado
     */
    public int cuantoVuelto(){
        return vuelto;
    }
    /**
     * @return nombre o sabor del producto consumido
     */
    public String queConsumiste(){
        return consumido;
    }
}
