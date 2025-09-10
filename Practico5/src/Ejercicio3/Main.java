package Ejercicio3;

import java.util.Scanner;
import structs.Util;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("=== Creación de una lista con 3 nodos ===");

        // Pedir al usuario 3 números enteros
        for (int i = 1; i <= 3; i++) {
            int valor = Util.leerEntero(sc, "Ingrese el valor del nodo " + i + ": ");
            lista.insertarFinal(valor);
        }

        System.out.println("\nLista enlazada resultante:");
        lista.imprimirLista();

        sc.close();
    }
}