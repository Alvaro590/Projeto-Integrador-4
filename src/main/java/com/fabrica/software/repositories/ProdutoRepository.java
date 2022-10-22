package com.fabrica.software.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabrica.software.entities.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
