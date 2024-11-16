package com.canciones.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.canciones.modelos.Cancion;

@Repository
public interface RepositorioCanciones  extends CrudRepository<Cancion, Long>{

}
