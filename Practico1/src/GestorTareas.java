package Practico1.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
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
            System.out.println("Indice invalido.");
        }
    }

    public void eliminarTareasCompletadas() {
        tareas.removeIf(t -> t.getEstado() == Tarea.Estado.completada);
        System.out.println("Tareas completadas eliminadas.");
    }

    // Extra
    public void guardarEnArchivo(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Paths.get("Practico1/src", "tareas.txt").toFile()))) { // Paths.get() para armar la ruta relativa
            for (Tarea tarea : tareas) {
                writer.println(tarea.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeArchivo(String nombreArchivo) {
        tareas.clear();
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("No hay archivo previo, comenzando con lista vacía.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    Tarea t = new Tarea(partes[0]);
                    if (partes[1].equalsIgnoreCase("completada")) {
                        t.setEstadoCompletada();
                    }
                    tareas.add(t);
                }
            }
            System.out.println("Tareas cargadas desde archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}