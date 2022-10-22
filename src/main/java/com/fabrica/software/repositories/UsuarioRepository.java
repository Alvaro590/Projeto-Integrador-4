package com.fabrica.software.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabrica.software.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
