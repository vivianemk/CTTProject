package com.ctt.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctt.project.dto.request.ClientRequest;
import com.ctt.project.dto.response.ClientResponse;
import com.ctt.project.entity.Client;
import com.ctt.project.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository; 

	public ClientResponse create(ClientRequest clientRequest) {
		Client client = new Client (clientRequest);
		Client clientCreated= this.clientRepository.save(client);
		return new ClientResponse(clientCreated);
	}

	public ClientResponse edit(Long id, ClientRequest clientRequest) {
		Client client = this.clientRepository.findById(id).orElseThrow(RuntimeException::new);
		client.fillFromDto(clientRequest);
		Client clientCreated = this.clientRepository.save(client);
		return new ClientResponse(clientCreated);
	}
	public List<Client> getAll(){
		return this.clientRepository.findAll();
	}


	public Client getById(Long id){
		Optional<Client> clientOptional = this.clientRepository.findById(id);
		Client client = clientOptional.orElseThrow(RuntimeException::new);
		return client;
	}

}
