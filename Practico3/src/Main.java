import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pedido> listadoPedidos = new ArrayList<Pedido>();
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
       int opcion = 0;
        do{
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
                    System.out.println("Agregar Pedido");
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = consola.nextLine();
                    System.out.print("Ingrese el tiempo de preparación (en minutos): ");
                    int tiempoPreparacion = consola.nextInt();
                    consola.nextLine();
                    System.out.print("Ingrese el precio total: ");
                    double precioTotal = consola.nextDouble();
                    consola.nextLine();
                    Pedido nuevoPedido = new Pedido(nombreCliente, tiempoPreparacion, precioTotal);
                    listadoPedidos.add(nuevoPedido);
                    System.out.println("Pedido agregado exitosamente.");
                    break;
                case 2:
                    System.out.println("Pedidos actuales:");
                    for (int i = 0; i < listadoPedidos.size(); i++) {
                        Pedido p = listadoPedidos.get(i);
                        System.out.println(i + ". " + p.getNombreCliente() + " | Tiempo: " + p.getTiempoPreparacion() + " min | Precio: $" + p.getPrecioTotal());
                    }
                    System.out.println("\nEliminar Pedido");
                    System.out.print("Ingrese el índice del pedido a eliminar: ");
                    int indiceEliminar = consola.nextInt();
                    if (indiceEliminar >= 0 && indiceEliminar < listadoPedidos.size()) {
                        listadoPedidos.remove(indiceEliminar);
                        System.out.println("Pedido eliminado exitosamente.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                System.out.println("Pedidos actuales:");
                    for (int i = 0; i < listadoPedidos.size(); i++) {
                        Pedido p = listadoPedidos.get(i);
                        System.out.println(i + ". " + p.getNombreCliente() + " | Tiempo: " + p.getTiempoPreparacion() + " min | Precio: $" + p.getPrecioTotal());
                    }
                    System.out.println("\nModificar Pedido");
                    System.out.print("Ingrese el índice del pedido a modificar: ");
                    int indiceModificar = consola.nextInt();
                    consola.nextLine(); 
                    if (indiceModificar >= 0 && indiceModificar < listadoPedidos.size()) {
                        Pedido pedidoModificar = (Pedido) listadoPedidos.get(indiceModificar);
                        System.out.print("Ingrese el nuevo nombre del cliente (actual: " + pedidoModificar.getNombreCliente() + "): ");
                        String nuevoNombre = consola.nextLine();
                        System.out.print("Ingrese el nuevo tiempo de preparación (actual: " + pedidoModificar.getTiempoPreparacion() + "): ");
                        int nuevoTiempo = consola.nextInt();
                        consola.nextLine();
                        System.out.print("Ingrese el nuevo precio total (actual: " + pedidoModificar.getPrecioTotal() + "): ");
                        double nuevoPrecio = consola.nextDouble();
                        consola.nextLine();
                        pedidoModificar.setNombreCliente(nuevoNombre);
                        pedidoModificar.setTiempoPreparacion(nuevoTiempo);
                        pedidoModificar.setPrecioTotal(nuevoPrecio);
                        System.out.println("Pedido modificado exitosamente.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    System.out.println("Ordenar por Tiempo de Preparación (Inserción)");
                   // Ordenador.insercion(listadoPedidos);
                    System.out.println("Pedidos ordenados por tiempo de preparación:");
                default:
                    System.out.println("Opción inválida.\nPor favor, seleccione una opción válida.");
                    break;
            } 
             
        }while(opcion != 0);
        consola.close();
    }

}