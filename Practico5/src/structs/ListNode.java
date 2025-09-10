package structs;

public class ListNode<T>{
    Node<T> head; // primer nodo
    int size;     // cantidad de nodos

    public ListNode() {
        this.head = null;
        this.size = 0;
    }

    public void insertarFinal(T dato) {
        Node<T> newNode = new Node<>(dato);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = newNode;
        }
        size++;
    }

    public void insertarInicio(T dato) {
        Node<T> newNode = new Node<>(dato);

        newNode.siguiente = head;
        head = newNode;
        size++;
    }

    public void insertarEn(int posicion, T valor) {
        Node<T> actual = head;
        int contadorPosiciones = 0;

        if (posicion < 0 || posicion > size) {
            System.out.println("Posición inválida.");
            return;
        }

        if (posicion == 0) {
            insertarInicio(valor);
            return;
        }

        while (actual != null) {
            if (contadorPosiciones == posicion - 1) {
                Node<T> newNode = new Node<>(valor);
                newNode.siguiente = actual.siguiente;
                actual.siguiente = newNode;
                size++;
                break;
            }
            actual = actual.siguiente;
            contadorPosiciones++;
        }
    }

    public void eliminar(T dato) {
        if (head == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return;
        }

        if (head.dato.equals(dato)) {
            head = head.siguiente;
            size--;
            return;
        }

        Node<T> actual = head;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            size--;
        } else {
            System.out.println("El valor " + dato + " no se encontró en la lista.");
        }
    }

    public boolean buscar(T valor) {
        Node<T> actual = head;

        while (actual != null) {
            if (actual.dato.equals(valor)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public int contar() {
        return size;
    }

    public void invertir() {
        Node<T> prev = null;
        Node<T> actual = head;
        Node<T> next = null;

        while (actual != null) {
            next = actual.siguiente;
            actual.siguiente = prev;
            prev = actual;
            actual = next;
        }
        head = prev;
    }

    public void eliminarDuplicados() {
        Node<T> actual = head;

        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        while (actual != null) {
            Node<T> anterior = actual;
            Node<T> auxiliar = actual.siguiente;

            while (auxiliar != null) {
                if (auxiliar.dato.equals(actual.dato)) {
                    anterior.siguiente = auxiliar.siguiente;
                    auxiliar = auxiliar.siguiente;
                    size--;
                } else {
                    anterior = auxiliar;
                    auxiliar = auxiliar.siguiente;
                }
            }
            actual = actual.siguiente;
        }
    }

    public void imprimirLista() {
        Node<T> actual = head;

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