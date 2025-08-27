import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pedido> listadoPedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int opcion = 0;
        Pizzeria pizzeria = new Pizzeria();
        Ordenador ordenador = new Ordenador();

        do {
            System.out.println("\nSistema de Gestión de Pedidos en una Pizzería");
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
                    System.out.println("Pedido agregado exitosamente.\n");
                    pizzeria.mostrarPedidos(listadoPedidos);
                    break;
                case 2:
                    if (!listadoPedidos.isEmpty()) {
                        pizzeria.eliminarPedido(listadoPedidos);
                        pizzeria.mostrarPedidos(listadoPedidos);
                    }
                    break;
                case 3:
                    if (!listadoPedidos.isEmpty()) {
                        pizzeria.modificarPedido(listadoPedidos);
                        pizzeria.mostrarPedidos(listadoPedidos);
                    }
                    break;
                case 4:
                    if (!listadoPedidos.isEmpty()) {
                        ordenador.ordenarPorTiempoPreparacion(listadoPedidos);
                        pizzeria.mostrarPedidos(listadoPedidos);
                    }
                    break;
                case 5:
                    if (!listadoPedidos.isEmpty()) {
                        ordenador.ordenarPorPrecioTotal(listadoPedidos);
                        pizzeria.mostrarPedidos(listadoPedidos);
                    }
                    break;
                case 6:
                    if (!listadoPedidos.isEmpty()) {
                        ordenador.ordenarPorNombreCliente(listadoPedidos);
                        pizzeria.mostrarPedidos(listadoPedidos);
                    }
                    break;
                case 7:
                    TiempoOrdenamiento tiempoOrdenamiento = new TiempoOrdenamiento();
                    tiempoOrdenamiento.probarOrdenamientos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.\nPor favor, seleccione una opción válida.");
                    break;
            }

        } while (opcion != 0);
        consola.close();
    }

}