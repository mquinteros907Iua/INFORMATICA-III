package structs;

public class Node<T> {
    T dato;
    Node<T> siguiente;

    public Node(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
}
