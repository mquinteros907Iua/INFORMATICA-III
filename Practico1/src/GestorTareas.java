package Practico1.src;

import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> tareas;
    
    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            tareas.add(new Tarea(descripcion));
            System.out.println("Tarea agregada correctamente.");
        } else {
            System.out.println("Error: la descripción no puede estar vacía.");
        }
    }

    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
    }

    public void marcarComoCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).setEstadoCompletada();
            System.out.println("Tarea marcada como completada.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void eliminarTareasCompletadas() {
        tareas.removeIf(t -> t.getEstado() == Tarea.Estado.completada);
        System.out.println("Tareas completadas eliminadas.");
    }    
}

