package com.ctt.project.dto.response;

import com.ctt.project.entity.Client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientResponse {
	
	
	public ClientResponse(Client client) {
		this.setId(client.getId());
		this.setEmail(client.getEmail());
		this.setAddress(client.getAddress());
		
	}
	
	private Long id;
		
	private String email;
		
	private String address;

}
