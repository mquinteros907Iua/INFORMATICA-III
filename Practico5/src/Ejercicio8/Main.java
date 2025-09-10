package Ejercicio8;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(40);

        System.out.print("Lista original: ");
        lista.imprimirLista();

        // Insertar al inicio (pos = 0)
        lista.insertarEn(0, 5);
        System.out.print("Después de insertar 5 en posición 0: ");
        lista.imprimirLista();

        // Insertar en el medio (pos = 2)
        lista.insertarEn(2, 15);
        System.out.print("Después de insertar 15 en posición 2: ");
        lista.imprimirLista();

    }
}