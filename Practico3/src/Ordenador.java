import java.util.ArrayList;

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

}