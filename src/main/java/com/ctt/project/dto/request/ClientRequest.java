package com.ctt.project.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClientRequest {

	@Email
	private String email;

	@Size(min = 2, max = 255)
	private String address;

}
