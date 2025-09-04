package Ejercicio6;

public class Main {

     public static void main(String[] args) {
        Pila deshacer = new Pila();
        Pila rehacer = new Pila();

        // Simular 5 acciones del usuario
        deshacer.push("Hola Mundo");
        deshacer.push("Informatica III");
        deshacer.push("Realizado por Marcos");
        deshacer.push("En Java");
        deshacer.push("Ejercicio de pilas");

        System.out.println("Estado inicial:");
        deshacer.mostrarPila("Deshacer");
        rehacer.mostrarPila("Rehacer");

        // Deshacer 2 acciones
        System.out.println("\n--- Deshacer 2 acciones ---");
        String accion1 = deshacer.pop();
        if (accion1 != null) 
            rehacer.push(accion1);

        String accion2 = deshacer.pop();
        if (accion2 != null) 
            rehacer.push(accion2);

        deshacer.mostrarPila("Deshacer");
        rehacer.mostrarPila("Rehacer");

        // Rehacer 1 acción
        System.out.println("\n--- Rehacer 1 acción ---");
        String accion3 = rehacer.pop();
        if (accion3 != null) 
            deshacer.push(accion3);

        deshacer.mostrarPila("Deshacer");
        rehacer.mostrarPila("Rehacer");
    }
}

