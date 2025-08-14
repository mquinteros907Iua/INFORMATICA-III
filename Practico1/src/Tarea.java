package Practico1.src;

public class Tarea {
    private String descripcion;
    public enum Estado {pendiente, completada};

    private Estado estado;

    public Tarea(String descripcion){
        this.descripcion = descripcion;
        this.estado = Estado.pendiente;
    }

     public String getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstadoCompletada() {
        this.estado = Estado.completada;
    }

    @Override
    public String toString() {
        return descripcion + " - " + estado;
    }
}
