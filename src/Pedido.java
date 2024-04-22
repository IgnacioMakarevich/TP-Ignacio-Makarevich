public class Pedido {
    private FlujoPedido estado;

    public Pedido() {
        this.estado = FlujoPedido.BORRADOR;
    }

    public FlujoPedido getEstado() {
        return estado;
    }

    public void setEstado(FlujoPedido estado) {
        this.estado = estado;
    }
}