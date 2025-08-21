package Practico2.src;

import java.util.Scanner;

public class Ejercicio6 {   //Palíndromo
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese una palabra: ");
        String palabra = consola.nextLine();

        boolean bandera = verificacionPalidromo(palabra);
        if(bandera){
            System.out.println("La palabra " + palabra + " es Palindromo");
        }else{
            System.out.println("La palabra " + palabra + " no es Palindromo");
        }
        
    }

    static boolean verificacionPalidromo(String palabra){
        if (palabra.length() <= 1) {
            return true;
        }

        if (palabra.charAt(0) != palabra.charAt(palabra.length() - 1)) {
            return false;
        }

        return verificacionPalidromo(palabra.substring(1, palabra.length() - 1));
    }

}
