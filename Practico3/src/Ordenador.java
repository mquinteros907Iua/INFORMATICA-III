import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Ordenador {
    public void ordenarPorTiempoPreparacion(ArrayList<Pedido> listadoPedidos) {
        for (int i = 1; i < listadoPedidos.size(); i++) {
            Pedido key = listadoPedidos.get(i);
            int j = i - 1;
            while (j >= 0 && listadoPedidos.get(j).getTiempoPreparacion() > key.getTiempoPreparacion()) {
                listadoPedidos.set(j + 1, listadoPedidos.get(j));
                j--;
            }
            listadoPedidos.set(j + 1, key);
        }
    }

    public void ordenarPorPrecioTotal(ArrayList<Pedido> listadoPedidos) {
        int cantidadPedidos = listadoPedidos.size();
        for (int gap = cantidadPedidos / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < cantidadPedidos; i++) {
                Pedido temp = listadoPedidos.get(i);
                int j;
                for (j = i; j >= gap
                        && listadoPedidos.get(j - gap).getPrecioTotal() > temp.getPrecioTotal(); j -= gap) {
                    listadoPedidos.set(j, listadoPedidos.get(j - gap));
                }
                listadoPedidos.set(j, temp);
            }
        }
    }

    public void ordenarPorNombreCliente(ArrayList<Pedido> pedidos) {
        quicksort(pedidos, 0, pedidos.size() - 1);
    }

    private void quicksort(ArrayList<Pedido> pedidos, int low, int high) {
        if (low < high) {
            int pi = particion(pedidos, low, high);
            quicksort(pedidos, low, pi - 1);
            quicksort(pedidos, pi + 1, high);
        }
    }

    private int particion(ArrayList<Pedido> pedidos, int low, int high) {
        String pivot = pedidos.get(high).getNombreCliente();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (pedidos.get(j).getNombreCliente().compareToIgnoreCase(pivot) <= 0) {
                i++;
                Collections.swap(pedidos, i, j);
            }
        }
        Collections.swap(pedidos, i + 1, high);
        return i + 1;
    }

}