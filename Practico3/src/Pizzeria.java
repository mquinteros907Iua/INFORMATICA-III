import java.util.ArrayList;
import java.util.Scanner;

public class Pizzeria {

    public void agregarPedido(ArrayList<Pedido> listadoPedidos) {
        Scanner consola = new Scanner(System.in);
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
    }

    public void mostrarPedidos(ArrayList<Pedido> listadoPedidos) {
        System.out.println("Listado de Pedidos:");
        if (listadoPedidos.isEmpty()) {
            System.out.println("\nNo hay pedidos disponibles.");
        } else {
            for (int i = 0; i < listadoPedidos.size(); i++) {
                Pedido p = listadoPedidos.get(i);
                System.out.println(i + ". " + p.getNombreCliente() + " | Tiempo: " + p.getTiempoPreparacion()
                        + " min | Precio: $" + p.getPrecioTotal());
            }
        }
    }

    public void eliminarPedido(ArrayList<Pedido> listadoPedidos) {
        Scanner consola = new Scanner(System.in);
        mostrarPedidos(listadoPedidos);
        if (!listadoPedidos.isEmpty()) {
            System.out.println("Eliminar Pedido");
            System.out.print("Ingrese el índice del pedido a eliminar: ");
            int indiceEliminar = consola.nextInt();
            consola.nextLine();
            if (indiceEliminar >= 0 && indiceEliminar < listadoPedidos.size()) {
                listadoPedidos.remove(indiceEliminar);
                System.out.println("Pedido eliminado exitosamente.");
            } else {
                System.out.println("Índice inválido. No se pudo eliminar el pedido.");
            }
        }
    }

    public void modificarPedido(ArrayList<Pedido> listadoPedidos) {
        Scanner consola = new Scanner(System.in);
        mostrarPedidos(listadoPedidos);
        if (!listadoPedidos.isEmpty()) {
            System.out.println("Modificar Pedido");
            System.out.print("Ingrese el índice del pedido a modificar: ");
            int indiceModificar = consola.nextInt();
            consola.nextLine();
            if (indiceModificar >= 0 && indiceModificar < listadoPedidos.size()) {
                Pedido pedidoModificar = listadoPedidos.get(indiceModificar);
                System.out.print(
                        "Ingrese el nuevo nombre del cliente (actual: " + pedidoModificar.getNombreCliente() + "): ");
                String nuevoNombre = consola.nextLine();
                System.out.print(
                        "Ingrese el nuevo tiempo de preparación (actual: " + pedidoModificar.getTiempoPreparacion()
                                + "): ");
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
                System.out.println("Índice inválido. No se pudo modificar el pedido.");
            }
        }
    }

}
