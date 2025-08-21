package Practico2.src;

import java.util.Scanner;

public class Ejercicio5 { //Conversión Binaria
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int acumulador = 0;

        System.out.println("Ingrese el numero entero positivo a convertir: ");
        int numero = consola.nextInt();
        int numeroBinario = convertirBinario(numero, acumulador);
        System.out.println("\nEl numero entero positivo " + numero + " en Binario es: " + numeroBinario);
    }

    public static int convertirBinario(int numero, int acumulador){
        if (numero == 0) {
            return 0;
        } else {
            return convertirBinario(numero / 2, acumulador) * 10 + (numero % 2);
        }
    }
}