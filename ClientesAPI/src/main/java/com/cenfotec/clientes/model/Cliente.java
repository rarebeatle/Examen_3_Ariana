package com.cenfotec.clientes.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Table (name = "CLIENTE")
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String direccion_casa;
	private String direccion_cobro;
	private int numero_tarjeta;
	private int mes_vencimiento_tarjeta;
	private int anno_vencimiento_tarjeta;

	//@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
	//private List<Orden> ordenes;
}
