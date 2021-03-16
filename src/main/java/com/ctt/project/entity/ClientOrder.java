package com.ctt.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ctt.project.dto.request.ClientOrderRequest;

import lombok.Data;

@Data
@Entity
 	public class ClientOrder {
	
	public ClientOrder(ClientOrderRequest clientOrderRequest, Client client, Payment payment, OrderStatus orderStatus, ArrayList<Product> products) {
		this.fillfromDto(clientOrderRequest);
		this.setClient(client);
		this.setPayment(payment);
		this.setStatus(orderStatus);
		this.setProducts(products);
	}
	
	
	
	public void fillfromDto(ClientOrderRequest clientOrderRequest) {
		this.setDeliveredAddress(clientOrderRequest.getDeliveredAddress());
		this.setDate(clientOrderRequest.getDate());
		this.setCode(clientOrderRequest.getCode());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String deliveredAddress;

	private Date date;

	private String code;

	@OneToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "orderStatus_id")
	private OrderStatus status;

	@OneToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;

	
	@OneToMany
	private List<Product> products = new ArrayList<Product>();

}
