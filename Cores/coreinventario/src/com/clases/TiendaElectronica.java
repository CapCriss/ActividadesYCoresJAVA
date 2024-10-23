package com.clases;

import java.util.ArrayList;
import java.util.Iterator;

public class TiendaElectronica {
	
	// Variables
	ArrayList<ProductoElectrodomestico> listaDeProductos = new ArrayList<>();
	
	
	
	// Constructor
	
	// Métodos: 
		// Agregar producto al inventario
	public void agregarProducto(ProductoElectrodomestico producto) {
		listaDeProductos.add(producto);
		System.out.println("PRODUCTO AGREGADO: " + producto.getNombre()  + " AL INVENTARIO");

	}
	
	
		// Mostrar todos los productos
	public void mostrarTodosLosProductos() {
		if (listaDeProductos.isEmpty()) { // si la lista está vacía
			System.out.println("NO HAY PRODUCTOS EN INVENTARIO.");
		}else {
			System.out.println("PRODUCTOS DISPONIBLES: \n");
			 for (ProductoElectrodomestico productoElectrodomestico : listaDeProductos) {
				System.out.println(productoElectrodomestico.mostrarInformacion());
			}
		}
		
	}
	// Buscar un producto
	public ProductoElectrodomestico buscarProducto(String nombre) {
		
		for (ProductoElectrodomestico productoElectrodomestico : listaDeProductos) {
			if (productoElectrodomestico.getNombre().equalsIgnoreCase(nombre)) { // Comparo ignorando las mayúsculas para evitar errores
				return productoElectrodomestico;
			}
		}
		System.out.println("EL PRODUCTO: " + nombre + "NO FUE ENCONTRADO.");
		return null;
		
	}
	
	// Realizar venta
	public void realizarVenta(String nombreProducto) {
		ProductoElectrodomestico productoAvender = buscarProducto(nombreProducto);
		if (productoAvender != null) {
			if (productoAvender.getCantidadDisponible() > 0) {
				productoAvender.reducirCantidadDisponible();
				System.out.println("VENTA REALIZADA QUEDAN: \n" + productoAvender.getCantidadDisponible() + " UNIDADES DE: " + productoAvender.getNombre());
			}else {
				System.out.println("PRODUCTO NO DISPONIBLE");
			}
		}
	}
	
}
