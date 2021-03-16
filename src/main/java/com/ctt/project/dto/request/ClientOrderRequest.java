package com.ctt.project.dto.request;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;


@Data
public class ClientOrderRequest {

//	private Long id;

	private String deliveredAddress;

	private Date date;

	private String code;
 
	@NotNull
	@Positive
	private Long idClient;
	
	private String paymentType;
	
	private ArrayList<Long> products;
}
