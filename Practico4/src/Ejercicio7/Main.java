package Ejercicio7;

public class Main {
    public static void main(String[] args) {
        Cola colaDocumentos = new Cola();

        //Llegada de documentos
        colaDocumentos.enqueue("Doc1");
        colaDocumentos.enqueue("Doc2");
        colaDocumentos.enqueue("Doc3");
        colaDocumentos.enqueue("Doc4");
        colaDocumentos.enqueue("Doc5");

        //Impresion de 3 documentos
        colaDocumentos.mostrarCola(3);
    }
}
