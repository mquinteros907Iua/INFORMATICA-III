package Ejercicio6;

public class Pila<T> {
    private Object[] datos;
    private int tope;

    // Constructor
    public Pila(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        datos = new Object[capacidad];
        tope = -1;
    }

    // Excepción personalizada para pila llena
    public static class PilaLlenaException extends RuntimeException {
        public PilaLlenaException(String msg) {
            super(msg);
        }
    }

    // Push = apilar
    public void push(T elem) {
        if (tope == datos.length - 1) {
            throw new PilaLlenaException("La pila está llena. No se puede apilar: " + elem);
        }
        datos[++tope] = elem;
    }

    // Pop = desapilar
    @SuppressWarnings("unchecked")
    public T pop() {
        if (estaVacia()) {
            throw new java.util.EmptyStackException();
        }
        return (T) datos[tope--];
    }

    // Peek = cima
    @SuppressWarnings("unchecked")
    public T peek() {
        if (estaVacia()) {
            throw new java.util.EmptyStackException();
        }
        return (T) datos[tope];
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public int size() {
        return tope + 1;
    }

    public void clear() {
        tope = -1;
    }

    @Override
    public String toString() {
        if (estaVacia()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= tope; i++) {
            sb.append(datos[i]);
            if (i < tope) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
