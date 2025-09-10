package Ejercicio5;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarFinal(5);
        lista.insertarFinal(15);
        lista.insertarFinal(25);
        lista.insertarFinal(35);

        if(lista.buscar(25)){
            System.out.println("El valor 25 se encontró en la lista.");
        }else{
            System.out.println("El valor 25 no se encontró en la lista.");
        }

        if(lista.buscar(100)){
            System.out.println("El valor 100 se encontró en la lista.");
        }else{
            System.out.println("El valor 100 no se encontró en la lista.");
        }

        lista.imprimirLista();
    }
}