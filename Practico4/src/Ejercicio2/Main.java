package Ejercicio2;

public class Main { 
    public static void main(String[] args) {
        Cola cola = new Cola();

        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);

        //Desencolando uno
        cola.dequeue();
    }
}
