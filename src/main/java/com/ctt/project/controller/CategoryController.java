package com.ctt.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctt.project.dto.request.CategoryRequest;
import com.ctt.project.dto.request.ProductRequest;
import com.ctt.project.dto.response.CategoryResponse;
import com.ctt.project.dto.response.ProductResponse;
import com.ctt.project.entity.Category;
import com.ctt.project.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryResponse post(@Valid @RequestBody CategoryRequest categoryRequest) {
		return this.categoryService.create(categoryRequest);
	
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll(){
		List<Category> categories = this.categoryService.getAll();
		return ResponseEntity.ok().body(categories);
	}
	
	@PutMapping(path = "{id}", consumes = "application/json", produces = "application/json")
	public CategoryResponse put (@Valid @RequestBody CategoryRequest categoryRequest, @PathVariable Long id) {
		return this.categoryService.edit(id, categoryRequest);
	}
}
