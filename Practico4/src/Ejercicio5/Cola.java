package Ejercicio5;

public class Cola {

    char cola[] = new char[100];

    private int front = -1;
    private int back = -1;

    public void enqueue(char letra) {
        if (!isFull()) {
            if (front == -1) {
                front = 0;
            }
            back++;
            cola[back] = letra;
        }
    }

     public char dequeue() {
        if (!isEmpty()) {
            char letra = cola[front];
            if (front == back) { 
                front = back = -1;
            } else {
                front++;
            }
            return letra;
        } else {
            System.out.println("Cola Vacia");
            return ' ';
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return back == cola.length - 1;
    }

    public void mostrarCola() {
        System.out.println("Contenido de la cola:");
        if (!isEmpty()) {
            for (int i = front; i <= back; i++) {
                System.out.print(cola[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Cola vacía");
        }
    }

}
