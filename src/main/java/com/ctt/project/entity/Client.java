package com.ctt.project.entity;

//import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ctt.project.dto.request.ClientRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Client {
//	metodo construtor
	public Client(ClientRequest clientRequest) {
		this.fillFromDto(clientRequest);
	}
	
	public void fillFromDto(ClientRequest clientRequest) {
		this.setEmail(clientRequest.getEmail());
		this.setAddress(clientRequest.getAddress());
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80, unique = true)
	private String email;
	
	@Column(nullable = false, length = 255)
	private String address;
	
//	@OnetoMany
//	private List<String> orders;
	

}
