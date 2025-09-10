package Ejercicio10;

class Node<T> {
    T nombre;
    int legajo;
    Node<T> siguiente;

    public Node(T nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.siguiente = null;
    }
}
