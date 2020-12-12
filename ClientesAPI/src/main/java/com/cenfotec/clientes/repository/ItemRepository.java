package com.cenfotec.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.clientes.model.Item;

@Repository
public interface ItemRepository  extends JpaRepository<Item,Long>{
	

}
