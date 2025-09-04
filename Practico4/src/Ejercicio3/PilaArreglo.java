package Ejercicio3;

public class PilaArreglo {
    private char[] elementos = new char[10];
    private int top = -1;

    public void push(char dato) {
        if (top < elementos.length - 1) {
            top++;
            elementos[top] = dato;
        } else {
            System.out.println("Pila llena");
        }
    }

    // Desapilar
    public char pop() {
        if (!isEmpty()) {
            return elementos[top--];
        } else {
            System.out.println("Pila Vacia");
            return ' ';
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
