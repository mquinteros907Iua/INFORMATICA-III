package Ejercicio8;

public class ColaCircular {
    String[] cola = new String[5];
    int front = -1;
    int back = -1;
    int retorno = -1;

    public void enqueue(String nombre) {
        if (front == -1)
            front = 0;

        if (!isFull()) {
             back = (back + 1) % cola.length;
            cola[back] = nombre;
        } else {
            cola[retorno] = nombre;
            front = (front + 1) % cola.length;
            back = (back + 1) % cola.length;
        }
    }

    public boolean isFull() {
        if ((back + 1) % cola.length == front) {
            retorno = front; 
            return true;
        }
        return false;
    }

    public void mostrarCola() {
          System.out.println("Contenido de la cola:");
        if (front == -1) {
            System.out.println("Cola vacía");
            return;
        }

        int i = front;
        while (true) {
            System.out.println(cola[i]);
            if (i == back) 
                break;
            i = (i + 1) % cola.length;
        }
    }
}
