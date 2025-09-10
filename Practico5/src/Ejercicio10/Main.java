package Ejercicio10;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.agregarAlumno("Marcos", 101);
        lista.agregarAlumno("Lucas", 102);
        lista.agregarAlumno("Guido", 103);

        System.out.println("Lista inicial:");
        lista.mostrarAlumnos();

        int legajoBuscar = 102;
        Node<String> encontrado = lista.buscarAlumno(legajoBuscar);
        if (encontrado != null) {
            System.out.println("\nAlumno encontrado: " + encontrado.nombre + " (Legajo: " + encontrado.legajo + ")");
        } else {
            System.out.println("\nAlumno con legajo " + legajoBuscar + " no encontrado.");
        }

        int legajoEliminar = 101;
        boolean eliminado = lista.eliminarAlumno(legajoEliminar);
        if (eliminado) {
            System.out.println("\nAlumno con legajo " + legajoEliminar + " eliminado.");
        } else {
            System.out.println("\nNo se encontró alumno con legajo " + legajoEliminar);
        }

        System.out.println("\nLista final:");
        lista.mostrarAlumnos();
    }
}