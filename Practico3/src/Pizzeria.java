public class Pizzeria {
    Pedido[] pedidos;
    int cantidadPedidos;

    public Pizzeria(int capacidad) {
        this.pedidos = new Pedido[capacidad];
        this.cantidadPedidos = 0;
    }

    public int getCantidadPedidos() {
        return cantidadPedidos;
    }

    public int setCantidadPedidos(int cantidadPedidos) {
        return this.cantidadPedidos = cantidadPedidos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadPedidos; i++) {
            sb.append(pedidos[i].toString()).append("\n");
        }
        return sb.toString();
    }

}
