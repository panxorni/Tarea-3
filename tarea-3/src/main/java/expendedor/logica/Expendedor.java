package expendedor.logica;

/**
 * Simula una máquina expendedora que almacena productos y procesa compras.
 * Gestiona depósitos individuales para distintos tipos de productos y un depósito
 * para las monedas de vuelto.
 */
public class Expendedor{

    private Deposito<Moneda> depositoVuelto;
    private Deposito<Producto> depositoCocaCola;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoSuper8;

    /**
     * Vacía el depósito de vuelto eliminando todas las monedas.
     * Se utiliza antes de procesar una nueva compra.
     */
    private void limpiarVuelto() {
        while (getVuelto() != null);
    }
    /**
     * Constructor del Expendedor.
     * Inicializa los depósitos y los llena con la cantidad especificada de productos.
     *
     * @param numProductos La cantidad inicial de unidades que tendrá cada tipo de producto.
     */
    public Expendedor(int numProductos){
        depositoVuelto = new Deposito<>();
        depositoCocaCola = new Deposito<>();
        depositoSprite = new Deposito<>();
        depositoFanta = new Deposito<>();
        depositoSnickers = new Deposito<>();
        depositoSuper8 = new Deposito<>();


        for (int i = 0; i < numProductos; i++){
            depositoCocaCola.addElemento(new CocaCola());
            depositoSprite.addElemento(new Sprite());
            depositoFanta.addElemento(new Fanta());
            depositoSnickers.addElemento(new Snickers());
            depositoSuper8.addElemento(new Super8());
        }
    }

    /**
     * Retorna el depósito correspondiente al tipo de producto.
     *
     * @param tipo tipo de producto
     * @return depósito asociado o null si el tipo no es válido
     */
    private Deposito<Producto> getDeposito(TipoProducto tipo) {
        if (tipo==null){
            return null;
        }
        else{
            switch (tipo) {
                case COCACOLA:
                    return depositoCocaCola;
                case SPRITE:
                    return depositoSprite;
                case FANTA:
                    return depositoFanta;
                case SNICKERS:
                    return depositoSnickers;
                case SUPER8:
                    return depositoSuper8;
                default:
                    return null;
            }
        }
    }

    /**
     * Procesa la compra de un producto. Verifica que el pago sea válido, que el
     * monto sea suficiente y que exista stock del producto solicitado.
     *
     * @param m    La moneda con la que se intenta pagar.
     * @param tipo El enumerador que indica el tipo de producto deseado.
     * @return El Producto comprado.
     * @throws PagoIncorrectoException   Si la moneda ingresada es null.
     * @throws PagoInsuficienteException Si el valor de la moneda es menor al precio del producto.
     * @throws NoHayProductoException    Si no queda stock del producto o el tipo es inválido.
     */
    public Producto comprarProducto(Moneda m, TipoProducto tipo) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        limpiarVuelto();
        // 1. Verificación de moneda nula
        if (m == null){
            throw new PagoIncorrectoException("Error: Se intentó comprar sin ingresar dinero (Moneda null).");
        }

        // 2. Verificación de tipo de producto agotado o no válido
        //Obtener deposito correspondiente
        Deposito<Producto> deposito= getDeposito(tipo);
        if (deposito == null || deposito.isEmpty()){
            depositoVuelto.addElemento(m);
            throw new NoHayProductoException("Error: El tipo de producto esta agotado o no es válido.");
        }

        int precio = tipo.getPrecio();

        // 3. Verificación de pago insuficiente
        if (m.getValor() < precio){
            depositoVuelto.addElemento(m); // Se devuelve la misma moneda
            throw new PagoInsuficienteException("Error: El monto ingresado ($" + m.getValor() + ") es insuficiente para el producto seleccionado ($" + precio + ").");
        }

        // 4. Extracción del producto del depósito correspondiente
        Producto productoComprado = null;
        switch (tipo){
            case COCACOLA:
                productoComprado = depositoCocaCola.getElemento();
                break;
            case SPRITE:
                productoComprado = depositoSprite.getElemento();
                break;
            case FANTA:
                productoComprado = depositoFanta.getElemento();
                break;
            case SNICKERS:
                productoComprado = depositoSnickers.getElemento();
                break;
            case SUPER8:
                productoComprado = depositoSuper8.getElemento();
                break;
        }

        // 5. Verificación de stock
        if (productoComprado == null){
            depositoVuelto.addElemento(m); // Se devuelve la misma moneda si no hay stock
            throw new NoHayProductoException("Error: No queda stock del producto seleccionado (" + tipo.name() + ").");
        }

        // 6. Cálculo y entrega del vuelto (solo si la compra es exitosa)
        // La moneda de pago se extingue y se genera el vuelto en monedas de 100
        int montoVuelto = m.getValor() - precio;
        while (montoVuelto > 0){
            depositoVuelto.addElemento(new Moneda100());
            montoVuelto -= 100;
        }

        return productoComprado;
    }

    /**
     * Permite retirar una moneda de vuelto a la vez desde el depósito de vuelto.
     *
     * @return Una Moneda de vuelto, o null si ya no quedan monedas.
     */
    public Moneda getVuelto(){
        return depositoVuelto.getElemento();
    }
}