package com.cenfotec.clientes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.clientes.model.Item;
import com.cenfotec.clientes.model.Orden;
import com.cenfotec.clientes.repository.OrdenRepository;

@RestController
@RequestMapping({ "/ordenes" })

public class OrdenController {

	private OrdenRepository repository;

	OrdenController(OrdenRepository ordenRepository) {
		this.repository = ordenRepository;
	}

	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Orden> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@ResponseBody
	@RequestMapping(value = "/items/{idItem}", method = RequestMethod.GET)
	public List<Orden> findByIdItem(@PathVariable long idItem) {
		List<Orden> listOrdenes = repository.findAll();
		List<Orden> listOrdenesId = new ArrayList<Orden>();
		
		for(int i=0;i<listOrdenes.size();i++) {
			if(listOrdenes.get(i).getItem().getId() == idItem) {
				listOrdenesId.add(listOrdenes.get(i));
			}
		}
		
		return listOrdenesId;

	}

	@PostMapping
	public Orden create(@RequestBody Orden orden) {
		return repository.save(orden);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Orden> update(@PathVariable("id") long id, @RequestBody Orden orden) {
		return repository.findById(id).map(record -> {
			record.setCliente(orden.getCliente());
			record.setItem(orden.getItem());
			record.setTotal_items(orden.getTotal_items());
			Orden updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
