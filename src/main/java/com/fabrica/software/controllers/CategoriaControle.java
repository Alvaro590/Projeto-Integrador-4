package com.fabrica.software.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.software.entities.Categoria;
import com.fabrica.software.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaControle {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list= service.findAll();
		return ResponseEntity.ok().body(list);				
				
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria u= service.findById(id);
		return ResponseEntity.ok().body(u);
	}

}
