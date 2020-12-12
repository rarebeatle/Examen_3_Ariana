package com.cenfotec.graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.graphql.entities.Client;
import com.cenfotec.graphql.services.ClientService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class ClientMutation implements GraphQLMutationResolver {

	@Autowired
	private ClientService clientService;

	public Client createClient(String name, String lastName, String secondLastName, String address, String paymentAddress, int cardNumber, int cardNumberDueMonth, int cardNumberDueYear) {
		return this.clientService.createClient(name, lastName, secondLastName, address, paymentAddress, cardNumber, cardNumberDueMonth, cardNumberDueYear);
	}
	
	public boolean deleteClient(int id) {
		return this.clientService.deleteVehicle(id);
	}

}
