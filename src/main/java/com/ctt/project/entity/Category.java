package com.ctt.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ctt.project.dto.request.CategoryRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Category {
	
	public Category(CategoryRequest categoryRequest) {
		this.fillFromDto(categoryRequest);
		
	}

	public void fillFromDto(CategoryRequest categoryRequest) {
		this.setName(categoryRequest.getName());
		this.setCode(categoryRequest.getCode());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255, unique = true)
	private String name;
	
	@Column(nullable = false, length = 5, unique = true)
	private String code;

}
