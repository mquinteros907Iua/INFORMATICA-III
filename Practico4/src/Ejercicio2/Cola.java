package Ejercicio2;

public class Cola {
    private int front = -1;
    private int back = -1; 
    private int[] cola = new int[10];

    public void enqueue(int dato){
        if(!isFull()){
            if(front == -1)
                front = 0;
            back++;
            cola[back] = dato;
            mostrarCola();
        }else{
            System.out.println("Cola Llena");
        }

    }

    public void dequeue(){
        if(!isEmpty()){
            System.out.println("\nDesencolando el valor: " + cola[back]);
            back--;
            mostrarCola();
            if(back ==-1)
                front = -1;
        }else{
            System.out.println("Cola Vacia");
        }
    }

    public boolean isFull(){
        if(back == 10){
            return true;
        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        if (front == -1) {
            return true;
        }else{
            return false;
        }
    }

    public void top(){
        System.out.println("Front: " + front);
        System.out.println("Back: " + back);
    }

    public void mostrarCola(){
        System.out.println("\nContenido de la cola:");
        for(int i = 0; i <= back; i++){
            System.out.println(cola[i] + " ");
        }
    }
}
