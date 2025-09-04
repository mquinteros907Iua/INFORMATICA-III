package Ejercicio6;

class Pila {
    String pila[] = new String[100];
    private int top = -1;

    public void push(String texto) {
        if (!isFull()) {
            top++;
            pila[top] = texto;
        } else {
            System.out.println("Pila llena");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return pila[top--];
        } else {
            System.out.println("Pila vacía");
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == pila.length - 1;
    }

    public void mostrarPila(String nombre) {
        System.out.println("Contenido de la pila " + nombre + ":");
        if (!isEmpty()) {
            for (int i = 0; i <= top; i++) {
                System.out.println(" - " + pila[i]);
            }
        } else {
            System.out.println("(vacía)");
        }
    }
}