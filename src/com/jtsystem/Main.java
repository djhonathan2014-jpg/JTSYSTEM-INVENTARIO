
package com.jtsystem;

import java.util.Scanner;

import com.jtsystem.modelo.Producto;
import com.jtsystem.modelo.EquipoComputo;
import com.jtsystem.modelo.Inventario;
import com.jtsystem.excepciones.ProductoNoEncontradoException;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Inventario inventario = new Inventario();

    // Arreglo de categorias disponibles
    private static String[] categorias = {
        "Computadores",
        "Perifericos",
        "Redes",
        "Almacenamiento",
        "Impresion",
        "Seguridad"
    };

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("\n======================================");
            System.out.println("       JTSYSTEM - INVENTARIO");
            System.out.println("======================================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto por codigo");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Actualizar producto");
            System.out.println("6. Salir");
            System.out.println("======================================");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        registrarProducto();
                        break;

                    case 2:
                        inventario.mostrarProductos();
                        break;

                    case 3:
                        buscarProducto();
                        break;

                    case 4:
                        eliminarProducto();
                        break;

                    case 5:
                        actualizarProducto();
                        break;

                    case 6:
    System.out.println("Gracias por utilizar JTSYSTEM.");
    break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
            }

        } while (opcion != 6);

        scanner.close();
    }

    // Registrar productos
    private static void registrarProducto() {

        System.out.println("\n===== REGISTRO DE PRODUCTOS =====");
        System.out.println("1. Producto general");
        System.out.println("2. Equipo de computo");

        int tipo = leerEntero("Seleccione el tipo de producto: ");

        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo de producto no valido.");
            return;
        }

        int codigo = leerEntero("Ingrese el codigo: ");

if (codigo <= 0) {
    System.out.println("Error: El codigo debe ser mayor que cero.");
    return;
}

        System.out.print("Ingrese el nombre: ");
String nombre = scanner.nextLine().trim();

if (nombre.isEmpty()) {
    System.out.println("Error: El nombre del producto no puede estar vacio.");
    return;
}

        System.out.println("\nCategorias disponibles:");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }

        int opcionCategoria = leerEntero("Seleccione una categoria: ");

        if (opcionCategoria < 1 || opcionCategoria > categorias.length) {
            System.out.println("Categoria no valida.");
            return;
        }

        String categoria = categorias[opcionCategoria - 1];

        double precio = leerDecimal("Ingrese el precio: ");
int cantidad = leerEntero("Ingrese la cantidad: ");

if (!Double.isFinite(precio) || precio <= 0) {
    System.out.println("Error: El precio debe ser un numero positivo y valido.");
    return;
}

if (cantidad < 0) {
    System.out.println("Error: La cantidad no puede ser negativa.");
    return;
}

        Producto producto;

        if (tipo == 2) {

            System.out.print("Ingrese la marca: ");
String marca = scanner.nextLine().trim();

if (marca.isEmpty()) {
    System.out.println("Error: La marca no puede estar vacia.");
    return;
}

System.out.print("Ingrese el modelo: ");
String modelo = scanner.nextLine().trim();

if (modelo.isEmpty()) {
    System.out.println("Error: El modelo no puede estar vacio.");
    return;
}

            producto = new EquipoComputo(
                codigo, nombre, categoria,
                precio, cantidad, marca, modelo
            );

        } else {

            producto = new Producto(
                codigo, nombre, categoria,
                precio, cantidad
            );
        }

        inventario.agregarProducto(producto);
    }

    // Buscar producto por codigo
    private static void buscarProducto() {

        System.out.println("\n===== BUSQUEDA DE PRODUCTO =====");

        int codigo = leerEntero("Ingrese el codigo que desea buscar: ");

        try {
            Producto producto = inventario.buscarPorCodigo(codigo);

            System.out.println("\nProducto encontrado:");
            producto.mostrarInformacion();

        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        
    }
    // Eliminar productos del inventario
private static void eliminarProducto() {

    System.out.println("\n===== ELIMINAR PRODUCTO =====");

    int codigo = leerEntero("Ingrese el codigo del producto que desea eliminar: ");

    try {
        inventario.eliminarPorCodigo(codigo);

    } catch (ProductoNoEncontradoException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
// Actualizar precio y cantidad de un producto
private static void actualizarProducto() {

    System.out.println("\n===== ACTUALIZAR PRODUCTO =====");

    int codigo = leerEntero("Ingrese el codigo del producto: ");

    double nuevoPrecio = leerDecimal("Ingrese el nuevo precio: ");

    int nuevaCantidad = leerEntero("Ingrese la nueva cantidad: ");

    try {
        inventario.actualizarProducto(
            codigo,
            nuevoPrecio,
            nuevaCantidad
        );

    } catch (ProductoNoEncontradoException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

    // Leer numeros enteros
    private static int leerEntero(String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero valido.");
            }
        }
    }

    // Leer numeros decimales
    private static double leerDecimal(String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }
}
