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
import com.cenfotec.clientes.model.Item;
import com.cenfotec.clientes.model.Orden;
import com.cenfotec.clientes.repository.ClienteRepository;
import com.cenfotec.clientes.repository.ItemRepository;

@RestController
@RequestMapping({ "/items" })
public class ItemController {

	private ItemRepository repository;

	ItemController(ItemRepository itemRepository) {
		this.repository = itemRepository;
	}

	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Item> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Item create(@RequestBody Item item) {
		return repository.save(item);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Item> update(@PathVariable("id") long id, @RequestBody Item item) {
		return repository.findById(id).map(record -> {
			record.setTipo(item.getTipo());
			record.setCosto(item.getCosto());
			record.setImg(item.getImg());
			Item updated = repository.save(record);
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
