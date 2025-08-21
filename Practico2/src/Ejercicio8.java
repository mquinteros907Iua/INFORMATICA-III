package Practico2.src;

import java.util.Scanner;

public class Ejercicio8 {   //Buscar en un Arreglo
    public static void main(String[] args) {    
        Scanner consola = new Scanner(System.in);
        int indice = 0;

        System.out.println("Ingrese cantidad de elementos a ingresar: ");
        int cantidadElementos = consola.nextInt();

        // Definir el arreglo de enteros
        int[] arregloElementos = new int[cantidadElementos];

        for (int i = 0; i < cantidadElementos; i++) {
            System.out.println("Ingrese numero entero: ");
            int numero = consola.nextInt();
            arregloElementos[i] = numero; 
        }

        System.out.println("Ingrese numero entero a buscar: ");
        int numeroBuscar = consola.nextInt();

        boolean bandera = buscadorArreglo(arregloElementos,numeroBuscar,indice);

        if(bandera){
            System.out.println("El numero " + numeroBuscar + " se encuentra en el arreglo");
        }else{
            System.out.println("El numero " + numeroBuscar + " no se encuentra en el arreglo" );
        }
    }

    static boolean buscadorArreglo(int [] arregloElementos,int numeroBuscar, int indice){
        if(indice >= arregloElementos.length){
            return false;
        }else if(numeroBuscar == arregloElementos[indice]){
            return true;
        }else{
            return buscadorArreglo(arregloElementos, numeroBuscar, indice+1);
        }
    }
}
