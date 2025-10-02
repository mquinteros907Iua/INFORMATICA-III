package Practico6.structs;

public class AVLTree<T extends Comparable<T>> {
    
    /**
     * Clase interna que representa un nodo del árbol AVL.
     * Cada nodo contiene un dato, referencias a sus hijos y su altura.
     */
    private class NodoAVL {
        T dato;              // Dato almacenado en el nodo
        NodoAVL hijoIzquierdo;   // Hijo izquierdo
        NodoAVL hijoDerecho;     // Hijo derecho
        int altura;              // Altura del nodo en el árbol
        
        /**
         * Constructor del nodo AVL.
         * 
         * @param dato Dato a almacenar en el nodo
         */
        NodoAVL(T dato) {
            this.dato = dato;
            this.hijoIzquierdo = null;
            this.hijoDerecho = null;
            this.altura = 1; // Un nodo nuevo tiene altura 1
        }
    }
    
    private NodoAVL raiz;     // Raíz del árbol
    private int tamanio;      // Cantidad de nodos en el árbol
    
    /**
     * Constructor del árbol AVL.
     * Inicializa un árbol vacío.
     */
    public AVLTree() {
        this.raiz = null;
        this.tamanio = 0;
    }
    
    /**
     * Obtiene la altura de un nodo.
     * La altura de un nodo null es 0.
     * 
     * @param nodo Nodo del cual obtener la altura
     * @return Altura del nodo, 0 si el nodo es null
     */
    private int obtenerAltura(NodoAVL nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }
    
    /**
     * Calcula el factor de balance de un nodo.
     * Factor de Balance = altura(subárbol izquierdo) - altura(subárbol derecho)
     * 
     * Valores posibles después del balanceo:
     * - -1: subárbol derecho es 1 nivel más alto
     * -  0: subárboles tienen la misma altura
     * -  1: subárbol izquierdo es 1 nivel más alto
     * 
     * @param nodo Nodo del cual calcular el factor de balance
     * @return Factor de balance del nodo, 0 si el nodo es null
     */
    private int obtenerBalance(NodoAVL nodo) {
        return (nodo == null) ? 0 : obtenerAltura(nodo.hijoIzquierdo) - obtenerAltura(nodo.hijoDerecho);
    }
    
    /**
     * Actualiza la altura de un nodo basándose en las alturas de sus hijos.
     * Altura = 1 + máximo(altura hijo izquierdo, altura hijo derecho)
     * 
     * @param nodo Nodo cuya altura se debe actualizar
     */
    private void actualizarAltura(NodoAVL nodo) {
        if (nodo != null) {
            nodo.altura = 1 + Math.max(obtenerAltura(nodo.hijoIzquierdo), obtenerAltura(nodo.hijoDerecho));
        }
    }
    
    /**
     * Realiza una rotación simple a la derecha.
     * 
     * Caso de uso: Cuando el subárbol izquierdo es más pesado (Left-Left)
     * 
     * Estructura antes:        Estructura después:
     *       y                         x
     *      / \                       / \
     *     x   T3    ------>        T1   y
     *    / \                           / \
     *   T1  T2                        T2  T3
     * 
     * @param nodoY Nodo desbalanceado (pivote)
     * @return Nueva raíz del subárbol
     */
    private NodoAVL rotarDerecha(NodoAVL nodoY) {
        NodoAVL nodoX = nodoY.hijoIzquierdo;
        NodoAVL subArbolT2 = nodoX.hijoDerecho;
        
        // Realizar rotación
        nodoX.hijoDerecho = nodoY;
        nodoY.hijoIzquierdo = subArbolT2;
        
        // Actualizar alturas (importante: primero nodoY, luego nodoX)
        actualizarAltura(nodoY);
        actualizarAltura(nodoX);
        
        return nodoX; // Nueva raíz
    }
    
    /**
     * Realiza una rotación simple a la izquierda.
     * 
     * Caso de uso: Cuando el subárbol derecho es más pesado (Right-Right)
     * 
     * Estructura antes:      Estructura después:
     *     x                         y
     *    / \                       / \
     *   T1  y      ------>        x   T3
     *      / \                   / \
     *     T2  T3                T1  T2
     * 
     * @param nodoX Nodo desbalanceado (pivote)
     * @return Nueva raíz del subárbol
     */
    private NodoAVL rotarIzquierda(NodoAVL nodoX) {
        NodoAVL nodoY = nodoX.hijoDerecho;
        NodoAVL subArbolT2 = nodoY.hijoIzquierdo;
        
        // Realizar rotación
        nodoY.hijoIzquierdo = nodoX;
        nodoX.hijoDerecho = subArbolT2;
        
        // Actualizar alturas (importante: primero nodoX, luego nodoY)
        actualizarAltura(nodoX);
        actualizarAltura(nodoY);
        
        return nodoY; // Nueva raíz
    }
    
    /**
     * Inserta un nuevo valor en el árbol AVL.
     * Si el valor ya existe, no se inserta nuevamente.
     * Después de la inserción, el árbol se rebalancea automáticamente.
     * 
     * @param dato Dato a insertar
     * @return true si el dato se insertó exitosamente, false si ya existía
     */
    public boolean insertar(T dato) {
        if (dato == null) {
            throw new IllegalArgumentException("No se puede insertar un valor null");
        }
        
        int tamanioAnterior = tamanio;
        raiz = insertarRecursivo(raiz, dato);
        return tamanio > tamanioAnterior;
    }
    
    /**
     * Método recursivo auxiliar para insertar un valor en el árbol.
     * Después de cada inserción, verifica el balance y realiza rotaciones si es necesario.
     * 
     * Casos de desbalanceo y sus soluciones:
     * 1. Left-Left (LL):   Rotación simple derecha
     * 2. Right-Right (RR): Rotación simple izquierda
     * 3. Left-Right (LR):  Rotación izquierda en hijo izquierdo, luego rotación derecha
     * 4. Right-Left (RL):  Rotación derecha en hijo derecho, luego rotación izquierda
     * 
     * @param nodo Nodo actual en la recursión
     * @param dato Dato a insertar
     * @return Raíz del subárbol después de la inserción y balanceo
     */
    private NodoAVL insertarRecursivo(NodoAVL nodo, T dato) {
        // 1. Realizar inserción normal de BST
        if (nodo == null) {
            tamanio++;
            return new NodoAVL(dato);
        }
        
        int comparacion = dato.compareTo(nodo.dato);
        
        if (comparacion < 0) {
            nodo.hijoIzquierdo = insertarRecursivo(nodo.hijoIzquierdo, dato);
        } else if (comparacion > 0) {
            nodo.hijoDerecho = insertarRecursivo(nodo.hijoDerecho, dato);
        } else {
            // Valor duplicado, no se inserta
            return nodo;
        }
        
        // 2. Actualizar altura del nodo ancestro
        actualizarAltura(nodo);
        
        // 3. Obtener el factor de balance
        int factorBalance = obtenerBalance(nodo);
        
        // 4. Si el nodo está desbalanceado, hay 4 casos:
        
        // Caso Left-Left (LL)
        if (factorBalance > 1 && dato.compareTo(nodo.hijoIzquierdo.dato) < 0) {
            return rotarDerecha(nodo);
        }
        
        // Caso Right-Right (RR)
        if (factorBalance < -1 && dato.compareTo(nodo.hijoDerecho.dato) > 0) {
            return rotarIzquierda(nodo);
        }
        
        // Caso Left-Right (LR)
        if (factorBalance > 1 && dato.compareTo(nodo.hijoIzquierdo.dato) > 0) {
            nodo.hijoIzquierdo = rotarIzquierda(nodo.hijoIzquierdo);
            return rotarDerecha(nodo);
        }
        
        // Caso Right-Left (RL)
        if (factorBalance < -1 && dato.compareTo(nodo.hijoDerecho.dato) < 0) {
            nodo.hijoDerecho = rotarDerecha(nodo.hijoDerecho);
            return rotarIzquierda(nodo);
        }
        
        return nodo;
    }
    
    /**
     * Elimina un valor del árbol AVL.
     * Después de la eliminación, el árbol se rebalancea automáticamente.
     * 
     * @param dato Dato a eliminar
     * @return true si el dato se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminar(T dato) {
        if (dato == null) {
            return false;
        }
        
        int tamanioAnterior = tamanio;
        raiz = eliminarRecursivo(raiz, dato);
        return tamanio < tamanioAnterior;
    }
    
    /**
     * Método recursivo auxiliar para eliminar un valor del árbol.
     * 
     * Casos de eliminación:
     * 1. Nodo hoja: Simplemente se elimina
     * 2. Nodo con un hijo: Se reemplaza por su hijo
     * 3. Nodo con dos hijos: Se reemplaza por su sucesor inorden (mínimo del subárbol derecho)
     * 
     * Después de la eliminación, verifica el balance y realiza rotaciones si es necesario.
     * 
     * @param nodo Nodo actual en la recursión
     * @param dato Dato a eliminar
     * @return Raíz del subárbol después de la eliminación y balanceo
     */
    private NodoAVL eliminarRecursivo(NodoAVL nodo, T dato) {
        // 1. Realizar eliminación normal de BST
        if (nodo == null) {
            return null;
        }
        
        int comparacion = dato.compareTo(nodo.dato);
        
        if (comparacion < 0) {
            nodo.hijoIzquierdo = eliminarRecursivo(nodo.hijoIzquierdo, dato);
        } else if (comparacion > 0) {
            nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, dato);
        } else {
            // Nodo encontrado, proceder a eliminarlo
            tamanio--;
            
            // Caso 1: Nodo con un hijo o sin hijos
            if (nodo.hijoIzquierdo == null) {
                return nodo.hijoDerecho;
            } else if (nodo.hijoDerecho == null) {
                return nodo.hijoIzquierdo;
            }
            
            // Caso 2: Nodo con dos hijos
            // Obtener el sucesor inorden (mínimo del subárbol derecho)
            NodoAVL nodoSucesor = encontrarMinimo(nodo.hijoDerecho);
            nodo.dato = nodoSucesor.dato;
            nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, nodoSucesor.dato);
            tamanio++; // Compensar el decremento extra
        }
        
        // 2. Actualizar altura del nodo actual
        actualizarAltura(nodo);
        
        // 3. Obtener el factor de balance
        int factorBalance = obtenerBalance(nodo);
        
        // 4. Si el nodo está desbalanceado, hay 4 casos:
        
        // Caso Left-Left (LL)
        if (factorBalance > 1 && obtenerBalance(nodo.hijoIzquierdo) >= 0) {
            return rotarDerecha(nodo);
        }
        
        // Caso Left-Right (LR)
        if (factorBalance > 1 && obtenerBalance(nodo.hijoIzquierdo) < 0) {
            nodo.hijoIzquierdo = rotarIzquierda(nodo.hijoIzquierdo);
            return rotarDerecha(nodo);
        }
        
        // Caso Right-Right (RR)
        if (factorBalance < -1 && obtenerBalance(nodo.hijoDerecho) <= 0) {
            return rotarIzquierda(nodo);
        }
        
        // Caso Right-Left (RL)
        if (factorBalance < -1 && obtenerBalance(nodo.hijoDerecho) > 0) {
            nodo.hijoDerecho = rotarDerecha(nodo.hijoDerecho);
            return rotarIzquierda(nodo);
        }
        
        return nodo;
    }
    
    /**
     * Encuentra el nodo con el valor mínimo en un subárbol.
     * El mínimo siempre está en el nodo más a la izquierda.
     * 
     * @param nodo Raíz del subárbol
     * @return Nodo con el valor mínimo
     */
    private NodoAVL encontrarMinimo(NodoAVL nodo) {
        while (nodo.hijoIzquierdo != null) {
            nodo = nodo.hijoIzquierdo;
        }
        return nodo;
    }
    
    /**
     * Busca un valor en el árbol AVL.
     * 
     * @param dato Dato a buscar
     * @return true si el dato existe en el árbol, false en caso contrario
     */
    public boolean buscar(T dato) {
        if (dato == null) {
            return false;
        }
        return buscarRecursivo(raiz, dato);
    }
    
    /**
     * Método recursivo auxiliar para buscar un valor en el árbol.
     * 
     * @param nodo Nodo actual en la recursión
     * @param dato Dato a buscar
     * @return true si el dato se encuentra, false en caso contrario
     */
    private boolean buscarRecursivo(NodoAVL nodo, T dato) {
        if (nodo == null) {
            return false;
        }
        
        int comparacion = dato.compareTo(nodo.dato);
        
        if (comparacion < 0) {
            return buscarRecursivo(nodo.hijoIzquierdo, dato);
        } else if (comparacion > 0) {
            return buscarRecursivo(nodo.hijoDerecho, dato);
        } else {
            return true;
        }
    }
    
    /**
     * Obtiene la cantidad de nodos en el árbol.
     * 
     * @return Número de elementos en el árbol
     */
    public int obtenerTamanio() {
        return tamanio;
    }
    
    /**
     * Verifica si el árbol está vacío.
     * 
     * @return true si el árbol no tiene nodos, false en caso contrario
     */
    public boolean estaVacio() {
        return tamanio == 0;
    }
    
    /**
     * Obtiene la altura del árbol.
     * Un árbol vacío tiene altura 0.
     * Un árbol con solo la raíz tiene altura 1.
     * 
     * @return Altura del árbol
     */
    public int obtenerAlturaArbol() {
        return obtenerAltura(raiz);
    }
    
    /**
     * Encuentra el valor mínimo en el árbol.
     * 
     * @return Valor mínimo del árbol
     * @throws IllegalStateException si el árbol está vacío
     */
    public T encontrarValorMinimo() {
        if (estaVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return encontrarMinimo(raiz).dato;
    }
    
    /**
     * Encuentra el valor máximo en el árbol.
     * El máximo siempre está en el nodo más a la derecha.
     * 
     * @return Valor máximo del árbol
     * @throws IllegalStateException si el árbol está vacío
     */
    public T encontrarValorMaximo() {
        if (estaVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        
        NodoAVL nodoActual = raiz;
        while (nodoActual.hijoDerecho != null) {
            nodoActual = nodoActual.hijoDerecho;
        }
        return nodoActual.dato;
    }
    
    /**
     * Realiza un recorrido inorden (izquierda-raíz-derecha) del árbol.
     * Este recorrido visita los nodos en orden ascendente.
     * 
     * @return String con los elementos en orden ascendente
     */
    public String recorridoInorden() {
        StringBuilder constructor = new StringBuilder();
        recorridoInordenRecursivo(raiz, constructor);
        return constructor.toString().trim();
    }
    
    /**
     * Método recursivo auxiliar para el recorrido inorden.
     * 
     * @param nodo Nodo actual en la recursión
     * @param constructor StringBuilder para construir el resultado
     */
    private void recorridoInordenRecursivo(NodoAVL nodo, StringBuilder constructor) {
        if (nodo != null) {
            recorridoInordenRecursivo(nodo.hijoIzquierdo, constructor);
            constructor.append(nodo.dato).append(" ");
            recorridoInordenRecursivo(nodo.hijoDerecho, constructor);
        }
    }
    
    /**
     * Realiza un recorrido preorden (raíz-izquierda-derecha) del árbol.
     * 
     * @return String con los elementos en preorden
     */
    public String recorridoPreorden() {
        StringBuilder constructor = new StringBuilder();
        recorridoPreordenRecursivo(raiz, constructor);
        return constructor.toString().trim();
    }
    
    /**
     * Método recursivo auxiliar para el recorrido preorden.
     * 
     * @param nodo Nodo actual en la recursión
     * @param constructor StringBuilder para construir el resultado
     */
    private void recorridoPreordenRecursivo(NodoAVL nodo, StringBuilder constructor) {
        if (nodo != null) {
            constructor.append(nodo.dato).append(" ");
            recorridoPreordenRecursivo(nodo.hijoIzquierdo, constructor);
            recorridoPreordenRecursivo(nodo.hijoDerecho, constructor);
        }
    }
    
    /**
     * Realiza un recorrido postorden (izquierda-derecha-raíz) del árbol.
     * 
     * @return String con los elementos en postorden
     */
    public String recorridoPostorden() {
        StringBuilder constructor = new StringBuilder();
        recorridoPostordenRecursivo(raiz, constructor);
        return constructor.toString().trim();
    }
    
    /**
     * Método recursivo auxiliar para el recorrido postorden.
     * 
     * @param nodo Nodo actual en la recursión
     * @param constructor StringBuilder para construir el resultado
     */
    private void recorridoPostordenRecursivo(NodoAVL nodo, StringBuilder constructor) {
        if (nodo != null) {
            recorridoPostordenRecursivo(nodo.hijoIzquierdo, constructor);
            recorridoPostordenRecursivo(nodo.hijoDerecho, constructor);
            constructor.append(nodo.dato).append(" ");
        }
    }
    
    /**
     * Limpia el árbol, eliminando todos los nodos.
     */
    public void limpiar() {
        raiz = null;
        tamanio = 0;
    }
    
    /**
     * Verifica si el árbol está balanceado correctamente (propiedad AVL).
     * Útil para propósitos de debugging y testing.
     * 
     * @return true si el árbol cumple con las propiedades AVL, false en caso contrario
     */
    public boolean estaBalanceado() {
        return estaBalanceadoRecursivo(raiz);
    }
    
    /**
     * Método recursivo auxiliar para verificar si el árbol está balanceado.
     * 
     * @param nodo Nodo actual en la recursión
     * @return true si el subárbol está balanceado, false en caso contrario
     */
    private boolean estaBalanceadoRecursivo(NodoAVL nodo) {
        if (nodo == null) {
            return true;
        }
        
        int factorBalance = obtenerBalance(nodo);
        
        // Verificar que el factor de balance esté en el rango válido [-1, 1]
        if (Math.abs(factorBalance) > 1) {
            return false;
        }
        
        // Verificar recursivamente los subárboles
        return estaBalanceadoRecursivo(nodo.hijoIzquierdo) && estaBalanceadoRecursivo(nodo.hijoDerecho);
    }
    
    /**
     * Imprime el árbol en formato visual (rotado 90 grados).
     * Útil para visualizar la estructura del árbol.
     */
    public void imprimirArbol() {
        if (estaVacio()) {
            System.out.println("El árbol está vacío");
            return;
        }
        imprimirArbolRecursivo(raiz, "", true);
    }
    
    /**
     * Método recursivo auxiliar para imprimir el árbol en formato visual.
     * 
     * @param nodo Nodo actual
     * @param prefijo Prefijo para la indentación
     * @param esHijoDerecho Indica si el nodo es hijo derecho
     */
    private void imprimirArbolRecursivo(NodoAVL nodo, String prefijo, boolean esHijoDerecho) {
        if (nodo != null) {
            System.out.println(prefijo + (esHijoDerecho ? "└── " : "┌── ") + nodo.dato + " (h:" + nodo.altura + ")");
            
            if (nodo.hijoIzquierdo != null || nodo.hijoDerecho != null) {
                if (nodo.hijoDerecho != null) {
                    imprimirArbolRecursivo(nodo.hijoDerecho, prefijo + (esHijoDerecho ? "    " : "│   "), true);
                }
                if (nodo.hijoIzquierdo != null) {
                    imprimirArbolRecursivo(nodo.hijoIzquierdo, prefijo + (esHijoDerecho ? "    " : "│   "), false);
                }
            }
        }
    }
    
    /**
     * Retorna una representación en String del árbol (recorrido inorden).
     * 
     * @return String con los elementos del árbol en orden ascendente
     */
    @Override
    public String toString() {
        if (estaVacio()) {
            return "[]";
        }
        return "[" + recorridoInorden() + "]";
    }
}
