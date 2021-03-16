package com.ctt.project.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Payment {
	
	
	public Payment(String paymentProcessedAdress, String paymentType, String paymentStatus) {
		this.paymentProcessedAdress = paymentProcessedAdress;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String paymentProcessedAdress;
	
    private String paymentType;
	
	private String paymentStatus;
	

}
