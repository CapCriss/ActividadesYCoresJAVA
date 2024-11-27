package com.examenpoemas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examenpoemas.modelos.Poema;

@Repository
public interface RepositorioPoemas  extends CrudRepository<Poema, Long> {

}
