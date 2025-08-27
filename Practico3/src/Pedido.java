public class Pedido {
    String nombreCliente;;
    int tiempoPreparacion;
    double precioTotal;

    public Pedido(String nombreCliente, int tiempoPreparacion, double precioTotal){
        this.nombreCliente = nombreCliente;
        this.tiempoPreparacion = tiempoPreparacion;
        this.precioTotal = precioTotal;
    }

    public String setNombreCliente(String nuevoNombre){
        return this.nombreCliente = nuevoNombre;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public int setTiempoPreparacion(int tiempoPreparacion){
        return this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getTiempoPreparacion(){
        return tiempoPreparacion;
    }

    public double setPrecioTotal(double precioTotal){
        return this.precioTotal = precioTotal;
    }
    
    public double getPrecioTotal(){
        return precioTotal;
    }

    public String toString(){
        return "Cliente: " + nombreCliente + ", Tiempo de Preparación: " + tiempoPreparacion + " mins, Precio Total: $" + precioTotal;
    }
}
