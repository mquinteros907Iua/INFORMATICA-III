package Ejercicio6;

import java.util.Scanner;

public class Main {

    private enum Tipo { ESCRIBIR, BORRAR }

    private static class Accion {
        final Tipo tipo;
        final String palabra;
        Accion(Tipo tipo, String palabra) {
            this.tipo = tipo;
            this.palabra = palabra;
        }
        public String toString() {
            return tipo + "(" + palabra + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Ingreso de oración
        System.out.print("Ingrese una oración: ");
        String oracion = sc.nextLine().trim();
        String[] palabras = oracion.isEmpty() ? new String[0] : oracion.split("\\s+");

        // Pilas con capacidad suficiente
        Pila<String> pilaPalabras = new Pila<>(palabras.length);
        Pila<Accion> deshacer = new Pila<>(100);
        Pila<Accion> rehacer = new Pila<>(100);
        //
        // Cargar palabras en orden inverso para que la primera quede arriba
        for (int i = palabras.length - 1; i >= 0; i--) {
            pilaPalabras.push(palabras[i]);
        }

        // Documento representado como array (máx. = cant. palabras ingresadas * 2)
        String[] documento = new String[palabras.length * 2];
        int docSize = 0;

        // Menú interactivo
        while (true) {
            imprimirEstado(documento, docSize, pilaPalabras, deshacer, rehacer);

            System.out.println("\nElija una opción:");
            System.out.println("1) Escribir palabra");
            System.out.println("2) Borrar última palabra");
            System.out.println("3) Deshacer");
            System.out.println("4) Rehacer");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            String op = sc.nextLine().trim();
            switch (op) {
                case "1": // Escribir
                    if (pilaPalabras.estaVacia()) {
                        System.out.println("No hay más palabras para escribir.");
                        break;
                    }
                    String palabra = pilaPalabras.pop();
                    documento[docSize++] = palabra;
                    deshacer.push(new Accion(Tipo.ESCRIBIR, palabra));
                    rehacer.clear();
                    break;

                case "2": // Borrar
                    if (docSize == 0) {
                        System.out.println("Documento vacío.");
                        break;
                    }
                    String ultima = documento[--docSize];
                    deshacer.push(new Accion(Tipo.BORRAR, ultima));
                    rehacer.clear();
                    break;

                case "3": // Deshacer
                    if (deshacer.estaVacia()) {
                        System.out.println("Nada para deshacer.");
                        break;
                    }
                    Accion a = deshacer.pop();
                    if (a.tipo == Tipo.ESCRIBIR) {
                        documento[--docSize] = null;
                        pilaPalabras.push(a.palabra);
                    } else { // BORRAR
                        documento[docSize++] = a.palabra;
                    }
                    rehacer.push(a);
                    break;

                case "4": // Rehacer
                    if (rehacer.estaVacia()) {
                        System.out.println("Nada para rehacer.");
                        break;
                    }
                    Accion r = rehacer.pop();
                    if (r.tipo == Tipo.ESCRIBIR) {
                        if (!pilaPalabras.estaVacia() && pilaPalabras.peek().equals(r.palabra)) {
                            pilaPalabras.pop();
                        }
                        documento[docSize++] = r.palabra;
                    } else {
                        documento[--docSize] = null;
                    }
                    deshacer.push(r);
                    break;

                case "0":
                    System.out.println("Fin del programa.");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void imprimirEstado(String[] documento, int docSize,
                                       Pila<String> pilaPalabras,
                                       Pila<Accion> deshacer,
                                       Pila<Accion> rehacer) {
        System.out.println("\n===== ESTADO =====");
        System.out.print("Documento: ");
        for (int i = 0; i < docSize; i++) {
            System.out.print(documento[i] + " ");
        }
        System.out.println();
        System.out.println("Pila Palabras: " + pilaPalabras);
        System.out.println("Deshacer: " + deshacer);
        System.out.println("Rehacer: " + rehacer);
        System.out.println("==================");
    }
}

