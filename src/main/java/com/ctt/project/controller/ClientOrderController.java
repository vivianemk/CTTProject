package com.ctt.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctt.project.dto.request.ClientOrderRequest;
import com.ctt.project.dto.response.ClientOrderResponse;
import com.ctt.project.service.ClientOrderService;

@RestController
public class ClientOrderController {
	@Autowired
	public ClientOrderService clientOrderService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ClientOrderResponse post (@Valid @RequestBody ClientOrderRequest clientOrderRequest ) {
		return clientOrderService.create(clientOrderRequest);
	}

}
