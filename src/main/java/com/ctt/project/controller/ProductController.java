package com.ctt.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctt.project.dto.request.ProductRequest;
import com.ctt.project.dto.response.ProductResponse;
import com.ctt.project.entity.Product;
import com.ctt.project.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse post(@Valid @RequestBody ProductRequest productRequest) {
		return productService.create(productRequest);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		List<Product> products = this.productService.getAll();
		return ResponseEntity.ok().body(products);
	}
	@GetMapping("{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id){
		Product product = this.productService.getById(id);
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable Long id){
		List<Product> products = this.productService.getByCategory(id);
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping("/productByLowerPrice")
	public ResponseEntity<List<Product>> getAllByLowerPrice(){
		List<Product> products = this.productService.getAllByLowerPrice();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping("/productByHigherPrice")
	public ResponseEntity<List<Product>> getAllByHigherPrice(){
		List<Product> products = this.productService.getAllByHigherPrice();
		return ResponseEntity.ok().body(products);
	}

	
	@PutMapping(path = "{id}", consumes = "application/json", produces = "application/json")
	public ProductResponse put (@Valid @RequestBody ProductRequest productRequest, @PathVariable Long id) {
		return this.productService.edit(id, productRequest);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		this.productService.delete(id);
	}
	
	
}

