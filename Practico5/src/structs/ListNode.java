package structs;

public class ListNode {
    Node head; // primer nodo
    int size; // cantidad de nodos

    public ListNode() {
        this.head = null;
        this.size = 0;
    }

    public void insertarFinal(int dato) {
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

    public void insertarInicio(int dato) {
        Node newNode = new Node(dato);

        if (head == null) {
            head = newNode;
        } else {

            newNode.siguiente = head;
            head = newNode;

        }
        size++;
    }

    public void eliminar(int dato) {
        if (head == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return;
        }

        // El nodo a eliminar es el primero
        if (head.dato == dato) {
            head = head.siguiente;
            size--;
            return;
        }

        // Recorrer para encontrar el nodo
        Node actual = head;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }

        // Si lo encontró, lo elimina
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            size--;
        } else {
            System.out.println("El valor " + dato + " no se encontró en la lista.");
        }
    }

    public boolean buscar(int valor) {
        Node actual = head;

        while (actual != null) {
            if (actual.dato == valor) {
                return true; // está en la lista
            }
            actual = actual.siguiente;
        }

        return false; // no está en la lista
    }

    public int contar() {
        return size;
    }

    public void invertir() {
        Node prev = null;
        Node actual = head;
        Node next = null;

        while (actual != null) {
            next = actual.siguiente; // Guardamos el siguiente
            actual.siguiente = prev; // Invertimos el enlace
            prev = actual; // Avanzamos prev
            actual = next; // Avanzamos actual
        }

        head = prev;
    }

    public void imprimirLista() {
        Node actual = head;

        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
