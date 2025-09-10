package Ejercicio1;

public class ListNode {
    Node head; // primer nodo
    int size; // cantidad de nodos

    public ListNode() {
        this.head = null;
        this.size = 0;
    }

    public void agregarNode(int dato) {
        Node newNode = new Node(dato);

        if (head == null) {
            head = newNode;
        } else {
            Node actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = newNode;
        }
        size++;
    }

    public void imprimirLista() {
        Node actual = head;

        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente; // avanzar al siguiente nodo
        }
        System.out.println("null"); // fin de la lista
    }
}
