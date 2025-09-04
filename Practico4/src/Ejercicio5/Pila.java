package Ejercicio5;

public class Pila {
    char pila[] = new char[100];
    private int top = -1;

    public void push(char letra) {
        if (!isFull()) {
            top++;
            pila[top] = letra;
        } else {
            System.out.println("Pila llena");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return pila[top--];
        } else {
            System.out.println("Pila vacía");
            return ' ';
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == pila.length - 1;
    }

    public void mostrarPila() {
        System.out.println("Contenido de la pila:");
        if (!isEmpty()) {
            for (int i = 0; i <= top; i++) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Pila vacía");
        }
    }

}
