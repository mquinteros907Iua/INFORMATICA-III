package Practico2.src;

import java.util.Scanner;

public class Ejercicio3 { //Suma de elementos de un arreglo
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int sumador=0,contador=0;

        System.out.println("Ingrese cantidad de elementos a ingresar: ");
        int cantidadElementos = consola.nextInt();

        // Definir el arreglo de enteros
        int[] arregloElementos = new int[cantidadElementos];

        for (int i = 0; i < cantidadElementos; i++) {
            System.out.println("Ingrese numero entero: ");
            int numero = consola.nextInt();
            arregloElementos[i] = numero; // así se asigna cada número al arreglo
        }

        int resultado = sumarElementosArreglo(arregloElementos, sumador,contador);
        System.out.println("\nLa suma de todos los elementos del arreglo es: " + resultado);
        resultado = resultado / cantidadElementos;
        System.out.println("El promedio del arreglo es: " + resultado);
    }

    public static int sumarElementosArreglo(int [] arreglo,int sumador, int contador){
        if(arreglo.length == contador){
            return sumador;
        }else{
            sumador = arreglo[contador] + sumador;
            contador++;
            return sumarElementosArreglo(arreglo, sumador, contador);
        }
    }
}