
package com.jtsystem.modelo;
import java.text.NumberFormat;
import java.util.Locale;

public class Producto {

    // Atributos privados (encapsulamiento)
    private int codigo;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(int codigo, String nombre, String categoria,
                    double precio, int cantidad) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Metodo para calcular el valor total del producto
    public double calcularValorTotal() {
        return precio * cantidad;
    }

    // Metodo para mostrar informacion
   public void mostrarInformacion() {

    NumberFormat formato = NumberFormat.getNumberInstance(
    Locale.forLanguageTag("es-CO")
);

    formato.setMaximumFractionDigits(0);

    System.out.println("--------------------------------");
    System.out.println("Codigo: " + codigo);
    System.out.println("Nombre: " + nombre);
    System.out.println("Categoria: " + categoria);
    System.out.println("Precio: $" + formato.format(precio));
    System.out.println("Cantidad: " + cantidad);
    System.out.println("Valor total: $" + formato.format(calcularValorTotal()));
    System.out.println("--------------------------------");
}
}
