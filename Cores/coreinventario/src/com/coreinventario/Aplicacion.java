package com.coreinventario;

import com.clases.ComputadoraPortatil;
import com.clases.ProductoElectrodomestico;
import com.clases.Televisor;
import com.clases.TiendaElectronica;

public class Aplicacion {

	public static void main(String[] args) {
		
		// INSTANCIANDO Y MOSTRANDO INFO DE 2 TV
		ProductoElectrodomestico producto1 = new Televisor("Televisor Samsung", 120.000, 5, "32 pulgadas", "4k");
		ProductoElectrodomestico producto2 = new Televisor("Televisor LG", 120.000, 5, "40 pulgadas", "2k");
		System.out.println("TELEVISORES: " + producto1.mostrarInformacion() + producto2.mostrarInformacion());
		
		// INSTANCIANDO Y MOSTRANDO INFO DE 2 PC
		ProductoElectrodomestico producto3 = new ComputadoraPortatil("Notebook ASUS TUF 7.0", 400.000, 7, "ASUS", 32, 123);
		ProductoElectrodomestico producto4 = new ComputadoraPortatil("Notebook HP OAC 7.0", 250.000, 10, "HP", 16, 321);
		System.out.println("COMPUTADORES: " + producto3.mostrarInformacion() + producto4.mostrarInformacion());
		
		// VENTAS CON "producto1"
		TiendaElectronica tienda1 = new TiendaElectronica();
		tienda1.agregarProducto(producto1);
		tienda1.mostrarTodosLosProductos();
		tienda1.realizarVenta(producto1.getNombre());
		tienda1.agregarProducto(producto2);
		tienda1.agregarProducto(producto3);
		tienda1.agregarProducto(producto4);
		tienda1.mostrarTodosLosProductos();
		// tienda1.realizarVenta(producto1.getNombre());
		// tienda1.realizarVenta(producto1.getNombre());
		// tienda1.realizarVenta(producto1.getNombre());
		// tienda1.realizarVenta(producto1.getNombre());
		
		//PRODUCTO NO DISPONIBLE (no se puede ejecutar  la venta porque esta en 0)
		tienda1.realizarVenta(producto1.getNombre());
		
		//BUSCAR 
		// System.out.println(tienda1.buscarProducto(producto1.getNombre()).getCantidadDisponible());// no disponible (porque se vendieron todos)
		// System.out.println(tienda1.buscarProducto(producto2.getNombre()).getCantidadDisponible()); // pruebo con otro producto para verificar la cantidad disponible
		
		// MOSTAR TODOS LOS PRODUCTOS DISPONIBLES PARA COMPROBAR QUE SE AGREGARON CORRECTAMENTE.
		tienda1.mostrarTodosLosProductos();

	}

}
