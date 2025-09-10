package Ejercicio4;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarFinal(40);

        System.out.print("Lista original: ");
        lista.imprimirLista(); // 10 -> 20 -> 30 -> 40 -> null

        lista.eliminar(30);

        System.out.print("Lista después de eliminar 30: ");
        lista.imprimirLista();
    }
}