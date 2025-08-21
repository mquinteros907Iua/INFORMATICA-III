package Practico2.src;

import java.util.Scanner;

public class Ejercicio1{ //Conteo de dígitos de un número entero
    public void main(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese un número entero:");
        String numero = consola.nextLine();
        
        int contador = 0;

       int resultado = conteoDigitosRecursivo(contador, numero);
       System.out.println("La cantidad de dígitos que tiene " + numero + " es :" + resultado);
    }

    int conteoDigitosRecursivo(int contador, String numero){
        if(numero.length() == 0){
            return contador;
        }else{
            contador++;
            numero = numero.substring(1); // Elimina el primer carácter del número
            return conteoDigitosRecursivo(contador, numero);
        }
    }
}