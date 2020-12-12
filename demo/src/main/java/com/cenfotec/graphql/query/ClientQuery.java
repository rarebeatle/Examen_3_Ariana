package com.cenfotec.graphql.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.graphql.entities.Client;
import com.cenfotec.graphql.services.ClientService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class ClientQuery implements GraphQLQueryResolver {

	@Autowired
	private ClientService clientService;

	public List<Client> getClients(int count) {
		return this.clientService.getAllClient(count);
	}

	public Optional<Client> getClient(int id) {
		return this.clientService.getClient(id);
	}

}
