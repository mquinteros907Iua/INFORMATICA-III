package Ejercicio6;

public class Pila {
    private String[] elementos = new String[20];
    private int top = -1;

    public void push(String accion) {
        if (!isFull()) {
            top++;
            elementos[top] = accion;
        }
    }

    public String pop() {
        if (!isEmpty()) {
            top--;
            return elementos[top];
        }
        return null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elementos.length - 1;
    }

    public void mostrar(String nombre) {
        System.out.println("Contenido de la pila " + nombre + ":");
        for (int i = top; i >= 0; i--) {
            System.out.println("  " + elementos[i]);
        }
        if (isEmpty()) {
            System.out.println("  (vacía)");
        }
        System.out.println();
    }
}
