## 🍕 Sistema de Gestión de Pedidos en una Pizzería

## 📌 Objetivo del Proyecto

Desarrollar un sistema en Java para gestionar los pedidos de una pizzería, aplicando tres algoritmos de ordenamiento (Inserción, Shellsort y Quicksort) con el fin de organizar los pedidos según diferentes criterios:

Tiempo de preparación
Precio total
Nombre del cliente

## 🏷️ Contexto del Caso Real

En una pizzería, la gestión eficiente de los pedidos es fundamental para que los clientes reciban sus órdenes en tiempo y forma.
Este sistema permitirá al encargado:

Priorizar pedidos según el tiempo de preparación (optimización en cocina).
Ordenar por precio total (control contable).
Ordenar alfabéticamente por nombre del cliente (gestión administrativa).

## 📂 Estructura del Proyecto
/gestion-pizzeria
│
├── /src
│   ├── Main.java               # Punto de entrada del sistema
│   ├── Pedido.java             # Clase que representa un pedido
│   ├── Pizzeria.java           # Clase que gestiona los pedidos de la pizzería
│   ├── Ordenador.java          # Implementación de algoritmos de ordenamiento
│   └── TiempoOrdenamiento.java # Medición de tiempos de ejecución
│
└── README.md                   # Documentación del proyecto

## ⚙️ Funcionalidades Principales

Gestión de Pedidos
Agregar y eliminar pedidos.
Actualizar información (tiempo de preparación, precio total, etc.).
Ordenamiento de Pedidos
Por Tiempo de Preparación → Inserción.
Por Precio Total → Shellsort.
Por Nombre del Cliente → Quicksort.
Captura de Tiempos de Ejecución
Medición y visualización de tiempos de ejecución de los algoritmos con distintos tamaños de listas (100, 1000 y 10000 pedidos).

## 🖥️ Ejemplo de Uso

Escenario: El encargado necesita priorizar los pedidos por tiempo de preparación.
Acción: Selecciona la opción de ordenar por tiempo.
Resultado: El sistema ordena los pedidos usando Inserción, mostrando cuál debe prepararse primero.