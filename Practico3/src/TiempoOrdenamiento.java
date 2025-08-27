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
}
