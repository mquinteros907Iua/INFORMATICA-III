package Ejercicio1;

public class Node {
    int dato;
    Node siguiente;

    public Node(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return String.valueOf(dato);
    }
}
