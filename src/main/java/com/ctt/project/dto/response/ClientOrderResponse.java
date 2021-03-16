package com.ctt.project.dto.response;

import java.util.Date;

import com.ctt.project.entity.ClientOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientOrderResponse {
	

	public ClientOrderResponse(ClientOrder clientOrder) {
		this.setDeliveredAddress(clientOrder.getDeliveredAddress());
		this.setDate(clientOrder.getDate());
		this.setCode(clientOrder.getCode());
	}

	private Long id;

	private String deliveredAddress;

	private Date date;

	private String code;

}
