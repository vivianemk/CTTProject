package com.ctt.project.dto.response;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ctt.project.entity.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResponse {
	
	public CategoryResponse(Category category) {
		this.setName(category.getName());
		this.setCode(category.getCode());
	}
	
	private Long id;
	
	private String name;
	
	private String code;

}
