package structs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    public static int leerEntero(Scanner sc, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                sc.nextLine(); // descartar entrada inválida
            }
        }
    }
}