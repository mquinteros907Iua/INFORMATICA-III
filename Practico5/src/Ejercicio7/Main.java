package Ejercicio7;

public class Main {
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarFinal(40);

        System.out.print("Lista original: ");
        lista.imprimirLista();

        lista.invertir();

        System.out.print("Lista invertida: ");
        lista.imprimirLista();
    }
}