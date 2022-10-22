package com.fabrica.software.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.software.entities.Produto;
import com.fabrica.software.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoControle {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list= service.findAll();
		return ResponseEntity.ok().body(list);				
				
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto u= service.findById(id);
		return ResponseEntity.ok().body(u);
	}

}
