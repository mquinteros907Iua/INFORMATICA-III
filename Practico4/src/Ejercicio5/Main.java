package Ejercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        Cola cola = new Cola();
        Pila pila = new Pila();

        System.out.println("Ingrese una palabra: ");
        String palabra = consola.nextLine();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            cola.enqueue(letra);
            pila.push(letra);
        }

        boolean esPalindromo = true;
        for (int i = 0; i < palabra.length(); i++) {
            if (cola.dequeue() != pila.pop()) {
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo) {
            System.out.println("La palabra \"" + palabra + "\" es un palíndromo.");
        } else {
            System.out.println("La palabra \"" + palabra + "\" no es un palíndromo.");
        }

        consola.close();
    }
}
