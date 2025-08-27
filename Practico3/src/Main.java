import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pedido> listadoPedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int opcion = 0;
        Pizzeria pizzeria = new Pizzeria();
        do {
            System.out.println("Sistema de Gestión de Pedidos en una Pizzería");
            System.out.println("----------------------------------------------");
            System.out.println("Gestión de Pedidos");
            System.out.println("1. Agregar Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Modificar Pedido");
            System.out.println("Ordenamiento de Pedidos");
            System.out.println("4. Ordenar por Tiempo de Preparación (Inserción)");
            System.out.println("5. Ordenar por Precio Total (Shellsort)");
            System.out.println("6. Ordenar por Nombre del Cliente (Quicksort)");
            System.out.println("Captura de Tiempos de Ejecución");
            System.out.println("7. Medir Tiempos de Ejecución");
            System.out.println("0. Salir");
            System.out.println("----------------------------------------------");
            System.out.print("Seleccione una opción: ");
            opcion = consola.nextInt();
            consola.nextLine();

            switch (opcion) {
                case 1:
                    pizzeria.agregarPedido(listadoPedidos);
                    System.out.println("Pedido agregado exitosamente.");
                    break;
                case 2:
                    pizzeria.eliminarPedido(listadoPedidos);
                    System.out.println("Pedido eliminado exitosamente.");
                    break;
                case 3:
                    pizzeria.modificarPedido(listadoPedidos);
                    System.out.println("Pedido modificado exitosamente.");
                    break;
                case 4:
                    System.out.println("Ordenar por Tiempo de Preparación (Inserción)");
                    // Ordenador.insercion(listadoPedidos);
                    System.out.println("Pedidos ordenados por tiempo de preparación:");
                default:
                    System.out.println("Opción inválida.\nPor favor, seleccione una opción válida.");
                    break;
            }

        } while (opcion != 0);
        consola.close();
    }

}