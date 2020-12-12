package com.cenfotec.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.clientes.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	

}
