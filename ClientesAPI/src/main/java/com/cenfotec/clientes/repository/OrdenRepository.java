package com.cenfotec.clientes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.clientes.model.Item;
import com.cenfotec.clientes.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {




}
