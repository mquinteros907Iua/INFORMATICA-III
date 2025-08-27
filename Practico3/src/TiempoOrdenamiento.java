import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TiempoOrdenamiento {

    private long tiempoInicio;
    private long tiempoFin;

    public void iniciar() {
        tiempoInicio = System.nanoTime();
    }

    public void finalizar() {
        tiempoFin = System.nanoTime();
    }

    public long obtenerTiempoEjecucion() {
        return tiempoFin - tiempoInicio;
    }

    public String formatoTiempo(long tiempoNano) {
        double tiempoMillis = tiempoNano / 1_000_000.0;
        return String.format("%.3f ms", tiempoMillis);
    }

    // ----------- Funcionalidad de prueba -----------

    public void probarOrdenamientos() {
        int[] tamanos = { 100, 1000, 10000 };

        for (int n : tamanos) {
            ArrayList<Pedido> lista = generarPedidos(n);

            // Copia para cada algoritmo (para que ordenen lo mismo)
            ArrayList<Pedido> listaQuicksort = new ArrayList<>(lista);
            ArrayList<Pedido> listaSortJava = new ArrayList<>(lista);

            // ---- Probar Quicksort ----
            iniciar();
            ordenarPorNombreCliente(listaQuicksort);
            finalizar();
            System.out.println("Quicksort con " + n + " pedidos: "
                    + formatoTiempo(obtenerTiempoEjecucion()));

            // ---- Probar sort() de Java ----
            iniciar();
            listaSortJava.sort(Comparator.comparing(Pedido::getNombreCliente));
            finalizar();
            System.out.println("Java sort() con " + n + " pedidos: "
                    + formatoTiempo(obtenerTiempoEjecucion()));

            System.out.println("----------------------------------");
        }
    }
    // Genera lista de pedidos aleatorios
    private ArrayList<Pedido> generarPedidos(int cantidad) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            String nombre = "Cliente" + rand.nextInt(10000);
            pedidos.add(new Pedido(nombre, rand.nextInt(60) + 1, rand.nextDouble() * 100));
        }
        return pedidos;
    }

    // Tu quicksort adaptado aquí dentro
    private void ordenarPorNombreCliente(ArrayList<Pedido> pedidos) {
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
