package com.ctt.project.dto.response;

import java.util.List;

import com.ctt.project.entity.Category;
import com.ctt.project.entity.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
	
	public ProductResponse(Product product) {
		this.setId(product.getId());
		this.setName(product.getName());
		this.setPrice(product.getPrice());
		this.setDetails(product.getDetails());
		
		CategoryResponse categoryResponse = new CategoryResponse(product.getCategory());
		this.setCategory(categoryResponse);
	}
	
    private Long id;
	
	private String name;
	
	private CategoryResponse category;
	
	private Double price;
		
	private List<String> details;


}
