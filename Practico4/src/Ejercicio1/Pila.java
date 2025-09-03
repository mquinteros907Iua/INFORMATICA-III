package Ejercicio1;

public class Pila {
    private int top = -1;
    private int[] pila = new int[10];

    public void push(int dato){
        if(top != 10){
            top++;
            pila[top] = dato;
            mostrarPila();
        }else{
            System.out.println("La pila se encuentra llena");
        }
    }

    public void pop(){
        if(top == -1){
            System.out.println("La pila se encuentra vacia");
        }else{
            top--;
            mostrarPila();
        }
    }

    public void top(){
        System.out.println("Top contiene el valor: " + top + ", que corresponde al valor: " + pila[top]);
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(top == 10){
            System.out.println("Pila llena");
            return true;
        }else{
            return false;
        }
    }

    public void mostrarPila(){
        System.out.println("\nContenido de la Pila: ");
        for(int i = 0; i < top;i++){
            System.out.println(pila[i]+"  ");
        }
    }
}
