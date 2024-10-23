package com.clases;

public class ProductoElectrodomestico {
	// Variables
	String nombre;
	double precio;
	int cantidadDisponible;
	
	// Constructor
	public ProductoElectrodomestico(String nombre, double precio, int cantidadDisponible) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}
	// Sobrecarga del Contructor con canridadDisponible en 0
	public ProductoElectrodomestico(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = 0;
	}
	
	// Getters
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void reducirCantidadDisponible() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--; // Reducir la cantidad. Se usará al vender un producto.
        }
    }
	
	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	
	
	// Imprime los detalles del producto mostrarInformacion()
	public String mostrarInformacion() {
		return "ProductoElectrodomestico [nombre=" + nombre + ", precio=" + precio + ", cantidadDisponible="
				+ cantidadDisponible + "]" + "\n";
	}
}
