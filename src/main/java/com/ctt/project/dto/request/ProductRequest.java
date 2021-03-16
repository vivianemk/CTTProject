package com.ctt.project.dto.request;

import java.util.List;

import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class ProductRequest {	
	
	private String name;
	
	@NotNull
	@Positive
	private Long idCategory;
	

	private Double price;
	
	
	private List<String> details;

}
