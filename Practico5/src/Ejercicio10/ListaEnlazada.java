package Ejercicio10;

class ListaEnlazada {
    Node<String> head; 
    int size; 

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    public void insertarInicio(String nombre, int legajo) {
        Node<String> nuevoNodo = new Node<>(nombre, legajo);
        if (head == null) {
            head = nuevoNodo;
        } else {
            nuevoNodo.siguiente = head;
            head = nuevoNodo;
        }
        size++;
    }

    public void agregarAlumno(String nombre, int legajo) {
        insertarInicio(nombre, legajo);
    }

    public Node<String> buscarAlumno(int legajo) {
        Node<String> actual = head;
        while (actual != null) {
            if (actual.legajo == legajo) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean eliminarAlumno(int legajo) {
        if (head == null) 
            return false;

        if (head.legajo == legajo) {
            head = head.siguiente;
            size--;
            return true;
        }

        Node<String> actual = head;
        while (actual.siguiente != null && actual.siguiente.legajo != legajo) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            size--;
            return true;
        }

        return false;
    }

    public void mostrarAlumnos() {
        Node<String> actual = head;
        while (actual != null) {
            System.out.println("Nombre: " + actual.nombre + " | Legajo: " + actual.legajo);
            actual = actual.siguiente;
        }
    }
}
