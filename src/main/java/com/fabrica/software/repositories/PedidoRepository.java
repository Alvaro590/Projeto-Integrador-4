package com.fabrica.software.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabrica.software.entities.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
