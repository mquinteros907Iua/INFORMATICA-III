package Ejercicio6;

public class Main {
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarFinal(1);
        lista.insertarFinal(2);
        lista.insertarFinal(3);
        lista.insertarFinal(4);
        lista.insertarFinal(5);

        lista.imprimirLista();

        System.out.println("\nCantidad de elementos en la lista: " + lista.contar());

    }
}