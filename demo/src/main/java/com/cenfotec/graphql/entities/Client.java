package com.cenfotec.graphql.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "primer_apellido", nullable = false)
	private String primerApellido;
	@Column(name = "segundo_apellido")
	private String segundoApellido;
	@Column(name = "direccion_casa")
	private String direccionCasa;
	@Column(name = "direccion_cobro", nullable = false)
	private String direccionCobro;
	@Column(name = "numero_tarjeta", nullable = false)
	private int numeroTarjeta;
	@Column(name = "mes_vencimiento_tarjeta", nullable = false)
	private int mesVencimientoTarjeta;
	@Column(name = "anno_vencimiento_tarjeta", nullable = false)
	private int annoVencimientoTarjeta;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public String getDireccionCasa() {
		return direccionCasa;
	}

	public String getDireccionCobro() {
		return direccionCobro;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public int getMesVencimientoTarjeta() {
		return mesVencimientoTarjeta;
	}

	public int getAnnoVencimientoTarjeta() {
		return annoVencimientoTarjeta;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrimerApellido(String lastName) {
		this.primerApellido = lastName;
	}

	public void setSegundoApellido(String secondLastName) {
		this.segundoApellido = secondLastName;
	}

	public void setDireccionCasa(String address) {
		this.direccionCasa = address;
	}

	public void setDireccionCobro(String paymentAddress) {
		this.direccionCobro = paymentAddress;
	}

	public void setNumeroTarjeta(int cardNumber) {
		this.numeroTarjeta = cardNumber;
	}

	public void setMesVencimientoTarjeta(int cardNumberDueMonth) {
		this.mesVencimientoTarjeta = cardNumberDueMonth;
	}

	public void setAnnoVencimientoTarjeta(int cardNumberDueYear) {
		this.annoVencimientoTarjeta = cardNumberDueYear;
	}
}
