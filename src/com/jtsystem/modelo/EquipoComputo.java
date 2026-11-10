
package com.jtsystem.modelo;

public class EquipoComputo extends Producto {

    // Atributos propios de los equipos de computo
    private String marca;
    private String modelo;

    // Constructor
    public EquipoComputo(int codigo, String nombre, String categoria,
                        double precio, int cantidad,
                        String marca, String modelo) {

        super(codigo, nombre, categoria, precio, cantidad);

        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Sobrescritura del metodo mostrarInformacion
    @Override
    public void mostrarInformacion() {

        System.out.println("===== EQUIPO DE COMPUTO =====");

        super.mostrarInformacion();

        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);

        System.out.println("=============================");
    }
}
