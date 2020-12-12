package com.cenfotec.graphql.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cenfotec.graphql.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.graphql.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepo;

	public List<Client> getAllClient(int count) {
		return this.clientRepo.findAll().stream().limit(count).collect(Collectors.toList());
	}

	public Optional<Client> getClient(int id) {
		return this.clientRepo.findById(id);
	}

	public Client createClient(String name, String lastName, String secondLastName, String address, String paymentAddress, int cardNumber, int cardNumberDueMonth, int cardNumberDueYear) {
		Client client = new Client();
		client.setNombre(name);
		client.setPrimerApellido(lastName);
		client.setSegundoApellido(secondLastName);
		client.setDireccionCasa(address);
		client.setDireccionCobro(paymentAddress);
		client.setNumeroTarjeta(cardNumber);
		client.setMesVencimientoTarjeta(cardNumberDueMonth);
		client.setAnnoVencimientoTarjeta(cardNumberDueYear);
		return this.clientRepo.save(client);
	}
	
	public boolean deleteVehicle(int id) {
		this.clientRepo.deleteById(id);
		return true;
	}

}
