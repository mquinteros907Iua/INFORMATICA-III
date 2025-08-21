package Practico2.src;

import java.util.Scanner;

public class Ejercicio4 { //Máximo Común Divisor (MCD)
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int acumulador = 0;

        System.out.println("Ingrese el primer numero a calcular el MCD");
        int primerNumero = consola.nextInt();
        System.out.println("Ingrese el segundo numero a calcular el MCD");
        int segundoNumero = consola.nextInt();
        
        int resultado = mcd(primerNumero,segundoNumero,acumulador);
        System.out.println("MCD(" + primerNumero + "," + segundoNumero + ") = " + resultado);
    }

    static int mcd(int primerNumero, int segundoNumero,int acumulador){
        if(segundoNumero == 0){
            return primerNumero;
        }else{
            acumulador = primerNumero % segundoNumero;
            return mcd(segundoNumero, acumulador, acumulador);
        }
    }
}
