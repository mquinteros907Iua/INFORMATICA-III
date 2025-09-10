package Ejercicio9;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(10);
        lista.insertarFinal(30);
        lista.insertarFinal(20);
        lista.insertarFinal(40);
        lista.insertarFinal(30);

        System.out.print("Lista original: ");
        lista.imprimirLista();

        // Eliminar duplicados
        lista.eliminarDuplicados();

        System.out.print("Después de eliminar duplicados: ");
        lista.imprimirLista();

    }
}