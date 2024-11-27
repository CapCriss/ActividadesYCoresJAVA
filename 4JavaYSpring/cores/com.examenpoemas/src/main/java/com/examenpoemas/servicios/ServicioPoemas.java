package com.examenpoemas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenpoemas.modelos.Poema;
import com.examenpoemas.repositorios.RepositorioPoemas;

@Service
public class ServicioPoemas {
	@Autowired
	RepositorioPoemas repositorioPoemas;
	
	public Poema crearPoema(Poema poema) {
		return this.repositorioPoemas.save(poema);
	}
	public Poema obtenerPoemaPorId(Long id) {
		return this.repositorioPoemas.findById(id).orElse(null);
	}
	public List<Poema> obtenerTodosLosPoemas(){
		return (List<Poema>) this.repositorioPoemas.findAll();
	}
	public Poema actualizarPoema(Poema poema) {
		return this.repositorioPoemas.save(poema);
	}
	public void eliminarPoemaPorId(Long id) {
		this.repositorioPoemas.deleteById(id);
	}
	
}
