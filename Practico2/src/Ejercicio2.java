package Practico2.src;

import java.util.Scanner;

public class Ejercicio2 { // Inversión de una cadena de caracteres
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese una cadena de caracteres:");
        String caracteres = consola.nextLine();
        String cadenaAuxiliar;
        cadenaAuxiliar = invertirCadenaRecursivo(caracteres);
        System.out.println("La cadena invertida es: " + cadenaAuxiliar);
    }

    static String invertirCadenaRecursivo(String cadena) {
        if (cadena.isEmpty()) {
            return cadena; // Caso base: si la cadena está vacía, retorna la cadena vacía
        } else {
            return invertirCadenaRecursivo(cadena.substring(1)) + cadena.charAt(0);
        }
    }
}
