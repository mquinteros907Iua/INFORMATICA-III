package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();

        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);

        //Desapilando dos
        System.out.println("\nDesapilando dos elementos");
        pila.pop();
        pila.pop();
    }
}
