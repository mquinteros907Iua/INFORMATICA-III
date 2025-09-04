package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        ColaArreglo cola = new ColaArreglo();

        //Carga de clientes
        cola.enqueue("Ana");
        cola.enqueue("Luis");
        cola.enqueue("Marta");
        cola.enqueue("Pedro");

        //Se atienden los dos primeros clientes
        cola.mostrarCola();
        System.out.println("\nSe atienden dos clientes:");
        cola.dequeue();
        cola.dequeue();
        cola.mostrarCola();

    }
}
