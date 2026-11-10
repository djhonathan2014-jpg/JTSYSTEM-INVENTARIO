# JTSYSTEM - INVENTARIO

## Descripción del proyecto

JTSYSTEM - INVENTARIO es una aplicación de consola desarrollada en Java, orientada a objetos, que permite administrar un inventario de productos tecnológicos.

El sistema facilita el registro, consulta, búsqueda y eliminación de productos, además de calcular el valor total de cada producto y del inventario.

## Objetivo

Desarrollar una aplicación que permita aplicar los conceptos fundamentales de la programación orientada a objetos mediante la administración de un inventario tecnológico.

## Funcionalidades principales

- Registrar productos tecnológicos.
- Registrar equipos de cómputo con información adicional de marca y modelo.
- Mostrar todos los productos registrados.
- Buscar productos mediante su código.
- Eliminar productos del inventario.
- Calcular el valor total de cada producto.
- Calcular el valor económico total del inventario.
- Validar códigos duplicados y datos numéricos incorrectos.

## Tecnologías utilizadas

- Lenguaje de programación: Java.
- Entorno de desarrollo: Visual Studio Code.
- Estructuras de datos: ArrayList y arreglos.
- Interfaz: consola.
- Control de versiones: Git.

## Estructura del proyecto

```text
JTSYSTEM-INVENTARIO/
│
├── src/
│   └── com/
│       └── jtsystem/
│           ├── excepciones/
│           │   └── ProductoNoEncontradoException.java
│           │
│           ├── modelo/
│           │   ├── Producto.java
│           │   ├── EquipoComputo.java
│           │   └── Inventario.java
│           │
│           └── Main.java
│
├── out/
│
└── README.md
```

## Conceptos de programación orientada a objetos aplicados

- **Clases y objetos:** representación de los productos y del inventario.
- **Encapsulamiento:** atributos privados y métodos de acceso.
- **Herencia:** la clase EquipoComputo hereda de Producto.
- **Polimorfismo:** sobrescritura del método mostrarInformacion().
- **Excepciones:** manejo de productos no encontrados mediante una excepción personalizada.
- **Colecciones:** utilización de ArrayList para almacenar los productos.

## Ejecución del proyecto

El proyecto se puede compilar y ejecutar desde la terminal de Visual Studio Code utilizando el JDK de Java.

## Autor

Jhonathan Torres

Ingeniería de Sistemas - CUN

Proyecto académico: Mi primera aplicación orientada a objetos.