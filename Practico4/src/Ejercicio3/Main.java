package Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilaArreglo pilaArreglo = new PilaArreglo();
        Scanner consola = new Scanner(System.in);

        System.out.println("Ingrese una palabra a invertir (Hasta 10 caracteres): ");
        String palabra = consola.nextLine();

        //Apilar cada caracter
        for(int i=0; i < palabra.length(); i++){
            pilaArreglo.push(palabra.charAt(i));
        }

        // Desapilar para invertir
        String invertida = "";
        while (!pilaArreglo.isEmpty()) {
            invertida += pilaArreglo.pop();
        }

        System.out.println("Palabra invertida: " + invertida);
        consola.close();
    }
}
