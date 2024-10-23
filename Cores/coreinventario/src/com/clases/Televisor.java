package com.clases;

public class Televisor extends ProductoElectrodomestico{
	
	// Variables
	String tamanoPantalla;
	String resolucion;
	
	// Constructor
	public Televisor(String nombre, double precio, int cantidadDisponible, String tamanoPantalla, String resolucion) {
		super(nombre, precio, cantidadDisponible);
		this.tamanoPantalla = tamanoPantalla;
		this.resolucion = resolucion;
	}
	
	// Mostrar información específica del TELEVISOR
	
	public String mostrarInformacion() {
		return "\n" + "Televisor = [NOMBRE: " + nombre  + "PRECIO: " + precio + " CANTIDAD DISPONIBLE: "  +  cantidadDisponible  + " TAMAÑO DE PANTALLA: " + tamanoPantalla + " RESOLUCIÓN: " + resolucion + "]" + "\n";
	}
	
}
