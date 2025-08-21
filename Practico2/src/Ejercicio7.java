package Practico2.src;

public class Ejercicio7 {   //Números de Fibonacci Optimizados
    public static void main(String[] args) {    
        int numero = 0;
        System.out.println("Serie de Fibonacci: " + serieFibonacci(numero));
    }

    static int serieFibonacci(int numero){
        if(numero == 0){
            return 0;
        } else if (numero == 1) {
            return 1; 
        } else {
            return serieFibonacci(numero-1) + serieFibonacci(numero-2);
        }
    }
}
