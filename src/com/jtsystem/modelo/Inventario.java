
package com.jtsystem.modelo;

import java.util.ArrayList;
import com.jtsystem.excepciones.ProductoNoEncontradoException;


public class Inventario {

    // Lista que almacena los productos
    private ArrayList<Producto> productos;

    // Constructor
    public Inventario() {
        productos = new ArrayList<>();
    }

    // Agregar un producto al inventario
public void agregarProducto(Producto producto) {

    if (producto == null) {
        System.out.println("Error: El producto no puede estar vacio.");
        return;
    }

    for (Producto existente : productos) {

        if (existente.getCodigo() == producto.getCodigo()) {
            System.out.println("Error: Ya existe un producto con ese codigo.");
            return;
        }
    }

    productos.add(producto);
    System.out.println("Producto registrado correctamente.");
}

    // Mostrar todos los productos
    public void mostrarProductos() {

        if (productos.isEmpty()) {
            System.out.println("El inventario esta vacio.");
            return;
        }

        double valorTotal = 0;

        System.out.println("\n===== INVENTARIO TECNOLOGICO =====");

        for (Producto producto : productos) {

            producto.mostrarInformacion();

            valorTotal += producto.calcularValorTotal();
        }

        java.text.NumberFormat formato =
        java.text.NumberFormat.getInstance(
                java.util.Locale.forLanguageTag("es-CO")
        );

formato.setMaximumFractionDigits(0);

System.out.println("VALOR TOTAL DEL INVENTARIO: $" + formato.format(valorTotal));
        System.out.println("Total de productos registrados: " + productos.size());
    }

    // Buscar un producto por su codigo
    public Producto buscarPorCodigo(int codigo)
            throws ProductoNoEncontradoException {

        for (Producto producto : productos) {

            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }

        throw new ProductoNoEncontradoException(
            "No se encontro ningun producto con el codigo: " + codigo
        );

    }
    // Eliminar un producto por su codigo
public void eliminarPorCodigo(int codigo)
        throws ProductoNoEncontradoException {

    Producto producto = buscarPorCodigo(codigo);

    productos.remove(producto);

    System.out.println("Producto eliminado correctamente.");
}
}
