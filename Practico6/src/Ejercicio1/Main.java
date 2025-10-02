package Practico6.src.Ejercicio1;

import Practico6.structs.AVLTree;
import java.util.Scanner;

/**
 * EJERCICIO 1 - Insertiones y FE paso a paso (caso LL y RR)
 * 
 * Inserte en un AVL la secuencia:30, 20, 10, 40, 50, 60.
 * a) Dibuje el árbol tras cada inserción.
 * b) Calcule alturas y factor de equilibrio (FE) de cada nodo en cada paso.
 * c) Indique qué rotación se aplica en cada desbalance (LL o RR) y por qué.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AVLTree<Integer> arbol = new AVLTree<>();
    private static int[] secuencia = {30, 20, 10, 40, 50, 60};
    private static int pasoActual = 0;

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: INSERTIONES Y FACTOR DE EQUILIBRIO ===");
        System.out.println("Secuencia a insertar: 30, 20, 10, 40, 50, 60");
        System.out.println("a) Dibuje el árbol tras cada inserción.");
        System.out.println("b) Calcule alturas y factor de equilibrio (FE) de cada nodo.");
        System.out.println("c) Indique qué rotación se aplica (LL o RR) y por qué.\n");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            continuar = procesarOpcion(opcion);
        }

        System.out.println("\n¡Ejercicio completado!");
        scanner.close();
    }

    /**
     * Muestra el menú del Ejercicio 1 - Simplificado según enunciado
     */
    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("EJERCICIO 1 - INSERTIONES PASO A PASO");
        System.out.println("Secuencia: 30, 20, 10, 40, 50, 60");
        System.out.println("Paso actual: " + pasoActual + "/6");
        if (pasoActual < secuencia.length) {
            System.out.println("Próximo: " + secuencia[pasoActual]);
        } else {
            System.out.println("✅ Secuencia completa");
        }
        System.out.println("=".repeat(50));
        
        System.out.println("1. Insertar siguiente elemento y dibujar árbol");
        System.out.println("2. Mostrar alturas y factores de equilibrio (FE)");
        System.out.println("3. Analizar rotaciones aplicadas (LL/RR)");
        System.out.println("4. Reiniciar secuencia");
        System.out.println("0. Salir");
        System.out.println("=".repeat(50));
        System.out.print("Opción: ");
    }

    /**
     * Lee una opción del usuario con validación
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }

    /**
     * Procesa la opción seleccionada por el usuario
     */
    private static boolean procesarOpcion(int opcion) {
        System.out.println();
        
        switch (opcion) {
            case 1:
                insertarYDibujar();
                break;
            case 2:
                mostrarAlturasYFactores();
                break;
            case 3:
                analizarRotaciones();
                break;
            case 4:
                reiniciarSecuencia();
                break;
            case 0:
                return false;
            default:
                System.out.println("❌ Opción inválida. Selecciona 0-4.");
        }
        
        esperarEnter();
        return true;
    }

    /**
     * a) Inserta el siguiente elemento y dibuja el árbol tras la inserción
     */
    private static void insertarYDibujar() {
        if (pasoActual >= secuencia.length) {
            System.out.println("⚠️  La secuencia ya está completa.");
            return;
        }

        int elemento = secuencia[pasoActual];
        System.out.println("PASO " + (pasoActual + 1) + ": Insertando " + elemento);
        
        // Insertar el elemento
        arbol.insertar(elemento);
        pasoActual++;
        
        // a) Dibujar el árbol tras la inserción
        System.out.println("\n🌳 ÁRBOL TRAS INSERCIÓN DE " + elemento + ":");
        arbol.imprimirArbol();
        
        System.out.println("\nTamaño: " + arbol.obtenerTamanio() + " | Altura: " + arbol.obtenerAlturaArbol());
    }

    /**
     * b) Calcula alturas y factor de equilibrio (FE) de cada nodo
     */
    private static void mostrarAlturasYFactores() {
        if (arbol.estaVacio()) {
            System.out.println("⚠️  El árbol está vacío.");
            return;
        }

        System.out.println("📊 ALTURAS Y FACTORES DE EQUILIBRIO:");
        System.out.println("FE = altura(izq) - altura(der)");
        System.out.println("Valores válidos AVL: {-1, 0, 1}\n");
        
        // Mostrar estructura con alturas
        arbol.imprimirArbol();
        
        System.out.println("\n✅ Árbol balanceado: " + (arbol.estaBalanceado() ? "SÍ" : "NO"));
        System.out.println("📏 Altura total: " + arbol.obtenerAlturaArbol());
    }

    /**
     * c) Indica qué rotación se aplica en cada desbalance (LL o RR) y por qué
     */
    private static void analizarRotaciones() {
        System.out.println("🔄 ANÁLISIS DE ROTACIONES EN LA SECUENCIA:");
        System.out.println("Secuencia: 30, 20, 10, 40, 50, 60\n");
        
        System.out.println("📝 ROTACIONES IDENTIFICADAS:");
        
        System.out.println("\n1️⃣  PASO 3 - Inserción del 10:");
        System.out.println("   Secuencia problemática: 30 → 20 → 10");
        System.out.println("   Tipo: DESBALANCE LL (Left-Left)");
        System.out.println("   ¿Por qué? Los nodos forman una cadena hacia la IZQUIERDA");
        System.out.println("   Solución: ROTACIÓN DERECHA en el nodo 30");
        System.out.println("   Resultado: 20 se convierte en la nueva raíz");
        
        System.out.println("\n2️⃣  PASO 6 - Inserción del 60:");
        System.out.println("   Secuencia problemática: 40 → 50 → 60");
        System.out.println("   Tipo: DESBALANCE RR (Right-Right)");
        System.out.println("   ¿Por qué? Los nodos forman una cadena hacia la DERECHA");
        System.out.println("   Solución: ROTACIÓN IZQUIERDA en el nodo 40");
        System.out.println("   Resultado: 50 se convierte en la nueva raíz del subárbol");
        
        System.out.println("\n🎯 ESTADO ACTUAL:");
        if (pasoActual >= 3) {
            System.out.println("   ✅ Rotación LL aplicada (paso 3)");
        }
        if (pasoActual >= 6) {
            System.out.println("   ✅ Rotación RR aplicada (paso 6)");
        }
        if (pasoActual < 3) {
            System.out.println("   ⏳ Rotación LL pendiente (paso 3)");
        }
        if (pasoActual < 6) {
            System.out.println("   ⏳ Rotación RR pendiente (paso 6)");
        }
    }

    /**
     * Reinicia la secuencia de inserción
     */
    private static void reiniciarSecuencia() {
        System.out.print("¿Reiniciar secuencia? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();
        
        if (confirmacion.equals("s") || confirmacion.equals("si") || confirmacion.equals("sí")) {
            arbol.limpiar();
            pasoActual = 0;
            System.out.println("✅ Secuencia reiniciada.");
        } else {
            System.out.println("❌ Operación cancelada.");
        }
    }

    /**
     * Espera a que el usuario presione Enter para continuar
     */
    private static void esperarEnter() {
        System.out.print("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
}