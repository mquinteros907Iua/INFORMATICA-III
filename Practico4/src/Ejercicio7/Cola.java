package Ejercicio7;

public class Cola {
    String [] cola = new String[100];
    int front = -1;
    int back = -1;

    public void enqueue(String documento){
        if(!isFull()){
            if(front == -1){
                front++;
            }
            back++;
            cola[back] = documento;
        }
    }

    public void dequeue(){
        if(!isEmpty()){
            if(back == 0){
                front--;
            }
            back--;
        }else{
            System.out.println("Cola Vacia");
        }
    }

    public boolean isEmpty(){
        if(front == -1){
            System.out.println("Cola Vacia");
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(back == cola.length-1){
            System.out.println("Cola Llena");
            return true;
        }else{
            return false;
        }
    }

    public void mostrarCola(int topeMuestra){
        System.out.println("Contenido de la cola:");
        for(int i=0; i < topeMuestra; i++){
            System.out.println(cola[i] + " ");
        }
    }
}
