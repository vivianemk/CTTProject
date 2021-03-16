package com.ctt.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctt.project.dto.request.ClientRequest;
import com.ctt.project.dto.response.ClientResponse;
import com.ctt.project.entity.Client;
import com.ctt.project.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping(consumes = "application/json", produces = "application/json" )
	@ResponseStatus(HttpStatus.CREATED)
	public ClientResponse post(@Valid @RequestBody ClientRequest clientRequest) {
		return this.clientService.create(clientRequest);
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ClientResponse put (@Valid @RequestBody ClientRequest clientRequest, @PathVariable Long id) {
		return this.clientService.edit(id, clientRequest);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> getAll(){
		List<Client> clients = this.clientService.getAll();
		return ResponseEntity.ok().body(clients);
	}
	@GetMapping(path = "/{id}", produces = "application/json")
	public Client getById(@PathVariable Long id) {
		return this.clientService.getById(id);
		
	}
	


}
