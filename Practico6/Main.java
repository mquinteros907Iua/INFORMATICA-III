package Practico6;

import Practico6.structs.AVLTree;

/**
 * Clase de ejemplo para demostrar el uso del Árbol AVL.
 * Muestra todas las operaciones disponibles y sus resultados.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE ÁRBOL AVL ===\n");
        
        // Crear un árbol AVL de enteros
        AVLTree<Integer> arbol = new AVLTree<>();
        
        // 1. INSERCIÓN DE ELEMENTOS
        System.out.println("1. INSERTANDO ELEMENTOS:");
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35};
        
        for (int valor : valores) {
            boolean insertado = arbol.insertar(valor);
            System.out.println("   Insertando " + valor + ": " + (insertado ? "✓ Éxito" : "✗ Ya existe"));
        }
        
        System.out.println("\n   Tamaño del árbol: " + arbol.obtenerTamanio());
        System.out.println("   Altura del árbol: " + arbol.obtenerAlturaArbol());
        System.out.println("   ¿Está balanceado?: " + (arbol.estaBalanceado() ? "Sí ✓" : "No ✗"));
        
        // 2. VISUALIZACIÓN DEL ÁRBOL
        System.out.println("\n2. ESTRUCTURA DEL ÁRBOL:");
        arbol.imprimirArbol();
        
        // 3. RECORRIDOS
        System.out.println("\n3. RECORRIDOS DEL ÁRBOL:");
        System.out.println("   Inorden (ascendente):  " + arbol.recorridoInorden());
        System.out.println("   Preorden:              " + arbol.recorridoPreorden());
        System.out.println("   Postorden:             " + arbol.recorridoPostorden());
        
        // 4. BÚSQUEDA
        System.out.println("\n4. BÚSQUEDA DE ELEMENTOS:");
        int[] busquedas = {40, 55, 80, 100};
        for (int valor : busquedas) {
            boolean encontrado = arbol.buscar(valor);
            System.out.println("   ¿Existe " + valor + "? " + (encontrado ? "Sí ✓" : "No ✗"));
        }
        
        // 5. VALORES MÍNIMO Y MÁXIMO
        System.out.println("\n5. VALORES EXTREMOS:");
        System.out.println("   Valor mínimo: " + arbol.encontrarValorMinimo());
        System.out.println("   Valor máximo: " + arbol.encontrarValorMaximo());
        
        // 6. ELIMINACIÓN
        System.out.println("\n6. ELIMINANDO ELEMENTOS:");
        int[] eliminaciones = {20, 30, 50};
        
        for (int valor : eliminaciones) {
            boolean eliminado = arbol.eliminar(valor);
            System.out.println("   Eliminando " + valor + ": " + (eliminado ? "✓ Éxito" : "✗ No encontrado"));
            System.out.println("   Tamaño actual: " + arbol.obtenerTamanio() + 
                             " | Altura: " + arbol.obtenerAlturaArbol() + 
                             " | Balanceado: " + (arbol.estaBalanceado() ? "Sí" : "No"));
        }
        
        System.out.println("\n   Árbol después de eliminaciones:");
        arbol.imprimirArbol();
        
        System.out.println("\n   Recorrido inorden: " + arbol.recorridoInorden());
        
        // 7. PRUEBA CON STRINGS
        System.out.println("\n7. ÁRBOL AVL CON STRINGS:");
        AVLTree<String> arbolNombres = new AVLTree<>();
        
        String[] nombres = {"Maria", "Juan", "Pedro", "Ana", "Luis", "Sofia", "Carlos"};
        for (String nombre : nombres) {
            arbolNombres.insertar(nombre);
        }
        
        System.out.println("   Nombres insertados: " + arbolNombres.obtenerTamanio());
        System.out.println("   Orden alfabético: " + arbolNombres.recorridoInorden());
        System.out.println("   Estructura:");
        arbolNombres.imprimirArbol();
        
        // 8. LIMPIEZA
        System.out.println("\n8. LIMPIANDO EL ÁRBOL:");
        arbol.limpiar();
        System.out.println("   ¿Está vacío?: " + (arbol.estaVacio() ? "Sí ✓" : "No ✗"));
        System.out.println("   Tamaño: " + arbol.obtenerTamanio());
        
        // 9. toString()
        System.out.println("\n9. REPRESENTACIÓN toString():");
        AVLTree<Integer> arbolPequeno = new AVLTree<>();
        arbolPequeno.insertar(5);
        arbolPequeno.insertar(3);
        arbolPequeno.insertar(7);
        arbolPequeno.insertar(1);
        arbolPequeno.insertar(9);
        System.out.println("   Árbol: " + arbolPequeno);
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}
