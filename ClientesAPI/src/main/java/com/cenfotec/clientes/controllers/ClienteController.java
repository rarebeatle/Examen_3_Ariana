package com.cenfotec.clientes.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.clientes.model.Cliente;
import com.cenfotec.clientes.repository.ClienteRepository;

@RestController
@RequestMapping({ "/clientes" })
public class ClienteController {
	private ClienteRepository repository;

	ClienteController(ClienteRepository clienteRepository) {
		this.repository = clienteRepository;
	}

	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Cliente> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		return repository.findById(id).map(record -> {
			record.setNombre(cliente.getNombre());
			record.setPrimer_apellido(cliente.getPrimer_apellido());
			record.setSegundo_apellido(cliente.getSegundo_apellido());
			record.setDireccion_casa(cliente.getDireccion_casa());
			record.setDireccion_cobro(cliente.getDireccion_cobro());
			record.setNumero_tarjeta(cliente.getNumero_tarjeta());
			record.setMes_vencimiento_tarjeta(cliente.getMes_vencimiento_tarjeta());
			record.setAnno_vencimiento_tarjeta(cliente.getAnno_vencimiento_tarjeta());
			Cliente updated = repository.save(record);
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
