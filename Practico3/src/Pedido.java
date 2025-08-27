public class Pedido {
    String nombreCliente;;
    int tiempoPreparacion;
    double precioTotal;

    public Pedido(String nombreCliente, int tiempoPreparacion, double precioTotal){
        this.nombreCliente = nombreCliente;
        this.tiempoPreparacion = tiempoPreparacion;
        this.precioTotal = precioTotal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setNombreCliente(String nuevoNombre) {
        this.nombreCliente = nuevoNombre;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String toString(){
        return "Cliente: " + nombreCliente + ", Tiempo de Preparación: " + tiempoPreparacion + " mins, Precio Total: $" + precioTotal;
    }
}
