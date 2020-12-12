package com.cenfotec.clientes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ORDEN")
@Entity
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE" ,nullable=false)
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "ID_ITEM",  nullable=false)
	private Item item;
	
	private int total_items;
	
}
