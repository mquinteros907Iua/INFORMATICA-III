package Practico1.src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();

        int opcion;
        do {
            System.out.println("\n===== Menú Gestor de Tareas =====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tareas completadas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                   String descripcion;
                    do {
                        System.out.print("Ingrese la descripción de la tarea: ");
                        descripcion = sc.nextLine();
                        if (descripcion.trim().isEmpty()) {
                            System.out.println("Error: la descripción no puede estar vacía. Intente de nuevo.");
                        }
                    } while (descripcion.trim().isEmpty());
                    gestor.agregarTarea(descripcion);
                    break;

                case 2:
                    gestor.listarTareas();
                    break;

                case 3:
                    gestor.listarTareas();
                    System.out.print("Ingrese el número de la tarea a completar: ");
                    if (sc.hasNextInt()) { //hasNextInt chequea si la entrada es un entero
                        int indice = sc.nextInt() - 1; // Restar 1 porque las listas empiezan en 0
                        gestor.marcarComoCompletada(indice);
                    } else {
                        System.out.println("Entrada inválida.");
                        sc.next();
                    }
                    break;

                case 4:
                    gestor.eliminarTareasCompletadas();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
