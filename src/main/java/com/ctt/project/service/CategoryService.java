package com.ctt.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctt.project.dto.request.CategoryRequest;
import com.ctt.project.dto.request.ProductRequest;
import com.ctt.project.dto.response.CategoryResponse;
import com.ctt.project.dto.response.ProductResponse;
import com.ctt.project.entity.Category;
import com.ctt.project.entity.Product;
import com.ctt.project.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//metodo de criacao do service (CRUD)
	public CategoryResponse create(CategoryRequest categoryRequest) {
		Category category = new Category(categoryRequest);
		Category categoryCreated = this.categoryRepository.saveAndFlush(category);
		
//		editar o campo code
		String code = category.getCode() + String.format("%02d", category.getId());
		categoryRequest.setCode(code);
		this.edit(category.getId(), categoryRequest);
		
		return new CategoryResponse(categoryCreated);
		
	}
	
	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}
	
	public CategoryResponse edit(Long id, CategoryRequest categoryRequest) {
		Category category = this.categoryRepository.findById(id).orElseThrow(RuntimeException::new);
		category.fillFromDto(categoryRequest);
		Category categoryCreated = this.categoryRepository.save(category);
		return new CategoryResponse(categoryCreated);
	}


}
