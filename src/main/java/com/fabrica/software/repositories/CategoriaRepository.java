package com.fabrica.software.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabrica.software.entities.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
