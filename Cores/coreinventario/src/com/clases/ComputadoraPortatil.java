package com.clases;


public class ComputadoraPortatil extends ProductoElectrodomestico{
	// Variables
	String marca;
	int memoriaRAM;
	int numSerie;
	
	//Constructor
	public ComputadoraPortatil(String nombre, double precio, int cantidadDisponible, String marca, int memoriaRAM,
		int numSerie) {
		super(nombre, precio, cantidadDisponible);
		this.marca = marca;
		this.memoriaRAM = memoriaRAM;
		this.numSerie = numSerie;
	}
	
	// Mostrar información específica de la COMPUTADORA
	
	public String mostrarInformacion() {
		return  "\n" + "Computadora Portatil = [NOMBRE: " + nombre + "PRECIO: " + precio + " CANTIDAD DISPONIBLE: " + cantidadDisponible + " MARCA: " + marca + " MEMORIA RAM: " + memoriaRAM + " NUMERO DE SERIE: "
				+ numSerie + "]" + "\n";
	}
	
	
	
}
