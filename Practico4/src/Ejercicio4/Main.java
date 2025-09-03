package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        ColaArreglo cola = new ColaArreglo();

        //Carga de clientes
        cola.push("Ana");
        cola.push("Luis");
        cola.push("Marta");
        cola.push("Pedro");

        //Se atienden los dos primeros clientes
        cola.mostrarCola();
        System.out.println("\nSe atienden dos clientes:");
        cola.pop();
        cola.pop();
        cola.mostrarCola();

    }
}
